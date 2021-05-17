package week2.day2;

public class ReverseString {
	static void reverseStringMethod1(String test) {
		String str = "";
		for (int i = test.length() - 1; i >= 0; i--) {
			str = str + test.charAt(i);
		}
		System.out.println("Reversed String Method1= " + str + "\r\n");
	}

	static void reverseStringMethod2(String test) {
		char arr[] = test.toCharArray();
		char str[] = new char[arr.length];
		for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
			str[j] = arr[i];
		}
		String finalStr = new String(str); // String finalStr=String.valueOf(str);
		System.out.println("Reversed String Method2= " + finalStr + "\r\n");
	}

	static void reverseStringMethod3(String test) {
		char arr[] = test.toCharArray();
		String str = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			str = str + arr[i];
		}
		System.out.println("Reversed String Method3= " + str + "\r\n");
	}

	public static void main(String[] args) {
		reverseStringMethod1("feeling good method1");
		reverseStringMethod2("feeling good method2");
		reverseStringMethod3("feeling good method3");

	}

}
