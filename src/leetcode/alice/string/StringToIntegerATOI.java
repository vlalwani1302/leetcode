package leetcode.alice.string;

class StringToIntegerATOI {
	public static void main(String[] args) {
		System.out.println(myAtoi("-2147483648"));
	}

	public static int myAtoi(String str) {
		int result = 0;
		if (str == null || str.isEmpty())
			return result;

		if (Character.isLetter(str.charAt(0))) {
			return result;
		}

		int i = 0;
		// remove white spaces
		while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
			i++;
		}
		
		//check if number is negative
		boolean minus = false;
		if (i < str.length() && str.charAt(i) == '-') {
			minus = true;
			i++;
		} else if (i < str.length() && str.charAt(i) == '+') {
			i++;
		}
		
		//remove zero from begining 
		while (i < str.length() && str.charAt(i) == '0') {
			i++;
		}
		
		StringBuilder sb = new StringBuilder();
		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			sb.append(str.charAt(i));
			i++;
		}
		if (sb.length() == 0)
			return result;

		if (sb.length() > 12) {
			if (minus) {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}

		long number = Long.parseLong(sb.toString());
		number = minus ? number * -1 : number;

		if (number > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		if (number < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		return (int) number;
	}
}
