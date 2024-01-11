package in.dsa.customeBST;




public class BST {

	private BinaryTreeNode<Integer> root;
	int size;


	public boolean isPresent(int data) {

		if(root == null) return false;

		BinaryTreeNode<Integer> temp = root;

		while(temp != null) {

			if(temp.data == data) return true;

			if(temp.data > data) temp = temp.left;
			else temp = temp.right;

		}

		return false;
	}


	public void insert(int data) {	

		if(root == null){
			BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
			root = node;
			return;
		}

		// if root != null:
		BinaryTreeNode<Integer> temp = root;

		while(temp != null){

			if(temp.data >= data){
				if(temp.left == null){
					BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
					temp.left = node;
					break;
				}
				temp = temp.left;
			}
			else{

				if(temp.right == null){
					BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
					temp.right = node;
					break;
				}
				temp = temp.right;
			}

		}
	}


	public static int minElement(BinaryTreeNode<Integer> node) {
		
		if(node == null) return Integer.MAX_VALUE;
		
		int left = minElement(node.left);
		
		return Math.min(left, node.data);
	}
	
	
	public static BSTDeleteReturn delete(BinaryTreeNode<Integer> node, int data) {
		
		if(node == null) {
			return new BSTDeleteReturn(null, false);
		}
		
		if(node.data > data) {
			BSTDeleteReturn left = delete(node.left, data);
			node.left = left.root;
			left.root = node;	
			return left;
		}
		
		if(node.data < data) {
			BSTDeleteReturn right = delete(node.right, data);
			node.right = right.root;
			right.root = node;	
			return right;			
		}
	
		
		//0 children:
		if(node.left == null && node.right == null) {
			return new BSTDeleteReturn(null, true);
		}
		
		
		//Left Child Only:
		if(node.left != null && node.right == null) {
			return new BSTDeleteReturn(node.left, true);
		}
		
		//Right Child Only:
		if(node.right != null && node.left == null) {
			return new BSTDeleteReturn(node.right, true);
		}
		
		
		//Both LEFT AND RIGHT Children:
		int minElement = minElement(node.right);
		node.data = minElement;
		BSTDeleteReturn right = delete(node.right, minElement);
		node.right = right.root;
		
		return new BSTDeleteReturn(node, true);
	}


	public void remove(int data) {
		if(root == null) return;
		
		BSTDeleteReturn bstDeleteReturn = delete(root, data);
		root = bstDeleteReturn.root;
	}



	
	public int size() {
		return size;
	}


	
	@SuppressWarnings("unused")
	private static void printTreeHelper(BinaryTreeNode<Integer> node) {

		if(node == null) return;

		System.out.print(node.data + ":");

		if(node.left != null) System.out.print("L" + node.left.data + ",");
		if(node.right != null) System.out.print("R" + node.right.data);

		System.out.println();

		printTreeHelper(node.left);
		printTreeHelper(node.right);

	}

	
	
	private static void printTreeRecursive(BinaryTreeNode<Integer> root) {
		
		if(root == null) return;
		
		System.out.print(root.data + ":");
		
		if(root.left != null) System.out.print("L:" + root.left.data);
		if(root.right != null) System.out.print(",R:" + root.right.data);
		
		System.out.println();
		
		printTreeRecursive(root.left);
		printTreeRecursive(root.right);
		
	}
	
	
	
	public void printTree() {
		printTreeRecursive(root);
	}


	
	
	
	private static class BSTDeleteReturn{
		private BinaryTreeNode<Integer> root;
		private boolean delete;
		
		public BSTDeleteReturn(BinaryTreeNode<Integer> root, boolean delete) {
			this.root = root;
			this.delete = delete;
		}
		
	}
	
	private class BinaryTreeNode<T>{

		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		T data;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
}
