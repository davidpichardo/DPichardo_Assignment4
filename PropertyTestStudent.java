/*
 * Class: CMSC203 
 * Instructor: Prof G
 * Description: Property jUnit class for testing of each method
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

class PropertyTestStudent {
    private Property property1, property2;

    @BeforeEach
    void setUp() {
        property1 = new Property("OceanView", "Malibu", 5000.0, "Alice");
        property2 = new Property("MountainHouse", "Aspen", 3000.0, "Bob", 2, 2, 4, 4);
    }

    @Test
    void testDefaultConstructor() {
        Property defaultProperty = new Property();
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals(0.0, defaultProperty.getRentAmount());
        assertEquals("", defaultProperty.getOwner());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals("OceanView", property1.getPropertyName());
        assertEquals("Malibu", property1.getCity());
        assertEquals(5000.0, property1.getRentAmount());
        assertEquals("Alice", property1.getOwner());
    }

    @Test
    void testCopyConstructor() {
        Property copyProperty = new Property(property1);
        assertEquals(property1.getPropertyName(), copyProperty.getPropertyName());
        assertEquals(property1.getCity(), copyProperty.getCity());
        assertEquals(property1.getRentAmount(), copyProperty.getRentAmount());
        assertEquals(property1.getOwner(), copyProperty.getOwner());
    }

    @Test
    void testGetPlot() {
        assertEquals(0, property1.getPlot().getX());
        assertEquals(2, property2.getPlot().getX());
    }

    @Test
    void testSetters() {
        property1.setPropertyName("SeaBreeze");
        property1.setCity("Miami");
        property1.setRentAmount(4000.0);
        property1.setOwner("Charlie");
        
        assertEquals("SeaBreeze", property1.getPropertyName());
        assertEquals("Miami", property1.getCity());
        assertEquals(4000.0, property1.getRentAmount());
        assertEquals("Charlie", property1.getOwner());
    }

    @Test
    void testToString() {
        assertEquals("OceanView,Malibu,Alice,5000.0", property1.toString());
    }
}
