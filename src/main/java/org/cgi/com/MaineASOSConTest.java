/**
 * 
 */
package org.cgi.com;



import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author sunil.kumar2
 *
 */
public class MaineASOSConTest {

	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		scanner = new Scanner( System.in);
		System.out.print("Enter your Parameter : ");
		String InputOne=scanner.nextLine();
		String InputTwo=scanner.nextLine();
		String InputThree=scanner.nextLine();
		MaineASOSConTest maineASOSConTest = new MaineASOSConTest();
		MaineASOSConProcess maineASOSConProcess = new MaineASOSConProcess();
		maineASOSConProcess.setParamOne(InputOne);
		maineASOSConProcess.setParamTwo(InputTwo);
		maineASOSConProcess.setParamThree(InputThree);
		maineASOSConTest.getClientResponse(maineASOSConProcess);
	}

	private void getClientResponse(MaineASOSConProcess maineASOSConProcess) {
		//String notificationuri = "http://localhost:8080/RESTJerseyExample/restJersey/maineASOSConProcess";
		String notificationuri = "http://192.168.139.132:8080/RESTJerseyExample/restJersey/maineASOSConProcess";
		
		Client client = Client.create();
		ClientResponse response;
		long start1 = 0;
		AsyncWebResource webResource = client.asyncResource(notificationuri);
		client.setConnectTimeout(200);
		client.setReadTimeout(200);
		start1 = System.currentTimeMillis();
		final Future responseFutre = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, maineASOSConProcess);
		try {
			response = (ClientResponse) responseFutre.get();
			System.out.println("response >>>"+response);
			int statusCode = response.getStatus();
			System.out.println("Response status code:- "+ response.getStatus());
			if ((200 <= statusCode) && (statusCode <= 399)) {
				System.out.println("Time Elapsed :- "+ (System.currentTimeMillis() - start1) +" ms");
				System.out.println("input sent successfully");
			} else if((500 <= statusCode) && (statusCode <= 599)){
				System.out.println("Time Elapsed :- "+ (System.currentTimeMillis() - start1) +" ms");
				System.out.println("Server not available to process the request ");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
