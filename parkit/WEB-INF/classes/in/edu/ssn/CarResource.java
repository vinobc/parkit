 package in.edu.ssn;

import java.net.URI;
import java.util.List;

import in.edu.ssn.model.Car;
import in.edu.ssn.model.Feature;
import in.edu.ssn.store.CarStore;
import in.edu.ssn.store.CarStoreMock;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;

@Path("cars")
public class CarResource {
	private CarStore carStore = new CarStoreMock();
	private static final String VERSION = "v 1.0";
	private UriInfo uriInfo;
	private Car Car;
	
	@GET
	@Path("version")
	@Produces(MediaType.TEXT_HTML)
	public String getVersion() {
		return VERSION;
	}
	
	
	@DELETE
	@Path("car/{carId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	public Response delete(@PathParam("carId") String carId) {
	  System.out.println(carId + " deleted");
	  carStore.delete(carId); 
	  return Response.ok().build(); 	
	}
	
	@PUT
	@Path("car/{carId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Car car) {
		
		
		System.out.println(car.getId() + " created/updated");
		
		car = carStore.update(car);
		
		return Response.ok().entity(car).build(); 
		
		
	}
	
	@POST
	@Path("car")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//public String createCarParams(MultivaluedMap<String, String> frmParams) {
	public Car createCar(Car car) {
		//System.out.println(frmParams.getFirst("carNumber"));
		//System.out.println(frmParams.getFirst("duration"));
		//List<Car> cars = CarStoreMock.cars;
		//Car car = new Car();
		//car.setCarNumber(frmParams.getFirst("carNumber"));
		//car.setDuration(Integer.parseInt(frmParams.getFirst("duration")));
		
		
		System.out.println(car.getCarNumber());
		System.out.println(car.getDuration());
		
		//carStore.create();
		carStore.create(car);
		return car;
		//carStore.addCar(frmParams);
		//return "card added";
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getAllCars() {
		return carStore.findAllCars();
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("ur-car/{carno}")
	public Response getCarAvl(@PathParam("carno") String carno) {
		
		if(carno == null || carno.length() <5) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		String status = carStore.isCarAvl(carno);
		
		if(status==null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(status).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("ur-car-features/{carno}")
	public Feature getCarFeature(@PathParam("carno") String carno) {
	 return carStore.findCar(carno).getFeature();
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("ur-car-features")
	public String carNumberFeature() {
	 return "append ur car number to the end of the url or enter the car number in the text box";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("ur-car")
	public String carNumberAvailibility() {
	 return "append ur car number to the end of the url or enter the car number in the text box";
	}
	
}
