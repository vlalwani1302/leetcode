package leetcode.alice.string;

import java.util.ArrayList;
import java.util.List;

class GroupShiftedStrings {
	public static void main(String[] args) {
		String[] strings = new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		groupStrings(strings);
		groupStrings(new String[] {"ab", "ba"});
		
		groupStrings(new String[] {"ay", "bz", "ca", "db", "zx"});
		/*
		groupStrings(new String[] {"fpbnsbrkbcyzdmmmoisaa","cpjtwqcdwbldwwrryuclcngw","fnuqwejouqzrif","js",
				"qcpr","zghmdiaqmfelr","iedda","dgwlvcyubde","lpt","qzq","zkddvitlk","xbogegswmad","mkndeyrh",
				"llofdjckor","lebzshcb","firomjjlidqpsdeqyn","dclpiqbypjpfafukqmjnjg","lbpabjpcmkyivbtgdwhzlxa",
				"wmalmuanxvjtgmerohskwil","yxgkdlwtkekavapflheieb","oraxvssurmzybmnzhw","ohecvkfe","kknecibjnq",
				"wuxnoibr","gkxpnpbfvjm","lwpphufxw","sbs","txb","ilbqahdzgij","zvuur","yfglchzpledkq","eqdf",
				"nw","aiplrzejplumda","huoybvhibgqibbwwdzhqhslb","rbnzendwnoklpyyyauemm"});
				*/
		groupStrings(new String[] {"eqdf", "qcpr"});
		
	}
    public static List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        boolean[] visited = new boolean[strings.length];
        for(int i=0; i <strings.length; i++){
            List<String> list = new ArrayList<String>();
            String s = strings[i];
            
            if(!visited[i]){
                list.add(s);
                visited[i] = true; 
            }else{
                continue;
            }
            
            int size = s.length();
            int[] seq = new int[size-1];
            for(int j=0; j<size; j++){
                if(j+1 < size)
                    seq[j] = (int)s.charAt(j+1) - (int)s.charAt(j);
            }
            
            for(int k=i+1; k <strings.length; k++){
                if(size == strings[k].length() && !visited[k]){
                	String s1 = strings[k];
                	boolean isSameSeq = true;
                    for(int l=0; l<size; l++){
                        if(l+1 < size){
                        	int num = (int)(s1.charAt(l)) + seq[l];
                        	if(num > 122) num = num - 122 + 96;
                        	if(num < 97) num = num + 26;
                            if((int)s1.charAt(l+1) == num){
                                
                            } else{
                                isSameSeq = false;
                                break;
                            }
                        }
                    }
                    if(isSameSeq) {
                    	list.add(strings[k]);
                    	visited[k] = true;
                    }
                }
            }
            
            result.add(list);
        }
		return result;
    }
}