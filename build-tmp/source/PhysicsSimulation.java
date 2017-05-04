import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PhysicsSimulation extends PApplet {

public void setup()
{
	
}
public void draw()
{
	background(0);
	for(int i=50;i<1000;i+=50)
	{
		stroke(169,169,169);
		line(i,-10,i,610);
	}
	for(int i=50;i<600;i+=50)
	{
		stroke(169,169,169);
		line(-10,i,1010,i);
	}
	Cursor cursorMain = new Cursor();
}
public void mouseClicked()
{

}
public class Cursor
{
	private int cursorType;
	public Cursor()
	{
		cursorType=0;
	}
	public void setCursorType(int input){cursorType = input;}
	public void mouseClicked()
	{
	}
}
  public void settings() { 	size(1000,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PhysicsSimulation" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
