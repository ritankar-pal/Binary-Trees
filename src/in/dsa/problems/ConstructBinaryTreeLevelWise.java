package in.dsa.problems;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class ConstructBinaryTreeLevelWise {
	
	public static Node takeInputLevelWise() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Root Node: ");
		
		int data = scan.nextInt();
		if(data == -1) return null;
		
		
		//creating a root node initially::
		Node rootNode = new Node(data);
		
		
		//creating a queue to hold nodes::
		Queue<Node> queue = new LinkedList<>();
		
		
		//Adding the root node in the queue::
		queue.add(rootNode);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			System.out.print("Enter Node To the Left of " + temp.value + ": ");
			data = scan.nextInt();
			
			if(data != -1) {
				Node leftNode = new Node(data);
				temp.left = leftNode;
				queue.add(leftNode);
			}
			
			System.out.print("Enter Node To the Right of " + temp.value + ": ");
			data = scan.nextInt();
			
			if(data != -1) {
				Node rightNode = new Node(data);
				temp.right = rightNode;
				queue.add(rightNode);
			}
			
		}
		
		return rootNode;
	}
	
	
	
	private static class Node {
		
		int value; 
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}		
	}
	
}
