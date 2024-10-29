/*
 * Class: CMSC203 
 * Instructor: Prof G
 * Description: Plot class for house size
 * Due: 10/28/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: David Pichardo
*/


public class Plot{
	private int x;
	private int y;
	private int width;
	private int depth;

	
	//this constructor initializes the above fields
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	public Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	public Plot(Plot otherPlot){
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}

	
	//below is the code for the getter methods
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getWidth(){
		return width;
	}

	public int getDepth(){
		return depth;
	}

	//below is the code for the setter methods

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public void setDepth(int depth){
		this.depth = depth;
	}
	
	//overlaps method
	
	public boolean overlaps(Plot otherPlot){
		//if statements
		if (x + width <= otherPlot.x || otherPlot.x + otherPlot.width <= x || y + depth <= otherPlot.y || otherPlot. y + otherPlot.depth <= y){
		return false;
		}

		return true;
	}
	

	//encompasses method

	public boolean encompasses(Plot otherPlot){
		if (x <= otherPlot.x && (x + width) >= (otherPlot.x + otherPlot.width) 	&& y <= otherPlot.y && (y + depth) >= (otherPlot.y + otherPlot.depth)) 		{

			return true;
		}
	
	return false;

	}
	
	//toString method

	public String toString(){
		String str = x + "," + y + "," + width + "," + depth;

		return str;
	}
}