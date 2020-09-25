package leetcode.john.fb.tree.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import leetcode.john.TreeNode;

/* Q 173
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 */
		
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
	TreeNode node;
	Integer column;
	public Pair(TreeNode node, Integer column) {
		super();
		this.node = node;
		this.column = column;
	}
}
public class VerticalOrderTraversalTree {
	 public List<List<Integer>> verticalOrder(TreeNode root) {
		 List<List<Integer>> output = new ArrayList<>();
		    if (root == null) {
		      return output;
		    }

		    Map<Integer, ArrayList<Integer>> columnTable = new HashMap<>();
		    Queue<Pair> queue = new ArrayDeque<>();
		    int column = 0;
		    queue.offer(new Pair(root, column));

		    while (!queue.isEmpty()) {
		      Pair p = queue.poll();
		      root = p.node;
		      column = p.column;

		      if (root != null) {
		        columnTable.putIfAbsent(column, new ArrayList<>());
		        columnTable.get(column).add(root.val);

		        queue.offer(new Pair(root.left, column - 1));
		        queue.offer(new Pair(root.right, column + 1));
		      }
		    }

		    List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
		    Collections.sort(sortedKeys);
		    for(int k : sortedKeys) {
		      output.add(columnTable.get(k));
		    }

		    return output;
		  }
// **********************************************-----------------------------------------************//
	 public List<List<Integer>> verticalOrder3(TreeNode root) {
		 List<List<Integer>> output = new ArrayList<>();
		    if (root == null) {
		      return output;
		    }
		    Map<Integer, ArrayList<Integer>> columnTable = new HashMap<>();
		    List<List<Integer>> lists = new ArrayList<List<Integer>>();
			createList(root, columnTable, 0, 0, lists );
			List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
		    Collections.sort(sortedKeys);
		    for(int k : sortedKeys) {
		      output.add(columnTable.get(k));
		    }

		    return output;
		  }
	 
	 public static void createList(TreeNode root, Map<Integer, ArrayList<Integer>> columnTable, Integer level, Integer column, List<List<Integer>> lists){
	        if(root == null)
	            return;
	        
	        List<Integer> list = null;
	        if(lists.size() == level){
	            list = new ArrayList<Integer>();
	            
	            lists.add(list);
	        }else{
	            list = lists.get(level);
	        }
	        list.add(root.val);
	        columnTable.putIfAbsent(column, new ArrayList<>());
	        columnTable.get(column).add(root.val);
	        createList(root.getLeft(), columnTable, level+1, column - 1, lists);
	        createList(root.getRight(), columnTable, level+1, column + 1, lists);
	    }
}
