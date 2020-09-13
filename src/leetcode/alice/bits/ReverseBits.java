package leetcode.alice.bits;

public class ReverseBits {
	public static void main(String[] args) {
		reverseBits(43261596);
	}

	public static int reverseBits(int n) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			ans <<= 1;
			ans = ans | (n & 1);
			n >>= 1;
		}
		return ans;
	}
}
