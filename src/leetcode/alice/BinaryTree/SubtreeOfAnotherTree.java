package leetcode.alice.BinaryTree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class SubtreeOfAnotherTree {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.insert(3);
		bt.insert(6);
		bt.insert(1);
		bt.insert(4);

		BinaryTree t = new BinaryTree();
		t.insert(3);
		t.insert(1);
		t.insert(4);

		System.out.println(isSubtree(bt.root, t.root));
	}

	public static boolean isSubtree(TreeNode s, TreeNode t) {
		return traverse(s, t);
	}

	public static boolean equals(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if (s == null && t != null || s != null && t == null)
			return false;
		if (s.val == t.val) {
			return equals(s.left, t.left) && equals(s.right, t.right);
		}
		return false;
	}

	public static boolean traverse(TreeNode s, TreeNode t) {
		return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
	}
}