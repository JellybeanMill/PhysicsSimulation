boolean key1 = false;
boolean key2 = false;
boolean key3 = false;
boolean key4 = false;
boolean key5 = false;
boolean key6 = false;
public void setup()
{
	size(1000,600);
	Cursor cursorMain = new Cursor();
}
public void keyPressed()
{
	if(key=1){}
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
}
public class Cursor
{
	private int cursorType;
	public Cursor()
	{
		cursorType=0;
	}
	public void setCursorType(int input){cursorType = input;}
	public void show()
	{
		if(cursorType==1)
		{

		}
	}
	public void mouseClicked()
	{
		if(cursorType==0)
		{

		}
	}
}