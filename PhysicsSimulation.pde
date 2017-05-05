Cursor cursorMain;
boolean key1 = false;
boolean key2 = false;
boolean key3 = false;
boolean key4 = false;
boolean key5 = false;
boolean key6 = false;
public void setup()
{
	size(1000,600);
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
public interface CirciutBox
{
	public void MouseClicked(){}
	public void makeDisplay(){}
	public boolean checkCircuitry(){}
}
public class Circuit
{

	public Circuit()
	{

	}
	public void makeDisplay()
	{
	}
	public boolean checkCircuitryNeg()
	{

	}
}
public class Position //BE WARY OF CONFLICT WITH PROCESSING.JS
{
	
	public Position(int inputX, int inputY)
	{

	}
}