package in.dsa.custom;

import java.util.List;
import java.util.Scanner;

public class MainApp {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.populate(scanner);
		
		
		List<Integer> list = binaryTree.boundaryAnticlockwise();
		list.forEach(row ->{
			System.out.print(row + " ");
		});
		
//		binaryTree.display();
	}
}		
