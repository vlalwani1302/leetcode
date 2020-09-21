package leetcode.john.fb.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class GroupShiftedStrings {
	public static void main(String[] args) {
		System.out.println(groupStrings(new String[] {"ab", "ba"}));
		
		System.out.println(groupStrings(new String[] {"ay", "bz", "ca", "db", "zx"}));
		String[] strings = new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(groupStrings(strings));
		/*
		groupStrings(new String[] {"fpbnsbrkbcyzdmmmoisaa","cpjtwqcdwbldwwrryuclcngw","fnuqwejouqzrif","js",
				"qcpr","zghmdiaqmfelr","iedda","dgwlvcyubde","lpt","qzq","zkddvitlk","xbogegswmad","mkndeyrh",
				"llofdjckor","lebzshcb","firomjjlidqpsdeqyn","dclpiqbypjpfafukqmjnjg","lbpabjpcmkyivbtgdwhzlxa",
				"wmalmuanxvjtgmerohskwil","yxgkdlwtkekavapflheieb","oraxvssurmzybmnzhw","ohecvkfe","kknecibjnq",
				"wuxnoibr","gkxpnpbfvjm","lwpphufxw","sbs","txb","ilbqahdzgij","zvuur","yfglchzpledkq","eqdf",
				"nw","aiplrzejplumda","huoybvhibgqibbwwdzhqhslb","rbnzendwnoklpyyyauemm"});
				*/
		System.out.println(groupStrings(new String[] {"eqdf", "qcpr"}));
		
	}
    
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strings){
            int size = s.length();
            if(size==0) {
            	map.putIfAbsent("-2", new ArrayList<>());
            	map.get("-2").add(s);
            	continue;
            }
            if(size==1) {
            	map.putIfAbsent("-1", new ArrayList<>());
            	map.get("-1").add(s);
            	continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(size + ",");
            for(int i=1; i<size; i++) {
            	int diff = s.charAt(i) - s.charAt(i-1);
            	if(diff>=0) {
            		sb.append(diff);
            	}else {
            		sb.append(26 + diff);
            	}
            }
            map.putIfAbsent(sb.toString(), new ArrayList<>());
        	map.get(sb.toString()).add(s);
        }
        return map.values().stream().collect(Collectors.toList());
    }
    
}