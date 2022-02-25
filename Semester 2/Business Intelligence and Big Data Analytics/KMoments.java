/*
	* A Java program to calculate 
	* Oth, 1st and 2nd moment.
	
	* It uses a hardcoded stream of 15 characters.
	
	** Working **
		1. Create an ArrayList containing the count of each
			unique element.
		2. Zeroth moment will be the length of said 
			ArrayList.
		3. First moment will be the sum of all the 
			elements in said ArrayList.
		4. Second moment will be the sum of the squares 
			of each elements in said ArrayList.
*/

import java.io.*;
import java.util.*;

class KMoments
{
	public static void main(String[] args)
	{
		char stream[] = {'a','b','c','b','d','a','c','d','a','b','d','c','a','a','b'};
		int n = stream.length;
		int zerothMoment = 0, firstMoment = 0, secondMoment = 0, count = 1;
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		System.out.println("Given stream is:");
		for(char character : stream)
		{
			System.out.print(character + "  ");
		}
		System.out.println("\n\n");
		Arrays.sort(stream);
		
		for(int i = 1; i < n; i++)
		{
			if(stream[i] == stream[i - 1])
				count++;
			else
			{
				arrayList.add(count);
				count = 1;
			}
		}
		arrayList.add(count);
		zerothMoment = arrayList.size();
		System.out.println("Zeroth moment:\t\t\t" + zerothMoment);
		
		for(int i : arrayList)
		{
			firstMoment += i;
			secondMoment += i * i;
		}
		System.out.println("First Moment:\t\t\t" + firstMoment);
		System.out.println("Second Moment:\t\t\t" + secondMoment);
	}
}