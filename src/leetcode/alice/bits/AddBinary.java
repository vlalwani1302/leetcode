package leetcode.alice.bits;
class AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
    public static String addBinary(String a, String b) {
        
        int p1 = a.length()-1;
        int p2 = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(p1 >=0 || p2 >=0){
            int x1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            
            int value = (x1 + x2 + carry)%2;
            carry = (x1 + x2 + carry)/2;
            
            sb.append(value);
            p1--;p2--;
        }
        
        if(carry == 1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}