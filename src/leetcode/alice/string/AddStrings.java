package leetcode.alice.string;

import java.math.BigInteger;

class AddStrings {
	public static void main(String[] args) {
		addStrings("3876", "65");

		//addStrings("3876620623801494171", "6529364523802684779");
	}

	public static String addStrings1(String num1, String num2) {

		BigInteger val = new BigInteger(num1);
		BigInteger val2 = val.add(new BigInteger(num2));
		return val2.toString();
	}

	public static String addStrings(String num1, String num2) {

		StringBuilder result = new StringBuilder();
		int p1 = num1.length() - 1;
		int p2 = num2.length() - 1;
		int carry = 0;
		while (p1 >= 0 || p2 >= 0) {
			int x1 = 0;
			if (p1 >= 0)
				x1 = num1.charAt(p1) - '0';

			int x2 = 0;
			if (p2 >= 0)
				x2 = num2.charAt(p2) - '0';

			int value = (x1 + x2 + carry) % 10;
			carry = (x1 + x2 + carry) / 10;
			result.append(value);
			p1--;
			p2--;

		}
		if(carry != 0)
			result.append(carry);
		return result.reverse().toString();
	}
}