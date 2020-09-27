package leetcode.john.fb.tree.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
class Point{
	int x;
	int y;
	int val;
	public Point(int x, int y, int val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}
}
public class VerticalOrderTraversalTreeValue {
	 public List<List<Integer>> verticalTraversal(TreeNode root) {
		 
		 List<List<Integer>> output = new ArrayList<>();
		    if (root == null) {
		      return output;
		    }
		    Map<Integer, List<Point>> map = new TreeMap<>();
		    getOrder(root, 0, 0, map);
		    List<List<Point>> listPoint = map.values().stream().collect(Collectors.toList());
		    for(List<Point> list : listPoint) {
		    	Collections.sort(list, (p1,p2)-> p1.x == p2.x ? p1.y==p2.y ? p1.val-p2.val
		    										: p1.y - p2.y : p1.x - p2.x);
		    	
		    	output.add(list.stream().map(e ->e.val).collect(Collectors.toList()));
		    }
		    return output;
		  }
	 
	 public static void getOrder(TreeNode root, int x, int y, Map<Integer, List<Point>> map) {
		 if (root == null) {
		      return;
		 }
		 map.putIfAbsent(x, new ArrayList<>());
		 map.get(x).add(new Point(x, y, root.val));
		 getOrder(root.left, x-1, y-1, map);
		 getOrder(root.right, x+1, y-1, map);
	}
}
