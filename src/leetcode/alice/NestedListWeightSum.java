package leetcode.alice;

import java.util.List;

public class NestedListWeightSum {
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        
        helper(nestedList, 1);

        return sum;
    }
    
    public void helper(List<NestedInteger> nestedList, int depth){
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                sum+=(ni.getInteger()*depth);
            }else{
               helper(ni.getList(), depth+1); 
            }
        }
    }
}

// useless class - refer leetcode -339
class NestedInteger{
	public boolean isInteger() {
		return true;
	}
    public Integer getInteger() {
    	return 1;
    }
    public List<NestedInteger> getList(){
    	return null;
    }


}