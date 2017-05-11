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
	size(1000,600);
	cursorMain = new Cursor();
	circuitGrid = new CircuitBox[20][12];
	for(int i=0;i<20;i++)
	{
		for(int j=0;j<12;j++)
		{
			circuitGrid[i][j] = new EmptyCir(i,j);
		}
	}
}
public void keyPressed()
{
	if(key=='1'){cursorMain.setCursorType(0);}
	if(key=='2'){cursorMain.setCursorType(1);}
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
		if(cursorType==1)
		{
			fill(255);
			rect(mouseX-25,mouseY-25,50,50);
			fill(0);
			rect(mouseX-25,mouseY-5,50,10);
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
		if(myY>0&&(circuitGrid[myX][myY-1] instanceof JoinCir||circuitGrid[myX][myY-1] instanceof Circuit))
		{
			stroke(0);
			fill(0);
			rect(myX*50+20,myY*50,10,30);
			if(circuitGrid[myX-1][myY] instanceof JoinCir||circuitGrid[myX-1][myY] instanceof Circuit)
			{
				rect(myX*50,myY*50+20,30,10);
			}
			else if(circuitGrid[myX+1][myY] instanceof JoinCir||circuitGrid[myX+1][myY] instanceof Circuit)
			{
				rect(myX*50+20,myY*50+20,30,10);
			}
			else
			{
				rect(myX*50+20,myY*50,10,50);
			}
		}
		else if(myX<19&&(circuitGrid[myX][myY+1] instanceof JoinCir||circuitGrid[myX][myY+1] instanceof Circuit))
		{
			stroke(0);
			fill(0);
			rect(myX*50+20,myY*50+20,10,30);
			if(circuitGrid[myX-1][myY] instanceof JoinCir||circuitGrid[myX-1][myY] instanceof Circuit)
			{
				rect(myX*50,myY*50+20,30,10);
			}
			else if(circuitGrid[myX+1][myY] instanceof JoinCir||circuitGrid[myX+1][myY] instanceof Circuit)
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
	public void show(){};
}