package in.edu.ssn.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Feature {
	private String make;
	private String color;
	private String id;
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
}
