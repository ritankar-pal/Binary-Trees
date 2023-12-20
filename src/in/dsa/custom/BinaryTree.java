package in.dsa.custom;

import java.util.Scanner;

public class BinaryTree {
	
	private Node root;
	
	public BinaryTree() {
		
	}
	
	//insert elements
	public void populate(Scanner scanner) {
		
		System.out.print("Enter the root Node:: " );
		int value = scanner.nextInt();
		
		root = new Node(value);
		
		populate(scanner, root);
	}
	
	private void populate(Scanner scanner, Node node) {
		
		//left insertion::
		System.out.print("Do you want to enter the value left of " + node.value + ": ");
		boolean left = scanner.nextBoolean();
		
		if(left) {
			System.out.print("Enter the value left of " + node.value + ": ");
			int value = scanner.nextInt();
			node.left = new Node(value);
			populate(scanner, node.left);
		}
		
		
		//right insertion::
		System.out.print("Do you want to enter the value right of " + node.value + ": ");
		boolean right = scanner.nextBoolean();
		if(right) {
			System.out.print("Enter the value right of " + node.value + ": ");
			int value = scanner.nextInt();
			node.right = new Node(value);
			populate(scanner, node.right);
		}
		
	}
	
	
	public void display() {
		display(root, "");
	}


	private void display(Node node, String indent) {
		
		if(node == null) return;
		
		System.out.println(indent + node.value);
		display(node.left, "\t");
		display(node.right, "\t");
	}


	private static class Node {
		
		int value; 
		Node left;
		Node right; 
		
		public Node(int elem) {
			this.value = elem;
		}
	}

}
