 package in.edu.ssn.client;

import java.util.List;

import in.edu.ssn.model.Car;
import in.edu.ssn.model.Feature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CarClient {
	private Client client;
	
	public CarClient() {
		client = ClientBuilder.newClient();
	}
	
	public Feature getCarFeature(String carNumber) {
		WebTarget target = client.target("http://localhost:8080/RPMS/webapi/");
		
		Feature result = target.path("cars/ur-car-features/" + carNumber)
				.request(MediaType.APPLICATION_JSON).get(Feature.class);
		
		
		//String result = target.path("cars/" + carNumber + "/feature")
		//		.request(MediaType.APPLICATION_JSON).get(String.class);
		//System.out.println(result);
		//return null;
		
		return result;
	}
	
	public List<Car> getCars() {
		WebTarget target = client.target("http://localhost:8080/RPMS/webapi/");
		
		List<Car> result = target.path("cars/")
				.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Car>>() {});
		
		return result;
		
	}
	
	public String getCarAvailibility(String carNumber) {
		WebTarget target = client.target("http://localhost:8080/RPMS/webapi/");
		
		Response result = target.path("cars/ur-car/" + carNumber)
				.request(MediaType.APPLICATION_JSON).get(Response.class);
		
		if(result.getStatus() != 200) {
			throw new RuntimeException(result.getStatus() + "there was an error on the server.");
		}
		
		return result.readEntity(String.class);
		
	}

	public Car create(Car car) {
		WebTarget target = client.target("http://localhost:8080/RPMS/webapi/");
		
		Response result = target.path("cars/car")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(car, MediaType.APPLICATION_JSON));
		
		if(result.getStatus() != 200) {
			throw new RuntimeException(result.getStatus() + "there was an error on the server.");
		}
		
		
		return result.readEntity(Car.class);
	}

	 Car update(Car car) {
		 WebTarget target = client.target("http://localhost:8080/RPMS/webapi/");
			
		Response result = target.path("cars/car/"+ car.getId())
					.request(MediaType.APPLICATION_JSON)
					.put(Entity.entity(car, MediaType.APPLICATION_JSON));
		 
		if(result.getStatus() != 200) {
			throw new RuntimeException(result.getStatus() + "there was an error on the server.");
		}
		
		
		return result.readEntity(Car.class);
	}

	  void delete(String carId ) {
		  WebTarget target = client.target("http://localhost:8080/RPMS/webapi/");
		  Response result = target.path("cars/car/" + carId).request(MediaType.APPLICATION_JSON).delete();
		  if(result.getStatus() != 200) {
				throw new RuntimeException(result.getStatus() + "there was an error on the server.");
			}
		   
	}
}
