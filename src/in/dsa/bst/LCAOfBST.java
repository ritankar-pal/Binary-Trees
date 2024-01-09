package in.dsa.bst;

public class LCAOfBST {

	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

		//base condition::
		if(root == null) return -1;


		if(root.data == a || root.data == b) return root.data;

		int left = -1;
		int right = -1;

		if(root.data > b){
			left = getLCA(root.left, a, b);
		}
		else if(root.data < a){
			right = getLCA(root.right, a, b);
		}
		else{
			left = getLCA(root.left, a, b);
			right = getLCA(root.right, a, b);
		}


		if(left == -1 || right == -1){
			if(left == -1) return right;
			else return left;
		}

		//else case:
		return root.data;
	}


	class BinaryTreeNode<T> 
	{ 
		T data; BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { this.data = data; } 

	}

}
