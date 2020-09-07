package leetcode.alice.BinaryTree;

import leetcode.john.TreeNode;

public class ConstructBTInorderPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 && postorder.length == 0) {
			return null;
		}

		return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);

	}

	public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart >= inEnd || postStart >= postEnd) {
			return null;
		}
		TreeNode root = new TreeNode();
		root.val = postorder[postEnd - 1];

		int position = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				position = i;
			}
		}
		int diff = position - inStart;
		root.left = buildTree(inorder, inStart, inStart + diff, postorder, postStart, postStart + diff);
		root.right = buildTree(inorder, inStart + diff + 1, inEnd, postorder, postStart + diff, postEnd - 1);

		return root;
	}
}