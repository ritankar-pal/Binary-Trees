package in.dsa.problems;

public class CreateAndInsertDuplicateNode {
	
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		//Your code goes here

		if(root  == null) return;

		//create a duplicate node i.e. same as root:
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(root.data);

		node.left = root.left;

		insertDuplicateNode(root.left);
		insertDuplicateNode(root.right);

		root.left = node;

	}
	
	public static class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
