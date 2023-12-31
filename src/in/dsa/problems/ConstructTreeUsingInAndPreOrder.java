package in.dsa.problems;

public class ConstructTreeUsingInAndPreOrder {
	
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Your code goes here
		return buildTree(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
	}

	public static BinaryTreeNode<Integer> buildTree(int[] preorder, int[] inorder,int siPre, int eiPre, int siIn, int eiIn)
    {
        //Base case - If number of elements in the pre-order is 0
    	if (siIn>eiIn || siPre > eiPre)
    	{
    		return null;
    	}
    	
    	//Defining the root node for current recursion
    	int rootData=preorder[siPre];
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
    	
    	//Finding root data's location in Inorder (Assuming root data exists in Inorder)
    	int rootIndexInorder=-1;
    	for (int i=siIn;i<=eiIn;i++)
    	{
    		if (rootData==inorder[i])
    		{
    			rootIndexInorder=i;
    			break;
    		}
    	}
    	    	

		//Setting indexes for InOrder[]
		//left tree:
		int siInLeft = siIn; 
		int eiInLeft = rootIndexInorder-1;

		//right tree:
		int siInRight = rootIndexInorder + 1;
		int eiInRight = eiIn;

		
		//Setting indexes for PreOrder[]:
		//left tree:
		int siPreLeft = siPre + 1;
		int lengthofLeftSubtree = eiInLeft - siInLeft + 1; 
		int eiPreLeft = siPreLeft + (lengthofLeftSubtree - 1);

		//right:
		int siPreRight = eiPreLeft + 1;
		int eiPreRight = eiPre;

		root.left = buildTree(preorder, inorder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
	 	root.right = buildTree(preorder, inorder, siPreRight, eiPreRight, siInRight, eiInRight);
	
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
