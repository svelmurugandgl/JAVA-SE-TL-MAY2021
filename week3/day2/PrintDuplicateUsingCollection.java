package week3.day2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class PrintDuplicateUsingCollection 
{

	public static void PrintDuplicate()
	{
		int[] data= {1,1,3,3,8,3,11,5,6,4,7,6,7,10,1,10,8,8,1};
		//Add int[] into Linked List
		LinkedList <Integer> linkedList=new LinkedList<Integer>();
		LinkedList <Integer> linkeddupList=new LinkedList<Integer>();
		for(int setVal: data)
		{
			linkedList.add(setVal);
		}
		
		//Find and Save Duplicate Value into duplicate list
		for(int i=0;i<linkedList.size();i++)
		{    
			//To Remove Duplicate except Last Duplicate Element(x,x) only
			/*if(i<linkedList.size()-1)
			{
				if(linkedList.get(i)==linkedList.get(i+1))
				{
					continue;
				}
			}*/
		    for(int j=i+1;j<linkedList.size();j++)
			{
			  if(linkedList.get(i)==linkedList.get(j))
			    {
			      linkeddupList.add(linkedList.get(i));
			      break;
			    }
			}
						
		}
		//Remove multiple Duplicate Element using LinkedHashSet in List
		LinkedHashSet <Integer> finalSet=new LinkedHashSet<Integer>(linkeddupList);
		System.out.println("Input is " + Arrays.toString(data));
		System.out.print("Output is ");
		System.out.println(finalSet);
	}
	public static void main(String[] args) 
	{
		PrintDuplicate();	

	}

}
