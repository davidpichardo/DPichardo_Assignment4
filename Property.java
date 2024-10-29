/*
 * Class: CMSC203 
 * Instructor: Prof G
 * Description: Property class for description of property
 * Due: 10/28/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: David Pichardo
*/


public class Property{
	private String name;
	private String city;
	private double rent;
	private String owner;
	private Plot plot;

	
	//constructors below
	public Property() {
		name = "";
		city = "";
		rent = 0.0;
		owner = "";
		plot = new Plot();
	}

	public Property(String name, String city, double rent, String owner){
		this.name = name;
		this.city = city;
		this.rent = rent;
		this.owner = owner;
		this.plot = new Plot();
	}
	
	//copy constructor
	public Property (String name, String city, double rent, String owner, Plot plot){
		this.name = name;
		this.city = city;
		this.rent = rent;
		this.owner = owner;
		this.plot = new Plot(plot);
	}
	
	public Property(Property copy) {
		this.name = copy.name;
		this.city = copy.city;
		this.rent = copy.rent;
		this.owner = copy.owner;
		this.plot = new Plot(copy.plot);
	}
	
	//constructor for javafx file
	public Property(String name, String city, double rent, String owner, int plotX, int plotY, int plotWidth, int plotDepth) {
		this.name = name;
		this.city = city;
		this.rent = rent;
		this.owner = owner;
		this.plot = new Plot(plotX, plotY, plotWidth, plotDepth);
	}

	//getter methods

	public String getPropertyName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public double getRentAmount(){
		return rent;
	}

	public String getOwner() {
		return owner;
	}
	
	public Plot getPlot() {
		return plot;
	}

	//setter methods

	public void setPropertyName(String propertyName){
		this.name = propertyName;
	}
	
	public void setCity(String city){
		this.city = city;
	}

	public void setRentAmount(double rentalAmount){
		this.rent = rentalAmount;
	}

	public void setOwner(String owner){
		this.owner = owner;
	}

	public void setPlot(Plot plot){
		this.plot = new Plot(plot);
	}

	//toString method

	public String toString(){
		String str = name + "," + city + "," + owner + "," + rent;

		return str;
	}
}