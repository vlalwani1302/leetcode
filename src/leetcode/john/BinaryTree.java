package leetcode.john;

public class BinaryTree {
	 // Root of BST 
	TreeNode root; 
	

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

    public void insert(int val) { 
       root = insertRec(root, val); 
    } 
    
    public TreeNode insertRec(TreeNode root, int val) { 
        if (root == null) { 
            root = new TreeNode(val); 
            return root; 
        } 
        if (val < root.getVal()) 
            root.left = insertRec(root.left, val); 
        else if (val > root.getVal()) 
            root.right = insertRec(root.right, val); 
  
        return root; 
    } 
  
    void inorder()  { 
       inorderRec(root); 
    } 
  
    void inorderRec(TreeNode root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.println(root.getVal()); 
            inorderRec(root.right); 
        } 
    } 
}
