package leetcode.john.easy.array;

public class BestTimeToBuySellStock2 {
	public static int maxProfit(int[] prices) {
		int endProfit = 0;
		int maxProfit = 0;
		int purchasePrice = Integer.MAX_VALUE;
		for(int i=0; i<prices.length; i++) {
			if(prices[i] <  purchasePrice || prices[i] < prices [i-1]) {
				 purchasePrice = prices[i];
				 endProfit = endProfit + maxProfit;
				 maxProfit = 0;
			}else {
				maxProfit = Math.max(maxProfit, prices[i] - purchasePrice);
			}
		}
		endProfit = endProfit + maxProfit;
		return endProfit;
    }
	
	public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6};
        int[] prices2 = new int[] {1,2,3,4,5};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));
	}
}
