package leetcode.alice.array;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static final String PIPE = "\\|";
	public static final String COMMA = ",";
	public static final String COLON = ":";

	/*
	 * Complete the function below.
	 */
	//
	public static void main(String[] args) {
		//System.out.println(printHoldings("VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12"));
		System.out.println(generateTransactions(
				"VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12:VOD,Vodafone,16|GOOG,Google,10|MSFT,Microsoft,25"));
	}

	static String printHoldings(String portfolioString) {
		String[] portfolioHoldings = portfolioString.split(PIPE);
		List<Holding> holdings = new ArrayList<>();

		for (String str : portfolioHoldings) {
			String[] holdingArr = str.split(COMMA);
			Holding holding = new Holding();
			holding.setAssetId(holdingArr[0]);
			holding.setAssetName(holdingArr[1]);
			holding.setQuantity(BigDecimal.valueOf(holdingArr[2]));
			holdings.add(holding);
		}

		Collections.sort(holdings, (h1, h2) -> h1.getAssetId().compareTo(h2.getAssetId()));
		StringBuilder sb = new StringBuilder();

		String separator = "";
		for (Holding h : holdings) {
			sb.append(separator);
			sb.append(h.toString());
			separator = COMMA + " ";
		}
		return sb.toString();
	}

	static String generateTransactions(String input) {
		String[] portfolioBenchmark = input.split(COLON);

		List<Holding> holdings = populateHolding(portfolioBenchmark[0]);
		Map<String, BigDecimal> benchmarkMap = populateBenchmark(portfolioBenchmark[1]);
		List<Transaction> transactions = new ArrayList<Transaction>();
		for(Holding holding : holdings) {
			if(benchmarkMap.containsKey(holding.getAssetId()) 
					&& !holding.getQuantity().equals(benchmarkMap.get(holding.getAssetId()))){
				Transaction transaction = new Transaction();
				BigDecimal benchmark = benchmarkMap.get(holding.getAssetId());
				String transactionType = holding.getQuantity().compareTo(benchmark) > 0 ? "SELL" : "BUY";
				transaction.setAssetId(holding.getAssetId());
				transaction.setTransactionType(transactionType);
				transaction.setQuantity(holding.getQuantity().subtract(benchmark).abs().setScale(2));
				
				transactions.add(transaction);
			}
		}
		
		Collections.sort(transactions, (t1, t2) -> t1.getAssetId().compareTo(t2.getAssetId()));

		StringBuilder sb = new StringBuilder();

		String separator = "";
		for (Transaction t : transactions) {
			sb.append(separator);
			sb.append(t.toString());
			separator = COMMA + " ";
		}
		return sb.toString();

	}

	private static Map<String, BigDecimal> populateBenchmark(String input) {
		Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
		String[] portfolioHoldings = input.split(PIPE);

		for (String str : portfolioHoldings) {
			String[] holdingArr = str.split(COMMA);
			map.put(holdingArr[0], new BigDecimal(holdingArr[2]));
		}
		return map;
	}

	private static List<Holding> populateHolding(String input) {
		String[] portfolioHoldings = input.split(PIPE);

		List<Holding> holdings = new ArrayList<>();

		for (String str : portfolioHoldings) {
			String[] holdingArr = str.split(COMMA);
			Holding holding = new Holding();
			holding.setAssetId(holdingArr[0]);
			holding.setAssetName(holdingArr[1]);
			holding.setQuantity(new BigDecimal(holdingArr[2]));
			holdings.add(holding);
		}
		return holdings;
	}

}

class Holding {
	String assetId;
	String assetName;
	BigDecimal quantity;

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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "[" + assetId + ", " + assetName + ", " + quantity + "]";
	}

}

class Transaction {
	String assetId;
	String transactionType;
	BigDecimal quantity;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "[" + transactionType + ", " + assetId + ", " + quantity + "]";
	}

}