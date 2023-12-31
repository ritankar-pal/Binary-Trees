package in.dsa.problems;

public class ConstructTreeUsingInAndPostOrder {
	
	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		//Your code goes here
		return helper(postOrder, inOrder, 0, postOrder.length-1, 0, inOrder.length-1);
	}

	public static BinaryTreeNode<Integer> helper(int[] postOrder, int[] inOrder, int siPost, int eiPost, 
	int siIn, int eiIn){

		//base condition:
		if(siPost > eiPost || siIn > eiIn) return null;

		//root of tree:
		int rootData = postOrder[eiPost];

		//creating root node:
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		//search rootData in inOrder[]:
		int rootDataInorderIndex = -1;

		for(int i = siIn; i <= eiIn; i++){
			if(inOrder[i] == rootData){
				rootDataInorderIndex = i;
				break;
			}
		}

		//Creating Indexes of inOrder[]:
		//left Tree: 
		int siInLeft = siIn;	
		int eiInLeft = rootDataInorderIndex - 1;

		//right Tree:
		int siInRight = rootDataInorderIndex + 1;
		int eiInRight = eiIn;


		//Creating Indexes of postOrder[]:
		//left Tree:
		int siPostLeft = siPost;
		int leftSubTreeLength = eiInLeft - siInLeft + 1;
		int eiPostLeft = siPostLeft + (leftSubTreeLength - 1);


		//right tree:
		int siPostRight = eiPostLeft + 1;
		int eiPostRight = eiPost - 1;


		root.right =  helper(postOrder, inOrder, siPostRight, eiPostRight, siInRight, eiInRight);
		root.left = helper(postOrder, inOrder, siPostLeft, eiPostLeft, siInLeft, eiInLeft);

		return root;

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
