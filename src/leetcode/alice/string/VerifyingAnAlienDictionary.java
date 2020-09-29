package leetcode.alice.string;

import java.util.ArrayList;
import java.util.List;

class VerifyingAnAlienDictionary {
	public static void main(String[] args) {
		System.out.println(isAlienSorted(new
		 String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
		//System.out.println(isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz"));
		//System.out.println(isAlienSorted(new String[] { "apple","app"},	"abcdefghijklmnopqrstuvwxyz"));
		System.out.println(isAlienSorted(new String[] {"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"},
				"zkgwaverfimqxbnctdplsjyohu"));
	}

	public static boolean isAlienSorted(String[] words, String order) {
		int[] alienSeq = new int[26];

		for (int i = 0; i < order.length(); i++) {
			int c = order.charAt(i) - 'a';
			alienSeq[c] = i;
		}
		List<int[]> l = new ArrayList<int[]>();
		for (int j = 0; j < words.length-1; j++) {
			String word = words[j];
			String nextWord = words[j + 1];

			for (int k = 0; k < word.length() ; k++) {
				if(k >= nextWord.length()) {
					return false;
				}
				if (alienSeq[word.charAt(k) - 'a'] == alienSeq[nextWord.charAt(k) - 'a']) {
					continue;
				} else if (alienSeq[word.charAt(k) - 'a'] < alienSeq[nextWord.charAt(k) - 'a']) {
					break;
				} else {
					return false;
				}
			}
		}

		return true;
	}
}