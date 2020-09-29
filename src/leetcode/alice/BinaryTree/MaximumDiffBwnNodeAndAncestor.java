package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class MaximumDiffBwnNodeAndAncestor {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.insert(2);
		bt.insert(4);
		bt.insert(7);
		bt.insert(8);
		bt.insert(10);
		System.out.println(maxAncestorDiff(bt.root));

	}

	public static int maxAncestorDiff(TreeNode root) {

		Queue<Helper> queue = new LinkedList<Helper>();
		List<Integer> list = new ArrayList<Integer>();
		queue.add(new Helper(root, list));
		int max = 0;
		while (!queue.isEmpty()) {
			Helper pair = queue.poll();
			List<Integer> differences = pair.distance;
			if (pair.node.left != null) {
				int diff = pair.node.val - pair.node.left.val;
				list = new ArrayList<Integer>();
				list.add(diff);
				max = Math.max(max, Math.abs(diff));
				for (Integer i : differences) {
					max = Math.max(max, Math.abs(i + diff));
					list.add(i + diff);
				}
				queue.add(new Helper(pair.node.left, list));
			}
			if (pair.node.right != null) {
				int diff = pair.node.val - pair.node.right.val;
				list = new ArrayList<Integer>();
				list.add(diff);
				max = Math.max(max, Math.abs(diff));

				for (Integer i : differences) {
					max = Math.max(max, Math.abs(i + diff));
					list.add(i + diff);
				}
				queue.add(new Helper(pair.node.right, list));
			}
		}
		return max;
	}
}

class Helper {
	public TreeNode node;
	public List<Integer> distance;

	public Helper(TreeNode node, List<Integer> d) {
		this.node = node;
		distance = d;
	}
}