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

public class Cleaner extends Parser implements HttpHandler{

	private Contexto Ctx;
	
	public Cleaner(Contexto Ctx) {
		this.Ctx=Ctx;
	}
	
	public void handle(HttpExchange he) throws IOException {
		addCORS(he);
		this.Ctx.ClearData();
		String response = "Todos los Datos Eliminados";
		he.sendResponseHeaders(200, response.length());
		OutputStream os = he.getResponseBody();
		os.write(response.getBytes());
		os.close();		
	}
	
}
