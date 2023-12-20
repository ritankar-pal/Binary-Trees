package in.dsa.custom;

import java.util.Scanner;

public class MainApp {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.populate(scanner);
		
		binaryTree.display();
	}
}		
