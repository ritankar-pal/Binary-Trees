package in.dsa.custom;

import java.util.ArrayList;
import java.util.List;
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
		System.out.print("Do you want to enter the value left of " + node.data + ": ");
		boolean left = scanner.nextBoolean();

		if(left) {
			System.out.print("Enter the value left of " + node.data + ": ");
			int value = scanner.nextInt();
			node.left = new Node(value);
			populate(scanner, node.left);
		}


		//right insertion::
		System.out.print("Do you want to enter the value right of " + node.data + ": ");
		boolean right = scanner.nextBoolean();
		if(right) {
			System.out.print("Enter the value right of " + node.data + ": ");
			int value = scanner.nextInt();
			node.right = new Node(value);
			populate(scanner, node.right);
		}

	}

	
	public List<Integer> boundaryAnticlockwise(){
		return boundaryAnticlockwise(root);
	}
	
	
	private List<Integer> boundaryAnticlockwise(Node root){

		List<Integer> list = new ArrayList<>();

		if(root == null) return list;

		list.add(root.data);

		leftTraversal(root.left, list);
		rightTraversal(root.right, list);

		return list;
	}

	private void rightTraversal(Node node, List<Integer> list) {

		if(node == null) return;

		rightTraversal(node.left, list);
		rightTraversal(node.right, list);

		list.add(node.data);
	}

	private void leftTraversal(Node node, List<Integer> list) {

		if(node == null) return;

		list.add(node.data);

		leftTraversal(node.left, list);
		leftTraversal(node.right, list);

	}






	public void display() {
		display(root, "");
	}


	private void display(Node node, String indent) {

		if(node == null) return;

		System.out.println(indent + node.data);
		display(node.left, "\t");
		display(node.right, "\t");
	}


	private class Node {

		int data; 
		Node left;
		Node right; 

		public Node(int elem) {
			this.data = elem;
		}
	}

}
