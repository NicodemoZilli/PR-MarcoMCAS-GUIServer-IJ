package main;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SetDat extends Parser implements HttpHandler {

	private Contexto Ctx;
	
	public SetDat(Contexto Ctx) {
		this.Ctx = Ctx; 
	} 
	
	public void handle(HttpExchange he) throws IOException {
		addCORS(he);
		
		InputStreamReader isr = new InputStreamReader(he.getRequestBody(), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String query = br.readLine();
		this.Ctx.getDatos().clear();
		parseQuery(query, this.Ctx.getDatos());
		String response = "Datos Agregados";
		he.sendResponseHeaders(200, response.length());
		OutputStream os = he.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
}

