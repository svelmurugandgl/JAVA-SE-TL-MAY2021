package week2.day2;

public class ReverseEvenWords {

	static String[] mySplit(String test) {
		String str[] = new String[7]; // fixed word size only works
		for (int i = 0, j = 0; i < test.length() - 1; j++, i++) {
			str[j] = "";
			while (test.charAt(i) != ' ') {
				str[j] = str[j] + test.charAt(i);
				i++;
				if (i == test.length()) {
					break;
				}

			}
		}
		return str;
	}

	static void reverseEvenString(String test) {
		String strArr[] = mySplit(test); // myOwn function
		// String strArr[]=test.split(" "); inbuild function
		String str = "", temp = "";
		for (int i = 0; i < strArr.length; i++) {
			if (((i + 1) % 2 == 0) && (strArr[i].length() > 1)) {
				for (int j = strArr[i].length() - 1; j >= 0; j--) {
					temp = temp + strArr[i].charAt(j);
				}
				strArr[i] = temp;
				temp = "";
			}
			if (i < strArr.length - 1) {
				str = str + strArr[i] + " ";
			} else {
				str = str + strArr[i];
			}

		}
		System.out.println("Test String=" + test + "\r\n" + "Output String=" + str + "\r\n");
	}

	public static void main(String[] args) {

		reverseEvenString("I am a software tester !!welcome!! india");
		reverseEvenString("SMARTS DL SW is ready !!hello!! AI");

	}

}
