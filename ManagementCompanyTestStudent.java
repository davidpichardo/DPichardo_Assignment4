/*
 * Class: CMSC203 
 * Instructor: Prof G
 * Description: ManagementCompany jUnit class for testing of each method
 * Due: 10/28/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: David Pichardo
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {
    private ManagementCompany managementCo;

    @BeforeEach
    void setUp() {
        managementCo = new ManagementCompany("BlueSky", "123456789", 10.0);
    }

    @Test
    void testAddProperty() {
        Property property = new Property("Lakeside", "Orlando", 2000.0, "Dan", 1, 1, 3, 3);
        assertEquals(0, managementCo.addProperty(property)); // Check if property was added successfully
        assertEquals(1, managementCo.getPropertiesCount());
    }

    @Test
    void testGetHighestRentProperty() {
        managementCo.addProperty(new Property("CityView", "NYC", 3000.0, "Eve"));
        managementCo.addProperty(new Property("BeachHouse", "LA", 4000.0, "Frank"));
        assertEquals("BeachHouse", managementCo.getHighestRentPropperty().getPropertyName());
    }

    @Test
    void testGetTotalRent() {
        managementCo.addProperty(new Property("MountainView", "Denver", 1500.0, "George"));
        managementCo.addProperty(new Property("Seaside", "Miami", 2500.0, "Hannah"));
        assertEquals(4000.0, managementCo.getTotalRent());
    }

    @Test
    void testIsPropertiesFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            managementCo.addProperty(new Property("Property " + i, "City " + i, 1000.0 + i, "Owner " + i));
        }
        assertTrue(managementCo.isPropertiesFull());
    }

    @Test
    void testToString() {
        managementCo.addProperty(new Property("Skyline", "Boston", 1800.0, "Ivan"));
        String expected = "List of the properties for BlueSky, taxID: 123456789\n" +
                          "______________________________________________________\n" +
                          "Skyline,Boston,Ivan,1800.0\n" +
                          "______________________________________________________\n" +
                          "\n" +
                          " total management Fee: 180.0";
        assertEquals(expected, managementCo.toString());
    }
}
