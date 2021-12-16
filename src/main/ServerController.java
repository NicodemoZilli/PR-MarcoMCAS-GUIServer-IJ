package main;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;

import com.sun.net.httpserver.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class ServerController {

	 @FXML
	    private Button detener;

	    @FXML
	    private Button estado;

	    @FXML
	    private Button iniciar;
	    
	    @FXML
	    private TextArea textA;
	 
	    @FXML
	    private Button puerto;

		private String console;
		private int port;
		private HttpServer server;
		private Contexto Ctx;
	
	@FXML
    public void initialize() {
		this.detener.setDisable(true);
		this.console="";
		this.port=9009;
		this.server=null;
		this.Ctx= new Contexto();
    }
	
	@FXML
    void exit(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmar Salida");
		alert.setHeaderText("Estas saliendo de la aplicación");
		alert.setContentText("¿Deseas continuar?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			System.exit(0);
		}
	}

    @FXML
    void minimize(ActionEvent event) {
    	((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }
    
    @FXML
    void start(ActionEvent event) {
    	try {
	    	log("Iniciando Servidor...");
	    	server = HttpServer.create(new InetSocketAddress(port), 0);
			server.createContext("/", new RootHandler());			
			server.createContext("/setCat", new SetCat(this.Ctx));
			server.createContext("/setMet", new SetMet(this.Ctx));
			server.createContext("/setDat", new SetDat(this.Ctx));
			server.createContext("/Execute", new Cliente(this.Ctx));
			server.createContext("/DeleteData", new Cleaner(this.Ctx));			
			server.setExecutor(null);
			server.start();
			this.iniciar.setDisable(true);
			this.detener.setDisable(false);
			this.puerto.setDisable(true);
	    	log("Servidor iniciado en el puerto: "+this.port);
    	}catch(IOException e) {
        	log(e.getMessage());
    	}
    }
    
    @FXML
    void stop(ActionEvent event) {
    	try {
    		log("Deteniendo Servidor...");
        	this.server.stop(0);
        	this.iniciar.setDisable(false);
    		this.detener.setDisable(true);
    		this.puerto.setDisable(false);
        	log("Servidor detenido");
    	}catch(Exception e) {
        	log(e.getMessage());
    	}
    }


    @FXML
    void status(ActionEvent event){
    	try {
			 	URL url = new URL("http://localhost:"+this.port+"/");
			 	URLConnection ur = url.openConnection();
	        	BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                        ur.getInputStream()));
			    String inputLine;
			
			    while ((inputLine = in.readLine()) != null) 
			        log(inputLine);
			    in.close();
    	}catch(IOException e) {
        	log(e.getMessage());

    	}      
    }

    @FXML
    void change(ActionEvent event) {
    	
        this.port = getPort();
    	log("Puerto cambiado a: "+this.port);
    }
    
  
    //Codigo para obtener el puerto desde input
    private int getPort() {

		boolean ban=true;
		int x=port;
		while(ban) {
			try {
				String sp=null;
				TextInputDialog dialog = new TextInputDialog(this.port+"");
				dialog.setTitle("Puerto");
		        dialog.setHeaderText("Ingresa un numero para el puerto:");
		        dialog.setContentText("Puerto:");
		        sp = dialog.showAndWait().get();

				if(sp!=null) {
					if(sp.length()>0) {
						x = Integer.parseInt(sp);
						if(x>8000) ban = false;
						else {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Puerto");
							alert.setHeaderText("Numero de Puerto Incorrecto");
							alert.setContentText("El numero minimo es 8000!");
							alert.showAndWait();
						}
					}else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Puerto");
						alert.setHeaderText("Ingresa un Valor");
						alert.setContentText("El numero minimo es 8000!");
						alert.showAndWait();
					}
				}else {
					ban=false;
				}
			}catch(NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Puerto");
				alert.setHeaderText("Lo sentimos hubo un error!");
				alert.setContentText("Intenta ingresando un valor numerico");
				alert.showAndWait();
			}
		}
		return x;
	}
    

    //Codigo para la consola de la ventana
    
    void log(String cad) {
    	this.console+= cad+"\n";
    	print();
    }
    
    void print() {
    	String[] lines =this.console.split("\n");
    	String aux="";
        for(int i=0; i<lines.length; i++){
            aux+= (i+1)+"   "+lines[i]+"\n";
        }
       this.textA.setText(aux);
       this.textA.selectPositionCaret(this.textA.getLength()-1); 
    }
    
    void clear() {
    	this.console="";
    	print();
    }
    
    

}