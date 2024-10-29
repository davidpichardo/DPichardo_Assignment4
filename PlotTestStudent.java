/*
 * Class: CMSC203 
 * Instructor: Prof G
 * Description: Plot jUnit class for testing of each method
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

class PlotTestStudent {
    private Plot plot1, plot2, plot3;

    @BeforeEach
    void setUp() {
        plot1 = new Plot(1, 1, 4, 4);
        plot2 = new Plot(3, 3, 4, 4);
        plot3 = new Plot(10, 10, 2, 2); 
    }

    @Test
    void testDefaultConstructor() {
        Plot defaultPlot = new Plot();
        assertEquals(0, defaultPlot.getX());
        assertEquals(0, defaultPlot.getY());
        assertEquals(1, defaultPlot.getWidth());
        assertEquals(1, defaultPlot.getDepth());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals(1, plot1.getX());
        assertEquals(1, plot1.getY());
        assertEquals(4, plot1.getWidth());
        assertEquals(4, plot1.getDepth());
    }

    @Test
    void testCopyConstructor() {
        Plot copyPlot = new Plot(plot1);
        assertEquals(plot1.getX(), copyPlot.getX());
        assertEquals(plot1.getY(), copyPlot.getY());
        assertEquals(plot1.getWidth(), copyPlot.getWidth());
        assertEquals(plot1.getDepth(), copyPlot.getDepth());
    }

    @Test
    void testOverlaps() {
        assertTrue(plot1.overlaps(plot2));
        assertFalse(plot1.overlaps(plot3));
    }

    @Test
    void testEncompasses() {
        assertTrue(plot1.encompasses(new Plot(2, 2, 2, 2))); 
        assertFalse(plot1.encompasses(plot2));
    }

    @Test
    void testToString() {
        assertEquals("1,1,4,4", plot1.toString());
    }
}