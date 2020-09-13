package leetcode.alice.bits;

class CountingBits {
	public static void main(String[] args) {
		countBits(4);
	}

	public static int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			int count = 0;
			int n = i;
			while (n != 0) {
				count++;
				n = n & (n - 1);
			}
			result[i] = count;
		}

		return result;
	}

	public int[] countBits1(int num) {
		int[] result = new int[num + 1];
		result[0] = 0;

		for (int i = 1; i <= num; i++) {
			int bitCount = 0;

			bitCount += countSetBitsUtil(i);
			result[i] = bitCount;
		}

		return result;
	}

	public int countSetBitsUtil(int x) {
		if (x <= 0)
			return 0;
		return (x % 2 == 0 ? 0 : 1) + countSetBitsUtil(x / 2);
	}
}