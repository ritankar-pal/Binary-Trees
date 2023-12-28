package in.dsa.problems;



public class MaximumPathSum {
	
	//the size of maxValue = 1 with initial value of maxValue[0] = 0;
	public int maxSum(Node root, int[] maxValue) {
		
		if(root == null) return 0;
		
		
		int leftSum = maxSum(root.left, maxValue);
		leftSum = Math.max(0, leftSum);  //we will not consider -ve numbers
		
		int rightSum = Math.max(0, maxSum(root.right, maxValue));
		
		
		maxValue[0] = Math.max(maxValue[0], leftSum + rightSum + root.data);
		
		return root.data + Math.max(leftSum, rightSum);
	}
	
	//Whereever we are calling the maxSum we will return maxValue[0];
	
	private static class Node{
		Node left;
		Node right;
		int data; 
		
		public Node(int data) {
			this.data = data;
		}
	}
	
}
