package leetcode.alice.BinaryTree;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public Integer val;
	public Integer val1;

	public TreeNode() {
	}

	public TreeNode(Integer val) {
		this.val = val;
	}

	public TreeNode(Integer val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}