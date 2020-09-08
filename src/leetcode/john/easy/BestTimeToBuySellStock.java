package leetcode.john.easy;

public class BestTimeToBuySellStock {
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int  purchasePrice = Integer.MAX_VALUE;
		for(int i=0; i<prices.length; i++) {
			if(prices[i] <  purchasePrice) {
				 purchasePrice = prices[i];
			}else {
				maxProfit = Math.max(maxProfit, prices[i] - purchasePrice);
			}
		}
		return maxProfit;
    }
	
	public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        int[] prices2 = new int[] {7,4,5,1,6,2};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));
	}
}
