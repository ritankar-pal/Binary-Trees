package in.dsa.customeBST;

public class TestApp {

	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.insert(15);
		bst.insert(10);
		bst.insert(20);
		bst.insert(6);
		bst.insert(13);
		bst.insert(5);
		bst.insert(12);
		bst.insert(14);
		bst.insert(11);
		
		bst.printTree();
		
		System.out.println();
		
//		System.out.println(bst.isPresent(21));
		
//		
		bst.remove(13);
		bst.printTree();
		
		
		
	}

}
