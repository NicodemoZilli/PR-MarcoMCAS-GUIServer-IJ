package main;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

public abstract class Parser {

	@SuppressWarnings("unchecked")
	public static void parseQuery(String query, Map<String, Object> parameters) throws UnsupportedEncodingException {

		if (query != null) {
			String pairs[] = query.split("[&]");
			for (String pair : pairs) {
				String param[] = pair.split("[=]");
				String key = null;
				String value = null;
				if (param.length > 0) {
					key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));
				}

				if (param.length > 1) {
					value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));
				}
				if (parameters.containsKey(key)) {
					Object obj = parameters.get(key);
					if (obj instanceof List<?>) {
						@SuppressWarnings("rawtypes")
						List values = (List) obj;
						values.add(value);

					} else if (obj instanceof String) {
						@SuppressWarnings("rawtypes")
						List values = new ArrayList();
						values.add((String) obj);
						values.add(value);
						parameters.put(key, values);
					}
				} else {
					parameters.put(key, value);
				}

			}

		}

	}
	
	public static void parseQuery(String query,ArrayList<String> parameters) throws UnsupportedEncodingException {

		if (query != null) {
			String values [] = query.split("[&]");
			for (String item : values) {
				parameters.add(item);
			}

		}

	}


	public static void addCORS(HttpExchange exchange) throws IOException {
		exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");

		if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
			exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS");
			exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
			exchange.sendResponseHeaders(204, -1);
			return;
		}
	}

	public static void showInfoRequest(HttpExchange exchange) {

		System.out.println("Encabezados");
		for (Map.Entry<String, List<String>> item : exchange.getRequestHeaders().entrySet()) {
			System.out.println(item);
		}
		System.out.println();
		System.out.println("Metodo: " + exchange.getRequestMethod());
		System.out.println("Query");
		URI uri = exchange.getRequestURI();
		System.out.println(uri.getQuery());
		System.out.println();
	}


}
