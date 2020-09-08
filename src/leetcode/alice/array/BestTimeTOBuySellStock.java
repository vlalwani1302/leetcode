package leetcode.alice.array;
class BestTimeTOBuySellStock {
	public static void main(String[] args) {
		int[] a = new int[] {7,1,5,3,6,4};
		maxProfit(a);
	}
    public static int maxProfit(int[] prices) {
        
        int max = 0;
        int i=0;
        int j =i+1;
        while(i < j && j <= prices.length){
            if(j == prices.length ){
            	if(i < prices.length-2) {
            		i++;
            		j = i+1;
            	}else {
            		break;
            	}
            }
            if(prices[j] > prices[i]){
                int diff = prices[j] - prices[i];
                max = Math.max(max, diff);
            }
            j++;
            
        }
        return max;
    }
}