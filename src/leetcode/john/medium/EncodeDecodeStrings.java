package leetcode.john.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {

	public static void main(String[] args) {
		EncodeDecodeStrings codec = new EncodeDecodeStrings();
		List<String> strs = new ArrayList<>();
		strs.add("63/Rc");
		strs.add("h");
		strs.add("BmI3FS~J9#vmk");
		strs.add("7uBZ?7*/");
		strs.add("24h+X");
		strs.add("O ");
		codec.decode(codec.encode(strs ));
	}
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
        	sb.append(str.length());
        	 sb.append("[");
             sb.append(str);
             sb.append("]");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	int i=0;
        List<String> result = new ArrayList<String>();
        while(i<s.length()){
        int j=i+1;
        while(s.charAt(j)!='[') j++;
        	String n=s.substring(i, j);
                int t=Integer.valueOf(n);
                System.out.print(t);
                result.add(s.substring(i+n.length()+1, i+n.length()+1+t));
                
                i=i+n.length()+1+t+1;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));