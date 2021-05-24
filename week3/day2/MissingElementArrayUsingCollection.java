package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingElementArrayUsingCollection {
	public static void missingElementList()
	{
		
		int[] arr = {1,2,3,7,4,6,8,10,11,13,15};
		List <Integer> lstArr=new ArrayList<Integer>();
		List <Integer> finalstArr=new ArrayList<Integer>();
		//Add int[] into Array List
		for(int tempArr:arr)
		{
			lstArr.add(tempArr);
		}
		Collections.sort(lstArr);
		for(int i=0,series=1;i<lstArr.size();i++,series++)
		{
			if(series!=lstArr.get(i))
			{
				finalstArr.add(series);
				series++;
			}
		}
		System.out.println("Input is "+Arrays.toString(arr));
		System.out.print("Output is "+finalstArr);
		
	}

	public static void main(String[] args) 
	{
		missingElementList();
      
	}

}
