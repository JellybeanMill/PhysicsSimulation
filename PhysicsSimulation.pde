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
	if(key=1){key1=true;}
	if(key=2){key2=true;}
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
	public void cTick()
	{
		if(key1=true){cursorType=0;}
		if(key2=true){cursorType=1;}
	}
	public void cShow()
	{
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
