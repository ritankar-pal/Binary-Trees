package in.dsa.bst;

public class SortedArrayToBST {


	private static class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}



	public static BinaryTreeNode<Integer> constructBST(int[] arr, int n, int startIndex, int endIndex){

		if(startIndex > endIndex) return null;

		int midIndex = (startIndex + endIndex) / 2;

		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(arr[midIndex]);

		BinaryTreeNode<Integer> left = constructBST(arr, n, startIndex, midIndex-1);
		BinaryTreeNode<Integer> right = constructBST(arr, n, midIndex+1, endIndex);

		node.left = left;
		node.right = right;

		return node;
	}

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		return constructBST(arr, n, 0, n-1);
	}
}
