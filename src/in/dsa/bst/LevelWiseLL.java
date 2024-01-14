package in.dsa.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class LevelWiseLL {
	
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		// Write your code here

		ArrayList<LinkedListNode<Integer>> list = new ArrayList<>();

		if(root == null) return list;

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

		//Adding the root in the queue:
		queue.add(root);
	
		while(!queue.isEmpty()){

			int size = queue.size();

			LinkedListNode<Integer> dummyHead = new LinkedListNode<Integer>(-1);
			LinkedListNode<Integer> curr = dummyHead;

			for(int i = 0; i < size; i++){
				
				BinaryTreeNode<Integer> node = queue.poll();

				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);

				LinkedListNode<Integer> newNode = new LinkedListNode<>(node.data);

				curr.next = newNode;
				curr = curr.next;

			}

			list.add(dummyHead.next);

		}	

		return list;

	}
	
	
	
	  static class LinkedListNode<T> 
	  { 
	  		T data; 
	  		LinkedListNode<T> next;
	  		public LinkedListNode(T data) 	
	  		{
	   		this.data = data; 
	   	} 
	   }
	  
	  class BinaryTreeNode<T> 
		{ 
			T data; BinaryTreeNode<T> left; 
			BinaryTreeNode<T> right;

			public BinaryTreeNode(T data) { this.data = data; } 

		}
	
}
