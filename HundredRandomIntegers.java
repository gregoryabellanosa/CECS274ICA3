import java.util.*;
import java.io.*;
/**
 * This program generates 100 random numbers between 1 and 100 and stores
 * these values into an array list. The contents of this array ist is then written 
 * into an external .txt file with one number per line.
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com>
 *
 */
public class HundredRandomIntegers {

	public static void main(String[] args) {

		Random randNum = new Random();
		
		//creates an array list in which the random values will be stored
		ArrayList<Integer> randValues = new ArrayList<Integer>();
		
		//appends a newly generated number to the end of the array list
		for (int i = 0; i < 100; i++)
		{
			int num = randNum.nextInt(99);
			randValues.add(i, num);
		}
		
		try{
			//writes the contents of the array list into the new file "values.txt"
			PrintWriter writer = new PrintWriter("values.txt");
			
			for (int i = 0; i < randValues.size(); i++)
			{
				writer.println(randValues.get(i));
			}
			
			writer.close(); //close writer
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found.");
		}

	}

} 
