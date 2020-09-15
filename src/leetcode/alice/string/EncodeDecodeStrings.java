package leetcode.alice.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {

	public static void main(String[] args) {
		EncodeDecodeStrings codec = new EncodeDecodeStrings();
		List<String> strs = new ArrayList<String>();
		strs.add("");
		codec.decode(codec.encode(strs ));
	}
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) return Character.toString((char)258);

        String delimiter = Character.toString((char) 257);;
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
            sb.append(delimiter);

        }
        
        //sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String d = Character.toString((char)258);
        if (s.equals(d)) return new ArrayList();

        String delimiter = Character.toString((char) 257);

        String[] arr = s.split(delimiter,-1);
        List<String> list = Arrays.asList(arr);
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));