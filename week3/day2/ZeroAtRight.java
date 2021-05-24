package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroAtRight {
	public static void zeroAtRightMethod() {
		int[] num = {0,4,0,3,0,1,5,2,0,0};
		int countZero = 0;
		List<Integer> lstArr = new ArrayList<Integer>();
		// add int[] to Array List
		for (int numArr : num) {
			lstArr.add(numArr);
		}
		// Remove 0 from Array List
		for (int i = 0; i < lstArr.size(); i++) {
			if (lstArr.get(i) == 0) {
				lstArr.remove(i);
				countZero++;
			}
		}
		// Add counted 0 to the end of List
		for (int j = lstArr.size(); countZero > 0; j++, countZero--) {
			lstArr.add(j, 0);
		}
		System.out.println("Input is " + Arrays.toString(num));
		// Print the Final value
		System.out.print("Output is " + lstArr);
	}

	

	public static void main(String[] args) 
	{
		zeroAtRightMethod();
		
	}

}
