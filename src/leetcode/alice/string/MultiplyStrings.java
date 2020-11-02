package leetcode.alice.string;

class MultiplyStrings {
	public static void main(String[] args) {
		System.out.println(multiply("456", "23"));
	}
    public static String multiply(String num1, String num2) {

        
        int s1=num1.length(); int s2 = num2.length();
        int[] vals = new int[s1+s2];
        
        for(int i=s1-1; i>=0; i--){
                   
            for(int j=s2-1; j>=0; j--){
                int c1 = (int) num1.charAt(i) - '0' ;
                int c2 = (int) num2.charAt(j) - '0' ;
                int product = c1 * c2;
                int sum = vals[i+j+1] + product;
                vals[i+j] += sum/10;
                vals[i+j+1] = sum%10;
              
            }
           
        }    
        StringBuilder sb = new StringBuilder();
        for(int val : vals){
            if(sb.length() != 0  || val != 0){
                sb.append(val);
            }
        }
        
        
        return sb.length() == 0 ? "0" : sb.toString();
           

        }

}