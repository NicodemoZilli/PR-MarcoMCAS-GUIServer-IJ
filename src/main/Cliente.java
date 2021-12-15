package main;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class  Cliente extends Parser implements HttpHandler {
	
	private Contexto Ctx;
	
	public Cliente(Contexto Ctx) {
		this.Ctx = Ctx;
	}

	public void handle(HttpExchange he) throws IOException {
		
		String response;
		try {
			addCORS(he);
			if(this.Ctx.isComplete()) {
				Ctx.Ejecutar();
				response = Ctx.getResponse();
			}else {
				response = "{\"message\":"
							+ "{\"tit\":\"Error\","
							+ "\"msj\":\"No se han establecido todos los datos necesarios, "
							+ "Intente de nuevo\","
							+ "\"icon\":\"error\"}}";
			}
		}catch(Exception e) {
			response = "{\"message\":"
					 	+ "{\"tit\":\"Error\","
					 	+ "\"msj\":\""+e.getMessage()+"\","
					 	+ "\"icon\":\"error\"}}";
		}
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.getBytes());
			os.close();
	}
}