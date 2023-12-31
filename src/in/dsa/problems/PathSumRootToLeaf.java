package in.dsa.problems;

import java.util.ArrayList;
import java.util.List;

public class PathSumRootToLeaf {


	//	private static void helper(BinaryTreeNode<Integer> root, List<List<Integer>> resultList, List<Integer> list, int k) {
	//		
	//		if(root == null) return;
	//
	//		if(root.left == null && root.right == null){
	//
	//			list.add(root.data);
	//
	//			int sum = 0;
	//			
	//			for(int i = 0; i < list.size(); i++) {
	//				sum = sum + list.get(i);
	//			}
	//			
	//			if(sum == k){
	//				resultList.add(new ArrayList<>(list));
	//			}
	//			return;
	//		}
	//
	//		list.add(root.data);
	//		helper(root.left, resultList, list, k);
	//
	//		list.remove(list.size()-1);
	//		helper(root.right, resultList, list, k);
	//	}


	private static void helper(BinaryTreeNode<Integer> root, List<Integer> list, int k) {

		if(root == null) return;

		if(root.left == null && root.right == null){

			list.add(root.data); //8
			k = k - root.data;  //0
			
			//print the data from the list:
			if(k == 0){
				for(int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i) + " ");
				}
				System.out.println();
			}

			return;
		}

		list.add(root.data); //2
		k = k-root.data;  //11

		helper(root.left, list, k);
		if(root.left != null)list.remove(list.size()-1);

		helper(root.right, list, k);
		if(root.right != null) list.remove(list.size()-1);

	}


	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		//Your code goes here

		List<Integer> list = new ArrayList<>();

		helper(root,list, k);

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
