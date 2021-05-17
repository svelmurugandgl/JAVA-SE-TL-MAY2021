package week2.day2;

public class RemoveDuplicateString {

	static void removeDuplicateString(String test) {
		String finalStr = "";
		String str[] = test.split(" ");
		for (int i = 0; i < str.length; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].equalsIgnoreCase(str[j])) {
					str[j] = "";
				}
			}
		}
		for (int i = 0; i < str.length; i++) {
			if (i != str.length - 1) {
				finalStr = finalStr + str[i] + " ";
			} else {
				finalStr = finalStr + str[i];
			}
		}
		System.out.println(finalStr.replaceAll("\\s+", " "));
	}

	public static void main(String[] args) {

		removeDuplicateString("We learn java basics as part of java sessions in java week1 learn java1");

	}

}
