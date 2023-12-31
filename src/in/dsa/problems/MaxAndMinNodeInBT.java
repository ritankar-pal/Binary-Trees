package in.dsa.problems;

public class MaxAndMinNodeInBT {
	
	
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		//Your code goes here

		//base case:
		if(root == null){
			return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Pair<Integer, Integer> leftPair = getMinAndMax(root.left);
		Pair<Integer, Integer> rightPair = getMinAndMax(root.right);

		int minValue = Math.min(root.data, Math.min(leftPair.minimum, rightPair.minimum));
		int maxValue = Math.max(root.data, Math.max(leftPair.maximum, rightPair.maximum));

		return new Pair<>(minValue, maxValue);

	}
	
	
	private static class Pair<T, U> {
		T minimum;
		U maximum;

		public Pair(T minimum, U maximum) {
			this.minimum = minimum;
			this.maximum = maximum;
		}

	}
	
	private static class BinaryTreeNode<T> {
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
