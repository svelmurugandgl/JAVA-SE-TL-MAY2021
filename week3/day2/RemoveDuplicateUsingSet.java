package week3.day2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateUsingSet {

	public static void main(String[] args) {
		String input = "PayPal India";
		char[] charArr = input.toCharArray();

		Set<Character> values = new LinkedHashSet<Character>();

		for (Character eachChar : charArr) {

			values.add(eachChar);

		}

		List<Character> newval = new ArrayList<Character>(values);
		System.out.println("Input is " + input);
		System.out.print("Output is ");
		for (int i = 0; i <= newval.size() - 1; i++) {
			if (newval.get(i) != ' ') {
				System.out.print(newval.get(i));
			}
		}

	}

}
