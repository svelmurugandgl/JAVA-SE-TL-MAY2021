package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		String[] input = { "HCL", "Wipro", "Aspire Systems", "CTS" };
		List<String> lstValue = new ArrayList<String>();
		for (String iterate : input) {
			lstValue.add(iterate);
		}
		Collections.sort(lstValue);
		System.out.println("Input= {\"HCL\",\"Wipro\",\"Aspire Systems\",\"CTS\"}");
		System.out.print("Output= ");
		for (int i = lstValue.size() - 1; i >= 0; i--) {
			System.out.print(lstValue.get(i) + " ");
		}

	}

}
