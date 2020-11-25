package leetcode.alice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static final String PIPE = "\\|";
    public static final String COMMA = ",";

    /*
     * Complete the function below.
     */
    public static void main(String[] args) {
		System.out.println(printHoldings("VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12"));
	}
    static String printHoldings(String portfolioString) {
        String[] portfolioHoldings = portfolioString.split(PIPE);
        List<Holding> holdings = new ArrayList<>();
        
        for(String str : portfolioHoldings){
            String[] holdingArr = str.split(COMMA);
            Holding holding = new Holding();
            holding.setAssetId(holdingArr[0]);
            holding.setAssetName(holdingArr[1]);
            holding.setQuantity(Integer.valueOf(holdingArr[2]));
            holdings.add(holding);
        }
        
        Collections.sort(holdings, (h1,h2) -> h1.getAssetId().compareTo(h2.getAssetId()));
        StringBuilder sb = new StringBuilder();
        
        String separator = "";
        for(Holding h : holdings) {
        	sb.append(separator);
        	sb.append(h.toString());
        	separator = COMMA + " ";
        }
        return sb.toString();
    }

    
    
}
class Holding{
    String assetId;
    String assetName;
    Integer quantity;
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
    
    @Override
    public String toString() {
    	return "[" + assetId + ", " + assetName + ", " + quantity + "]";
    }
    
}
