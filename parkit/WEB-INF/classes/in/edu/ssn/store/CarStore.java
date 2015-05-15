package in.edu.ssn.store;

import in.edu.ssn.model.Car;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

public interface CarStore {

	List<Car> findAllCars();
	
	
	String isCarAvl(String carno);

	Car findCar(String carno);

	//void create();

	void create(Car car);


	Car update(Car car);


	void delete(String carId);


	 
}