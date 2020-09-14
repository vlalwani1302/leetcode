package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	public TreeNode root;

	public void insert(int value) {
		root = insert(value, root);

	}

	private TreeNode insert(int value, TreeNode root) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		} else if (value < root.val) {
			root.left = insert(value, root.left);
		} else {
			root.right = insert(value, root.right);
		}
		return root;
	}

	public boolean contains(int value) {
		return contains(root, value);

	}

	private boolean contains(TreeNode root, int value) {
		if (root.val == value) {
			return true;
		}
		if (value < root.val) {
			return contains(root.left, value);
		} else {
			return contains(root.right, value);
		}
	}

	public void printInOrder() {
		List<Integer> list = new ArrayList<Integer>();
		list = printInOrder(root, list);
		for(Integer l : list) {
			System.out.print(l + " , ");
		}
		System.out.println();

	}

	private List<Integer> printInOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return list;
		}
		printInOrder(root.left, list);
		list.add(root.val);
		printInOrder(root.right, list);
		return list;
	}

	public void printPreOrder() {
		List<Integer> list = new ArrayList<Integer>();
		list = printPreOrder(root, list);
		for(Integer l : list) {
			System.out.print(l + " , ");
		}
		System.out.println();

	}

	private List<Integer> printPreOrder(TreeNode root, List<Integer> list) {
		if(root == null) {
			return list;
		}
		list.add(root.val);
		printPreOrder(root.left, list);
		printPreOrder(root.right, list);
		
		return list;
	}

	public void printPostOrder() {
		List<Integer> list = new ArrayList<Integer>();
		list = printPostOrder(root, list);
		for(Integer l : list) {
			System.out.print(l + " , ");
		}
		System.out.println();

	}
	
	private List<Integer> printPostOrder(TreeNode root, List<Integer> list) {
		if(root == null) {
			return list;
		}
		printPreOrder(root.left, list);
		printPreOrder(root.right, list);
		list.add(root.val);
		
		return list;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.insert(2);
		bt.insert(4);
		bt.insert(7);
		bt.insert(8);
		
		System.out.println(bt.contains(4));
		bt.printInOrder();
		bt.printPostOrder();
		bt.printPreOrder();
	}
}
