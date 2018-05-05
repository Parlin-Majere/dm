import chn.util.*;

public class Main 
{

	public static void main(String[] args) 
	{
		int Messi=0;
		int Barcelona=0;
		int Suarez=0;
		int Title=0;
		int Soccer=0;
		
		FileInput document1 = new FileInput("document1.txt");
		FileInput document2 = new FileInput("document2.txt");
		
		while(document1.hasMoreLines())
		{
			String input = document1.readLine();
			String[] temp = input.split(" ");
			for(int i = 0 ; i < temp.length; i++)
			{
				temp[i]=temp[i].toLowerCase();
				switch(temp[i])
				{
					case "messi":
						Messi++;
						break;
					case "barcelona":
						Barcelona++;
						break;
					case "suarez":
						Suarez++;
						break;
					case "title":
						Title++;
						break;
					case "soccer":
						Soccer++;
						break;
				}
			}
		}
		
		int[] vect1 = {Messi,Barcelona,Suarez,Title,Soccer};
		Messi=0; Barcelona=0; Suarez=0; Title=0; Soccer=0;
		
		while(document2.hasMoreLines())
		{
			String input = document2.readLine();
			String[] temp = input.split(" ");
			for(int i = 0 ; i < temp.length; i++)
			{
				temp[i]=temp[i].toLowerCase();
				switch(temp[i])
				{
					case "messi":
						Messi++;
						break;
					case "barcelona":
						Barcelona++;
						break;
					case "suarez":
						Suarez++;
						break;
					case "title":
						Title++;
						break;
					case "soccer":
						Soccer++;
						break;
				}
			}
		}
		int[] vect2 = {Messi,Barcelona,Suarez,Title,Soccer};
		
		
		double result = 0;
		int resulting = dotpro(vect1,vect2);
		double magni = vect_length(vect1)*vect_length(vect2);
		result = resulting/magni;
		FileOutput writer = new FileOutput("output.txt");
		
		writer.println("The cosine Similarity is " + result);
		writer.close();
		System.out.println("The cosine Similarity is " + result);
		
		
		
		
	}
	
	public static int dotpro(int[] vect1, int[] vect2)
	{
		int result = 0;
		for(int i = 0; i < vect1.length; i++)
		{
			result+= vect1[i]*vect2[i];
		}
		return result;
	}
	
	public static double vect_length(int[] vect)
	{
		double result=0;
		double sum = 0;
		for(int i = 0; i < vect.length;i++)
		{
			sum+=Math.pow(vect[i],2);
		}
		
		result = Math.sqrt(sum);
		
		return result;
	}

}
