package leetcode.alice.string;
class OneEditDistance {
	public static void main(String[] args) {
		OneEditDistance obj = new OneEditDistance();
				System.out.println(obj.isOneEditDistance("ab", "cab"));
	}
    public boolean isOneEditDistance(String s, String t) {
     
        if(s.isEmpty() && t.isEmpty())
            return false;
        if(Math.abs(s.length() - t.length()) > 1)
            return false;
        
        if(s.length() == t.length()){
            return replaceOneChar(s, t);
        }else{
            return deleteOneChar(s, t);
        }
    }
    
    public boolean deleteOneChar(String s, String t){
        int i = 0; int j=0;
        boolean edit = false;

        while(i < s.length() && j < t.length()){
            if(s.charAt(i) != t.charAt(j)){
                if(!edit)
                    edit = true;
                else
                    return false;
                if(i+1 < s.length() && s.charAt(i+1) == t.charAt(j))
                    i++;
                else if(j+1 < t.length()  && s.charAt(i) == t.charAt(j+1))
                    j++;
                else
                	return false;
            }else{
                i++;j++;
            }
        }
       
        return true;
        
    }
    
    public boolean replaceOneChar(String s, String t){
        boolean edit = false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(!edit)
                    edit = true;
                else
                    return false;
            }
        }
        return true;
    }
}