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

public class RootHandler extends Parser implements HttpHandler {

	public void handle(HttpExchange he) throws IOException {
		addCORS(he);
		String response = "Servidor Funcionando Correctamente en "
						  +he.getLocalAddress().getHostName()+":"+he.getLocalAddress().getPort();
		he.sendResponseHeaders(200, response.length());
		OutputStream os = he.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
}

