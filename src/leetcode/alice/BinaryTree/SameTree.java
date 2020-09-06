package leetcode.alice.BinaryTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null && q != null || q == null && p != null)
			return false;

		while (p != null && q != null && p.val == q.val) {
			if (p.left != null && q.left != null) {
				p = p.left;
				q = q.left;

			} else if (p.left == null && q.left == null) {
				if (p.right != null && q.right != null) {
					p = p.right;
					q = q.right;

				} else {
					return true;
				}
			} else {
				return false;

			}

		}
		return false;
	}

	public boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if ((p == null && q != null) || (q == null && p != null)) {
			return false;
		} else if (p.val != q.val) {
			return false;
		} else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
}