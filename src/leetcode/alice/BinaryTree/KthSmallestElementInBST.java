package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementInBST {
	public static int kthSmallest(TreeNode root, int k) {
		List<Integer> arr = new ArrayList<Integer>();
		arr = inorder(root, arr);

		return arr.get(k - 1);
	}

	static List<Integer> inorder(TreeNode root, List<Integer> arr) {
		if (root == null) {
			return arr;
		}
		inorder(root.left, arr);
		arr.add(root.val);
		inorder(root.right, arr);

		return arr;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.insert(3);
		bt.insert(6);
		bt.insert(2);
		bt.insert(4);
		bt.insert(7);
		System.out.println(kthSmallestUsingStack(bt.root, 5));

	}
	
	public static int kthSmallestUsingStack(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		
		while(true) {
			while(root != null) {
				stack.add(root);
				root = root.left;
			}
			
			root = stack.removeLast();
			if(--k == 0)
				return root.val;
			root = root.right;
		}
	}

}