package in.edu.ssn.client;

import in.edu.ssn.model.Car;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class CarClient2 {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/RPMS/webapi/");
		String result = target.path("cars/").request().get(String.class);
		System.out.println(result);

	}

}