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

public class ToolsForChemWorksheet extends PApplet {

public ArrayList<Tokens> t=new ArrayList<Tokens> (); 
double orginalSize=60;
int numberOfShakes=0;
public void setup()
{
	size(500,500);
	background(0);
	noLoop();
	for(double i=0;i<orginalSize;i++)
	{
		t.add(new Tokens());
	}
}
public void draw()
{
	background(0);
	for(double i=0;i<t.size();i++)
	{
		t.get((int)i).draw();
	}
	textAlign(CENTER,CENTER);
	textSize(16);
	text("un-decayed: "+t.size(), 100, 425);
	text("decayed: "+(orginalSize-t.size()), 250, 425);
	text("shakes: "+numberOfShakes, 400, 425);
}
public void mousePressed()
{
	for(double i=0;i<t.size();i++)
	{
		t.get((int)i).shake();
	}
	for(double i=0;i<t.size();i++)
	{
		if(t.get((int)i).getDecayed()==true)
		{
			t.remove((int)i);
			i--;
		}
	}
	numberOfShakes++;
	redraw();
}
public void keyPressed()
{
	if(key=='r' || key=='R')
	{
		t=new ArrayList<Tokens> ();
		for(double i=0;i<orginalSize;i++)
		{
			t.add(new Tokens());
		}
		numberOfShakes=0;
		redraw();
	}
}
public class Tokens
{
	private boolean decayed;
	public Tokens() { decayed=false; }
	public boolean getDecayed() {return decayed;}
	public void draw()
	{
		stroke(0,0,0);
		fill(255,90,0);
		ellipse(random(50,451), random(50,351), 20, 20);
	}
	public void shake()
	{
		int r=(int)random(2);
		if (r==1)
		{
			decayed=true;
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ToolsForChemWorksheet" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
