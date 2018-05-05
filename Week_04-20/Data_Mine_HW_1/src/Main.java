import apcslib.*;
import chn.util.FileInput;
import java.awt.Color;
import java.util.ArrayList;


public class Main 
{
	public static void main(String[] args) 
	{
		FileInput data = new FileInput("data.txt");
		ArrayList<String> actual = new ArrayList<String>();
		
		while(data.hasMoreLines())
		{
			String input = data.readLine();
			String [] values = input.split(",");
			for(int i = 0; i<values.length;i++)
			{
				actual.add(values[i]);
			}
		}
		
		ArrayList<String> Distinct = new ArrayList<String>();
		for(int i = 0; i < actual.size(); i++)
		{
			int count = 0;
			String temp = actual.get(i);
			for(int k = 0; k < actual.size(); k++)
			{
				if(temp.equals(actual.get(k)))
				{
					count++;
				}
			}
			boolean added = false;
			String adding = ""+temp+","+count;
			for(int k = 0; k < Distinct.size(); k++)
				if(adding.equals(Distinct.get(k)))
					added = true;
			if(!added)
				Distinct.add(adding);
		}
		
		for(int i = 0 ; i<actual.size();i++)
			System.out.print(actual.get(i)+" ");
		System.out.println();
		
		int max = 0;
		int min = 0;
		for(int i = 0; i < Distinct.size(); i++)
		{
			int posi = Distinct.get(i).indexOf(',');
			int temp = Integer.parseInt(Distinct.get(i).substring(posi+1));
			if(temp>max)
				max = temp;
			if(temp<min)
				min = temp;
		}
		
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		
		
		SketchPad paper = new SketchPad(1200,600);
		DrawingTool pencil = new DrawingTool(paper);
		pencil.up();
		pencil.move(-500,-100);
		pencil.down();
		for(int i = 0; i < Distinct.size();i++)
		{
			pencil.up();
			pencil.setDirection(0);
			pencil.move(30);
			
			int posi = Distinct.get(i).indexOf(',');
			int temp = Integer.parseInt(Distinct.get(i).substring(posi+1));
			double value = temp;
			double height = value/max*1.0*300;
			
			pencil.setDirection(90);
			pencil.move(height/2);
			
			pencil.down();
			pencil.drawRect(20, height);
			
			pencil.up();
			pencil.setDirection(270);
			pencil.move(height/2+10);
			pencil.down();
			pencil.drawString(Distinct.get(i).substring(0, posi));
			pencil.up();
			pencil.setDirection(90);
			pencil.move(10);
		}
	}

}
