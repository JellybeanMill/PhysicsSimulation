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

Cursor cursorMain;
boolean key1 = false;
boolean key2 = false;
boolean key3 = false;
boolean key4 = false;
boolean key5 = false;
boolean key6 = false;
public void setup()
{
	
	cursorMain = new Cursor();
}
public void keyPressed()
{
	if(key=='1'){cursorMain.setCursorType(0);
		System.out.println("Pressed 1");}
	if(key=='2'){cursorMain.setCursorType(1);System.out.println("Pressed 1");}
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
	cursorMain.cShow();
}
public class Cursor
{
	private int cursorType;
	public Cursor()
	{
		cursorType=0;
	}
	public void setCursorType(int input){cursorType=input;}
	public void cTick()
	{}
	public void cShow()
	{
		cTick();
		if(cursorType==1)
		{
			fill(255);
			rect(mouseX-25,mouseY-25,50,50);
			fill(0);
			rect(mouseX-25,mouseY-5,50,10);
		}
	}
	public void mouseClicked()
	{
		if(cursorType==0)
		{

		}
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
