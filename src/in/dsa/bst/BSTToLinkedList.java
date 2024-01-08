package in.dsa.bst;

public class BSTToLinkedList {


	private static LinkedListNode<Integer> addNode(BinaryTreeNode<Integer> root, LinkedListNode<Integer> currNode) {
		
		LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);
		currNode.next = newNode;
		return newNode;
	}
	
	private static LinkedListNode<Integer> helper(BinaryTreeNode<Integer> root, LinkedListNode<Integer> currNode) {
		
		if(currNode == null) return currNode;
		
		if(root.left != null) {
			currNode = helper(root.left, currNode);
		}
		
		currNode = addNode(root, currNode);
		
		if(root.right != null) {
			currNode = helper(root.right, currNode);
		}
		
		return currNode;
	}


	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		
		LinkedListNode<Integer> dummyNode = new LinkedListNode<>(-1);
		
		helper(root, dummyNode);
		
		return dummyNode.next;
	}
	


	private static class BinaryTreeNode<T> { 
		T data; 
		BinaryTreeNode<T> left; 
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) { 
			this.data = data; 
		} 
	}


	private static class LinkedListNode<T> { 
		T data; 
		LinkedListNode<T> next;

		public LinkedListNode(T data) { 
			this.data = data; 
		} 
	}

}
