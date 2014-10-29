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

public class OldMacDonald extends PApplet {

public void setup()
{
	Bestiary Compendium = new Bestiary();
	Compendium.vocalizations();
}
class Bestiary
{
	private Creature[] collection = new Creature[4];
	public Bestiary()
	{
		collection[0] = new Cow("snarl", "bos taurus");
		collection[1] = new Chick("screech", "hiss", "gallus gallus");
		collection[2] = new Pig("snort", "sus scrofa scrofa");
		collection[3] = new NamedCow("snicker", "seaCow", "hydrodamalis");
	}
	public void vocalizations()
	{
		for(int a=0; a<collection.length; a++)
		{
			System.out.println(collection[a].getType() + " goes " + collection[a].getSound());
		}
		System.out.println("The " + ((NamedCow)collection[3]).getType() + " is named " + ((NamedCow)collection[3]).getName());
	}
}
interface Creature
{
	public String getSound();
	public String getType();
}
class Cow implements Creature
{
	protected String mySound;
	protected String myType;
	public Cow(String sound, String type)
	{
		mySound=sound;
		myType=type;
	}
	public Cow()
	{
		mySound="snarl";
		myType="bos taurus";
	}
	public String getSound()
	{
		return mySound;
	}
	public String getType()
	{
		return myType;
	}
}
class NamedCow extends Cow
{
	private String myName;
	public NamedCow(String sound, String name, String type)
	{
		mySound=sound;
		myType=type;
		myName=name;
	}
	public NamedCow()
	{
		myName="seaCow";
		mySound="snicker";
		myType="hydromalis";
	}
	public String getName()
	{
		return myName;
	}
}
class Chick implements Creature
{
	private String mySound;
	private String myType;
	private int chance=(int)(Math.random()*10);
	public Chick(String sound, String sound2, String type)
	{
		myType=type;
		if (chance>=5)
		{
			mySound=sound;
		}
		else if (chance<5)
		{
			mySound=sound2;
		}
	}
	public Chick()
	{
		if (chance>=5)
		{
			mySound="screech";
		}
		else if (chance<5)
		{
			mySound="hiss";
		}
		myType="gallus gallus";
	}
	public String getSound()
	{
		return mySound;
	}
	public String getType()
	{
		return myType;
	}
}
class Pig implements Creature
{
	private String mySound;
	private String myType;
	public Pig(String sound, String type)
	{
		mySound=sound;
		myType=type;
	}
	public Pig()
	{
		mySound="snort";
		myType="sus scrofa scrofa";
	}
	public String getSound()
	{
		return mySound;
	}
	public String getType()
	{
		return myType;
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OldMacDonald" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
