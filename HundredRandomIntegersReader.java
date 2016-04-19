import java.util.*;
import java.io.*;

/**
 * This program scans a specified .txt file and divides the information into
 * 100 different values that are then stored into an array list. These values are 
 * then displayed in 10 lines of 10 numbers. After being sorted in descending order
 * the numbers are agai displayd in the same manner.
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com>
 *
 */
public class HundredRandomIntegersReader {
	
	public static void main(String[] args) {
		
		//array list to store the values from the text in 
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		try {
			//used to read the file
			Scanner read = new Scanner(new File("values.txt"));
			do {
				//reads information line by line
				String line = read.nextLine();
				
				//converts the string type numbers into integer type numbers
				int num = Integer.parseInt(line);
				
				//appends the values into the array list
				values.add(num);
			} while(read.hasNext());//continues as long as the file has a next line
			
			read.close();//closes the scanner reading the file
		} catch (FileNotFoundException fnf) {
			System.out.println("File not found.");
		}
		
		//prints the values in 10 lines of 10 numbers
		System.out.println("Here are the values read from the file:");
		display10X10Lines(values);
		
		//orders the number in descending order using selection sort
		greatestToLeast(values);
		
		//once again displays the values that have now been sorted in the same manner
		System.out.println("\n");
		System.out.println("Here are the same values sorted from greatest to least");
		display10X10Lines(values);
		
	}
	
	/**
	 * Displays the values of an array list in 10 lines of 10 numbers
	 * 
	 * @param nums the array list containing the values of the values that will be displayed
	 */
	public static void display10X10Lines(ArrayList<Integer> nums) {
		for (int i = 0; i < 100; i++)
		{
			//will skip to the next line every 10 numbers
			if (i % 10 == 0)
			{
				System.out.println();
			}
			System.out.print(nums.get(i) + ", ");
		}
	}
	
	/**
	 * Method that orders the numbers from an array list in descending order 
	 * using selection sort
	 * 
	 * @param nums the array list containing the values that will be sorted
	 */
	public static void greatestToLeast(ArrayList<Integer> nums) {
		for (int i = 0; i < nums.size(); i++)
		{
			int highest = i;
			for (int j = i + 1; j < nums.size(); j++)
			{
				if (nums.get(j) > nums.get(highest))
				{
					highest = j;
				}
			}
			int swap = nums.get(i);
			nums.set(i, nums.get(highest));
			nums.set(highest, swap);
		}
	}	
}
