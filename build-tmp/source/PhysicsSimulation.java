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
CircuitBox [][] circuitGrid;
boolean key1 = false;
boolean key2 = false;
boolean key3 = false;
boolean key4 = false;
boolean key5 = false;
boolean key6 = false;
public void setup()
{
	
	cursorMain = new Cursor();
	circuitGrid = new CircuitBox[20][12];
	for(int i=0;i<20;i++)
	{
		for(int j=0;j<12;j++)
		{
			circuitGrid[i][j] = new EmptyCir(i,j);
		}
	}
	circuitGrid[0][1] = new Battery(0,1);
	circuitGrid[19][11] = new Battery(19,11);
}
public void keyPressed()
{
	if(key=='1'){cursorMain.setCursorType(0);}
	if(key=='2'){cursorMain.setCursorType(1);}
	if(key=='3'){cursorMain.setCursorType(2);}
	if(key=='4'){cursorMain.setCursorType(3);}
}
public void draw()
{
	background(0);
	stroke(169,169,169);
	strokeWeight(1);
	for(int i=50;i<1000;i+=50)
	{
		line(i,-10,i,610);
	}
	for(int i=50;i<600;i+=50)
	{
		line(-10,i,1010,i);
	}
	for(CircuitBox [] row : circuitGrid)
	{
		for(CircuitBox blankCir : row)
		{
			blankCir.show();
		}
	}
	cursorMain.show();
}
public void mouseClicked()
{
	circuitGrid[(int)(mouseX/50)][(int)(mouseY/50)].beenClicked();
}
public int intResCount()
{
	int frdirection;
	if(!(circuitGrid[1][0] instanceof EmptyCir)){frdirection=3;}
	Path mainPath = new Path(0,0);
	return mainPath.getTotRes();
}
public class Cursor
{
	private int cursorType;
	public Cursor()
	{
		cursorType=0;
	}
	public void setCursorType(int input){cursorType=input;}
	public int getCursorType(){return cursorType;}
	public void show()
	{
		stroke(0);
		if(cursorType==1)
		{
			fill(255);
			rect(mouseX-25,mouseY-25,50,50);
			fill(0);
			rect(mouseX-25,mouseY-5,50,10);
		}
		else if(cursorType==2)
		{
			fill(255);
			rect(mouseX-25,mouseY-25,50,50);
			fill(0);
			rect(mouseX-25,mouseY-5,50,10);
			rect(mouseX-5,mouseY-25,10,30);
		}
		else if (cursorType==3)
		{		
			fill(255);
			rect(mouseX-25,mouseY-25,50,50);
			fill(0);
			ellipse(mouseX,mouseY,35,35);
		}
	}
}
public interface CircuitBox
{
	public void beenClicked();
	public void show();
}
public class Circuit implements CircuitBox
{
	private int myX, myY;
	public Circuit(int x,int y)
	{
		myX = x;
		myY = y;
	}
	public void beenClicked()
	{

	}
	public void showline()
	{
		fill(255);
		rect(myX*50,myY*50,50,50);
		if(myY>0&&!(circuitGrid[myX][myY-1] instanceof EmptyCir))
		{
			stroke(0);
			fill(0);
			rect(myX*50+20,myY*50,10,30);
			if(myX>0&&!(circuitGrid[myX-1][myY] instanceof EmptyCir))
			{
				rect(myX*50,myY*50+20,30,10);
			}
			else if(myX<19&&!(circuitGrid[myX+1][myY] instanceof EmptyCir))
			{
				rect(myX*50+20,myY*50+20,30,10);
			}
			else
			{
				rect(myX*50+20,myY*50,10,50);
			}
		}
		else if(myY<11&&!(circuitGrid[myX][myY+1] instanceof EmptyCir))
		{
			stroke(0);
			fill(0);
			rect(myX*50+20,myY*50+20,10,30);
			if(myX>0&&!(circuitGrid[myX-1][myY] instanceof EmptyCir))
			{
				rect(myX*50,myY*50+20,30,10);
			}
			else if(myX<19&&!(circuitGrid[myX+1][myY] instanceof EmptyCir))
			{
				rect(myX*50+20,myY*50+20,30,10);
			}
			else
			{
				rect(myX*50+20,myY*50,10,50);
			}	
		}
		else
		{
			stroke(0);
			fill(0);
			rect(myX*50,myY*50+20,50,10);
		}
	}
	public void show()
	{
		showline();
	}
}
public class EmptyCir implements CircuitBox
{
	private int myX, myY;
	public EmptyCir(int x, int y)
	{
		myX = x;
		myY = y;
	}
	public void beenClicked()
	{
		if(cursorMain.getCursorType()==1)
		{
			circuitGrid[myX][myY] = new Circuit(myX,myY);
		}
		else if(cursorMain.getCursorType()==2)
		{
			circuitGrid[myX][myY] = new JoinCir(myX,myY);
		}
		else if(cursorMain.getCursorType()==3)
		{
			circuitGrid[myX][myY] = new Resistor(myX,myY);
		}
	}
	public void show()
	{};
}
public class JoinCir implements CircuitBox
{
	private int myX, myY;
	public JoinCir(int x,int y)
	{
		myX = x;
		myY = y;
	}
	public void beenClicked(){};
	public void showline()
	{
		fill(255);
		rect(myX*50,myY*50,50,50);
		stroke(0);
		fill(0);
		if(myY>0&&!(circuitGrid[myX][myY-1] instanceof EmptyCir))
		{
			rect(myX*50+20,myY*50,10,30);
		}
		if(myY<11&&!(circuitGrid[myX][myY+1] instanceof EmptyCir))
		{
			rect(myX*50+20,myY*50+20,10,30);
		}
		if(myX>0&&!(circuitGrid[myX-1][myY] instanceof EmptyCir))
		{
			rect(myX*50,myY*50+20,30,10);
		}
		if(myX<19&&!(circuitGrid[myX+1][myY] instanceof EmptyCir))
		{
			rect(myX*50+20,myY*50+20,30,10);
		}
	}
	public void show(){showline();}
}
public class Battery implements CircuitBox
{
	private int myX, myY;
	public Battery(int x, int y)
	{
		myX = x;
		myY = y;
	}
	public void beenClicked()
	{
	}
	public void show()
	{
		strokeWeight(1);
		fill(255);
		rect(myX*50,myY*50,50,50);
		noFill();
		stroke(0);
		strokeWeight(10);
		ellipse(myX*50+25,myY*50+25,30,30);
		strokeWeight(1);
	}
}
public class Resistor implements CircuitBox
{
	private int myX, myY, resistance;
	public Resistor(int x, int y)
	{
		myX = x;
		myY = y;
		resistance = 1;
	}
	public void beenClicked(){};
	public void show()
	{
		fill(255);
		rect(myX*50,myY*50,50,50);
		fill(0);
		ellipse(myX*50+25,myY*50+25,35,35);
	};
}
public class Path
{
	int startX, startY, frdirection, totRes;
	public Path(int x, int y, int direct)
	{
		startX = x;
		startY = y;
		frdirection = direct;
		totRes = 0;
	}
	public int getTotRes(){return totRes;}
	public void think()
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
