/*
 * Class: CMSC203 
 * Instructor: Prof G
 * Description: ManagementCompany class for management of property/plot
 * Due: 10/28/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: David Pichardo
*/


public class ManagementCompany {
	//constant fields
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;


	//non-constant fields
	private String companyName;
	private String taxID;
	private double managementFee;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;


	//constructors

	public ManagementCompany (String companyName, String taxID, double managementFee){
		this.companyName = companyName;
		this.taxID = taxID;
		this.managementFee = managementFee;
		this.plot = new Plot(0,0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.numberOfProperties = 0;
	}

	//getter methods
	
	public String getName() {
		return companyName;
	}

	public String getTaxID() {
		return taxID;
	}

	public double getMgmFeePer() {
		return managementFee;
	}

	public Property[] getProperties() {
		return properties;
	}

	public Plot getPlot() {
		return plot;
	}

	public int getNumberOfProperties() {
		return numberOfProperties;
	}

	//setter methods

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public void setTaxID(String taxID){
		this.taxID = taxID;
	}

	public void setManagementFee(double managementFee) {
		this.managementFee = managementFee;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	//addProperty method

	public int addProperty(Property property) {
		if (isPropertiesFull()){
			return -1;	
		}
		
		else if (property == null){
			return -2;
		}
		
		else if (!plot.encompasses(property.getPlot())){
			return -3;
		}

		//for loop for -4 scenario
		for (int i = 0; i < numberOfProperties; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot())){
				return -4;
			}
		}
		
		properties[numberOfProperties] = new Property(property);
		
		return numberOfProperties;
	}

	public double getTotalRent() {
		double totalRent = 0;
	
		
	    for (Property property : properties) {
	        if (property != null) {
	            totalRent += property.getRentAmount();
	        }
	    }
		return totalRent;
	}
	


	//look back at chapter 7 to see for statements for largest value
	public Property getHighestRentPropperty() {
		Property highestRentProperty = properties[0];

		for (int i = 1; i < numberOfProperties; i++){
			if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
				highestRentProperty = properties[i];
			}
		}

		return highestRentProperty;
	}
	
	
	public void removeLastProperty() {
		if(numberOfProperties > 0) {
			properties[numberOfProperties - 1] = null;
			numberOfProperties--;
		}
	}

	public boolean isPropertiesFull() {
		if (numberOfProperties >= MAX_PROPERTY) {
			return true;
		}

		else {
			return false;
		}
	}
	

	public int getPropertiesCount() {
		int count = 0;
		
		for(Property property : properties) {
			if(property != null) {
				count++;
			}
		}
		return count;
	}

	public boolean isManagementFeeValid() {
		if (managementFee >= 0 && managementFee <= 100){
			return true;
		}
		
		else {
			return false;
		}
	}

	
	public String toString() {
	    String str = "List of the properties for " + getName() + ", taxID: " + getTaxID() + "\n";
	    str += "______________________________________________________\n";
	    
	    
	    for (Property property : properties) {
	        if (property != null) { 
	            str += property.getPropertyName() + "," + property.getCity() + "," 
	                    + property.getOwner() + "," + property.getRentAmount() + "\n";
	            str += "______________________________________________________\n";
	        }
	    }
	    
	    
	    double totalManagementFee = getTotalRent() * getMgmFeePer() / 100;
	    str += "\n total management Fee: " + totalManagementFee;
	    
	    return str;
	}

}