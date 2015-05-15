package in.edu.ssn.store;

import in.edu.ssn.model.Car;
import in.edu.ssn.model.Feature;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.eclipse.persistence.internal.oxm.record.json.JSONReader;
import org.glassfish.jersey.server.JSONP;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CarStoreMock implements CarStore {
	//public static List<Car> carsList = new ArrayList<Car>();
	//public static Car[] car = new Car[10];
	//int i=0;
	
	//@Override
	//public void create() {
		// insert to DB
	//}
	Client client = ClientBuilder.newClient();
	final int STATUS_OK = Response.Status.OK.getStatusCode();
	//final String C1_JSON_FILE = "c1.json";
	
	@Override
		public void create(Car car) {
			 // insert to DB
		
		}
	@Override
	public void delete(String carId) {
		//delete from Car where carId=? 
	}
	@Override
	public List<Car> findAllCars() throws IllegalStateException {
	    
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		Car car4 = new Car();
		Car car5 = new Car();
		Car car6 = new Car();
		List<Car> cars = new ArrayList<Car>();
		
		
		//CAR 1
		//gets pushed to the db by the PI at the gate that uses the store and OCR Document API at HP IDOL
		WebTarget target  = client.target("https://api.idolondemand.com/1/api/sync/ocrdocument/v1?"
				+ "reference=3bf9953e-0fd0-4f3a-959c-5ff731fb14fe&mode=scene_photo"
				+ "&apikey=5a1d7f68-11fa-4988-8a01-6720e3706eb6");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String c1 = response.readEntity(String.class);
		//System.out.println(c1);
		//System.out.println(response.length());
		//System.out.println(response.charAt(100));
		org.json.JSONObject jsonObject = new org.json.JSONObject(c1);
		JSONArray newJSON = jsonObject.getJSONArray("text_block");
		//int as = newJSON.length();
		String c1n = new String();
		//for (int i = 0; i < as; ++i) {
		jsonObject = newJSON.getJSONObject(0);
		c1n = jsonObject.getString("text");
		String c1sr=c1n.replaceAll(" ", "");
		//System.out.println(jsonObject.getString("text"));
		//}
		car1.setCarNumber(c1sr);
		//calculated as the difference in timestamps at the entrance and exit gates
		car1.setDuration(50);
		car1.setId("c1");
		cars.add(car1);
		
		
		
		//CAR 2
		//gets pushed to the db by the PI at the gate that uses the store and OCR Document API at HP IDOL
		WebTarget target2  = client.target("https://api.idolondemand.com/1/api/sync/ocrdocument/v1?"
				+ "reference=a9c04a83-f9ba-40d7-ac36-bad790bcdf1d&mode=scene_photo&"
				+ "apikey=5a1d7f68-11fa-4988-8a01-6720e3706eb6");
		Response response2 = target2.request(MediaType.APPLICATION_JSON).get();
		String c2 = response2.readEntity(String.class);
		org.json.JSONObject jsonObject2 = new org.json.JSONObject(c2);
		JSONArray newJSON2 = jsonObject2.getJSONArray("text_block");
		String c2n = new String();
		jsonObject2 = newJSON2.getJSONObject(0);
		c2n = jsonObject2.getString("text");
		//System.out.println(jsonObject2.getString("text"));
		String c2sr=c2n.replaceAll(" ", "");
                car2.setCarNumber(c2sr);
		//calculated as the difference in timestamps at the entrance and exit gates
		car2.setDuration(72);
		car2.setId("c2");
		cars.add(car2);
		
		
		//CAR 3
		//gets pushed to the db by the PI at the gate that uses the store and OCR Document API at HP IDOL
		WebTarget target3  = client.target("https://api.idolondemand.com/1/api/sync/ocrdocument/v1?"
				+ "reference=adc3cdfe-e199-4e4c-a754-a4b0dec96b7"
				+ "8&mode=subtitle&apikey=5a1d7f68-11fa-4988-8a01-6720e3706eb6");
		Response response3 = target3.request(MediaType.APPLICATION_JSON).get();
		String c3 = response3.readEntity(String.class);
		org.json.JSONObject jsonObject3 = new org.json.JSONObject(c3);
		JSONArray newJSON3 = jsonObject3.getJSONArray("text_block");
		String c3n = new String();
		jsonObject3 = newJSON3.getJSONObject(0);
		c3n = jsonObject3.getString("text");
                String c3sr=c3n.replaceAll(" ", "");
		//System.out.println(jsonObject2.getString("text"));
		car3.setCarNumber(c3sr);
		//calculated as the difference in timestamps at the entrance and exit gates
		car3.setDuration(32);
		car3.setId("c3");
		cars.add(car3);
	
		
		//CAR 4
				//gets pushed to the db by the PI at the gate that uses the store and OCR Document API at HP IDOL
				WebTarget target4  = client.target("https://api.idolondemand.com/1/api/sync/ocrdocument/v1?"
						+ "reference=d08b2330-2e50-4546-b308-643df597f4d7"
						+ "&mode=scene_photo&apikey=5a1d7f68-11fa-4988-8a01-6720e3706eb6");
				Response response4 = target4.request(MediaType.APPLICATION_JSON).get();
				String c4 = response4.readEntity(String.class);
				org.json.JSONObject jsonObject4 = new org.json.JSONObject(c4);
				JSONArray newJSON4 = jsonObject4.getJSONArray("text_block");
				String c4n = new String();
				jsonObject4 = newJSON4.getJSONObject(0);
				c4n = jsonObject4.getString("text");
                                String c4sr=c4n.replaceAll(" ", "");
				//System.out.println(jsonObject2.getString("text"));
				car4.setCarNumber(c4sr);
				//calculated as the difference in timestamps at the entrance and exit gates
				car4.setDuration(80);
				car4.setId("c4");
				cars.add(car4);
				
				
				//CAR 5
				//gets pushed to the db by the PI at the gate that uses the store and OCR Document API at HP IDOL
				WebTarget target5  = client.target("https://api.idolondemand.com/1/api/sync/ocrdocument/v1?"
						+ "reference=e60f43b1-75d4-44ed-b7bd-89aca1525a84"
						+ "&mode=scene_photo&apikey=5a1d7f68-11fa-4988-8a01-6720e3706eb6");
				Response response5 = target5.request(MediaType.APPLICATION_JSON).get();
				String c5 = response5.readEntity(String.class);
				org.json.JSONObject jsonObject5 = new org.json.JSONObject(c5);
				JSONArray newJSON5 = jsonObject5.getJSONArray("text_block");
				String c5n = new String();
				jsonObject5 = newJSON5.getJSONObject(0);
				c5n = jsonObject5.getString("text");
                                String c5sr=c5n.replaceAll(" ", "");
				//System.out.println(jsonObject2.getString("text"));
				car5.setCarNumber(c5sr);
				//calculated as the difference in timestamps at the entrance and exit gates
				car5.setDuration(63);
				car5.setId("c5");
				cars.add(car5);
		
				//CAR 6
				//gets pushed to the db by the PI at the gate that uses the store and OCR Document API at HP IDOL
				WebTarget target6  = client.target("https://api.idolondemand.com/1/api/sync/ocrdocument/v1?"
						+ "reference=8cc3de9c-473a-48b6-a741-044c1c4a6846"
						+ "&mode=subtitle&apikey=5a1d7f68-11fa-4988-8a01-6720e3706eb6");
				Response response6 = target6.request(MediaType.APPLICATION_JSON).get();
				String c6 = response6.readEntity(String.class);
				org.json.JSONObject jsonObject6 = new org.json.JSONObject(c6);
				JSONArray newJSON6 = jsonObject6.getJSONArray("text_block");
				String c6n = new String();
				jsonObject6 = newJSON6.getJSONObject(0);
				c6n = jsonObject6.getString("text");
				String c6sr=c6n.replaceAll(" ", "");
                                //System.out.println(jsonObject2.getString("text"));
				car6.setCarNumber(c6sr);
				//calculated as the difference in timestamps at the entrance and exit gates
				car6.setDuration(73);
				car6.setId("c6");
				cars.add(car6);
		
		
		return cars;
		
	}
	
	
	
	@Override
	public String isCarAvl(String carno) {
		String carNo = null;
		Car[] car = new Car[10];
		for (int i=0; i<=(findAllCars().size()-1); i++)
		{
			car[i]=findAllCars().get(i);
			carNo =car[i].getCarNumber();    	
			if(carNo.equalsIgnoreCase(carno)) {
				return "Car " + carno + " is currently available in this parking lot";
			}
		}
		return "Car " + carno + " is currently not available in this parking lot";
	}


	@Override
	public Car findCar(String carno) {
			String carNo = null;
			Car[] car = new Car[10];
			for (int i=0; i<=(findAllCars().size()-1); i++)
			{
				car[i]=findAllCars().get(i);
				carNo =car[i].getCarNumber();    	
				if(carNo.equalsIgnoreCase(carno)) {
					if(carNo.equalsIgnoreCase("999AA")) {
					Feature feature = new Feature();
					feature.setMake("toyota");
					feature.setColor("inferno orange");
					feature.setId("f1");
					car[i].setFeature(feature);
					return car[i];
					}
					else if(carNo.equalsIgnoreCase("LL08ZPE")) {
						Feature feature = new Feature();
						feature.setMake("Honda");
						feature.setColor("Silver");
						feature.setId("f2");
						car[i].setFeature(feature);
						return car[i];
					}
					else if(carNo.equalsIgnoreCase("PJZ22I8")) {
						Feature feature = new Feature();
						feature.setMake("Benz");
						feature.setColor("White");
						feature.setId("f3");
						car[i].setFeature(feature);
						return car[i];
					}
					else if(carNo.equalsIgnoreCase("l234")) {
						Feature feature = new Feature();
						feature.setMake("Maruti");
						feature.setColor("Green");
						feature.setId("f4");
						car[i].setFeature(feature);
						return car[i];
					}
					else if(carNo.equalsIgnoreCase("MH04ZZ0000")) {
						Feature feature = new Feature();
						feature.setMake("Skoda");
						feature.setColor("White");
						feature.setId("f5");
						car[i].setFeature(feature);
						return car[i];
					}
					else if(carNo.equalsIgnoreCase("HiOLAV")) {
						Feature feature = new Feature();
						feature.setMake("Jaquar");
						feature.setColor("Red");
						feature.setId("f6");
						car[i].setFeature(feature);
						return car[i];
					}
				}
			}
			return null;
		}

	@Override
	public Car update(Car car) {
		 //search the db to see if there is any car already with that Id
		//select * from Car where id=?
		//if rs size==0
		//insert into Car table
		//else update the Car 
		return car; 
		
	}

}