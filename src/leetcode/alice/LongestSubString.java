package leetcode.alice;

public class LongestSubString {

	public static void main(String[] args) {
		String s = "imissyoutoo";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
		int n = s.length();
		int result = 1;
		
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n ; i++){
            if(sb.indexOf(String.valueOf(s.charAt(i))) < 0) {
            	sb.append(s.charAt(i));
            }else {
            	result = Math.max(result, sb.length());
            	sb.delete(0, sb.indexOf(String.valueOf(s.charAt(i))) + 1);
            	sb.append(s.charAt(i));
            }
        }
    	result = Math.max(result, sb.length());

		return result;
    }
}
