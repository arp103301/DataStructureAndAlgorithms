package Z.com.anup.java8;

import java.util.List;

public class Employee {
private int id;
private String name;
List <String> listOfCitiesWorkedOn;



public Employee(int id, String name, List<String> listOfCitiesWorkedOn) {
	super();
	this.id = id;
	this.name = name;
	this.listOfCitiesWorkedOn = listOfCitiesWorkedOn;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<String> getListOfCities() {
	return listOfCitiesWorkedOn;
}
public void setListOfCities(List<String> listOfCities) {
	this.listOfCitiesWorkedOn = listOfCities;
}



}
