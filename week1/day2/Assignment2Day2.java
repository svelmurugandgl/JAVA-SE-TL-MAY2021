package week1.day2;
import java.util.Arrays;

public class Assignment2Day2 
{

	public void MissingElemementInAnArray() 
	{
		int[] arr = { 1, 2, 3, 7, 4, 6, 8, 10, 12, 14 };
		int temp, i, j, k, series = 1;
		System.out.println("Input Array is {1,2,3,7,4,6,8,10,12,14}");
		for (i = 0; i < arr.length; i++) 
		{
			for (j = i + 1; j < arr.length; j++)
			{
				if (arr[i] > arr[j]) 
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		// easy way to sort Arrays.sort(arr); Ascending order
		for (k = 0; k < arr.length; k++) 
		{
			if (arr[k] != series) 
			{
				System.out.println("#1:Missing Array Elements are= " + series);
				series++;
			}
			series++;
		}
		System.out.println();
	}

	public void FindIntersection() 
	{
		int set1[] = { 3, 2, 11, 4, 6, 7 }, set2[] = { 1, 2, 8, 4, 9, 7 }, i, j;
		System.out.println("set1[]={3,2,11,4,6,7} set2[]= {1,2,8,4,9,7}");
		for (i = 0; i < set1.length; i++) 
		{
			for (j = 0; j < set2.length; j++) 
			{
				if (set1[i] == set2[j]) 
				{
					System.out.println("#2:Intersection Elements are= " + set1[i]);
				}
			}
		}
		System.out.println();
	}

	public void Palindrome(String s1) 
	{
		String s2 = "";
		char strArr[] = new char[s1.length()];
		int i, j = 0;

		for (i = s1.length() - 1; i >= 0; i--, j++)
		{
			strArr[j] = s1.charAt(i);
			// s2=s2+s1.charAt(i); Java string method to cut strArr[] variable

		}

		s2 = String.valueOf(strArr);

		if (s1.equals(s2)) 
		{
			System.out.println("#3 "+s2 + " is Palindrome");
		} else {
			System.out.println("#3 "+s1 + " is NOT Palindrome");
		}

		System.out.println();

	}

	public void ChangeOddIndexToUpperCase(String test) 
	{
		String target = "";
		int i;
		char strArr[] = test.toCharArray();
		for (i = 0; i < strArr.length; i++) 
		{
			if (i % 2 != 0) {
				strArr[i] = Character.toUpperCase(strArr[i]);
			}
		}
		target = String.valueOf(strArr);

		System.out.println("#4:ODD Index Upper Case word is " + target);
		System.out.println();
	}

	public void Anagram(String src, String tgt)
	{
		String strCmp1, strCmp2;
		if (src.length() != tgt.length()) 
		{
			System.out.println(src + " and " + tgt + " is Not Anagram");
		} 
		else 
		{
			char srcArr[] = src.toCharArray();
			char tgtArr[] = tgt.toCharArray();
			Arrays.sort(srcArr);
			Arrays.sort(tgtArr);
			strCmp1 = String.valueOf(srcArr);
			strCmp2 = String.valueOf(tgtArr);
			if (strCmp1.equals(strCmp2)) 
			{
				System.out.println("#5:"+src + " and " + tgt + " is Anagram");
			} 
			else 
			{
				System.out.println("#5:"+src + " and " + tgt + " is Not Anagram");
		    }
		}
		System.out.println();
	}

	public void SumOfDigitsFromString(String text) 
	{
		int i, sum = 0;
		String digitNum = "";
		digitNum = text.replaceAll("[A-Za-z]", "");
		char digitArr[] = digitNum.toCharArray();
		for (i = 0; i < digitArr.length; i++) 
		{
			sum = sum + Character.getNumericValue(digitArr[i]);
		}
		System.out.println("#6:SumOfDigitsFromString(" + text + ")= " + sum);
		System.out.println();
	}

	public void CharOccurance(String str) 
	{
		int count = 0, i;
		char strArr[] = str.toCharArray();
		for (i = 0; i < strArr.length; i++) 
		{
			if (strArr[i] == 'e') 
			{
				count++;
			}
		}
		System.out.println("#7:"+"\"" + str + "\"" + " CharOccurance of 'e' is " + count);
	    System.out.println();
	}

	public void FindTypes(String test) 
	{
		int i, letter = 0, space = 0, num = 0, specialChar = 0;
		char testArr[] = test.toCharArray();
		for (i = 0; i < testArr.length; i++)
		{
			if (Character.isLetter(testArr[i])) 
			{
				letter++;
			} 
			else if (Character.isDigit(testArr[i])) 
			{
				num++;
			} 
			else if (Character.isSpaceChar(testArr[i])) 
			{
				space++;
			} 
			else 
			{
				specialChar++;
			}
		}
		System.out.println("#8:"+"\""+test+"\""+"\r\n"+"Types are Letter="+letter+"\r\nNumber="+num+"\r\nSpace="+space+"\r\nspecialCharacter="+specialChar);
	    System.out.println();
	}

	public static void main(String[] args) 
	{
		
		 Assignment2Day2 asObj = new Assignment2Day2();
		 asObj.MissingElemementInAnArray(); asObj.FindIntersection();
		 asObj.Palindrome("MOM"); asObj.Palindrome("SAVE");
		 asObj.ChangeOddIndexToUpperCase("letter");
		 asObj.ChangeOddIndexToUpperCase("velmurugan"); asObj.Anagram("stops","potss"); 
		 asObj.Anagram("abde", "dabc");
		 asObj.SumOfDigitsFromString("Tes12Le79af65");
		 asObj.SumOfDigitsFromString("T99L1e79af65");
		 asObj.CharOccurance("welcome to chennai");
		 asObj.CharOccurance("elephent-eagle");
		 asObj.FindTypes("$$ Welcome to 2nd Class of Automation $$ ");

	}

}
