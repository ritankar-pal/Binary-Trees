package in.dsa.problems;

public class PrintNodesAtDistanceKFromNode {	
	
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int K) {
		findNodesAtKDistance(root, node, K);
	}

	private static int findNodesAtKDistance(BinaryTreeNode<Integer> node, int target, int K) {
        if (node == null) return -1; // Base case

        if (node.data == target) {
            findNodesDownwards(node, K);
            return 0;
        }

        int leftDistance = findNodesAtKDistance(node.left, target, K);
        int rightDistance = findNodesAtKDistance(node.right, target, K);

        if (leftDistance >= 0) {
            if (leftDistance + 1 == K) {
                System.out.println(node.data);
            }
            findNodesDownwards(node.right, K - leftDistance - 2);
            return leftDistance + 1;
        }

        if (rightDistance >= 0) {
            if (rightDistance + 1 == K) {
                System.out.println(node.data);
            }
            findNodesDownwards(node.left, K - rightDistance - 2);
            return rightDistance + 1;
        }

        return -1;
    }

    private static void findNodesDownwards(BinaryTreeNode<Integer> node, int K) {
        if (node == null || K < 0) return;

        if (K == 0) {
            System.out.println(node.data);
            return;
        }

        findNodesDownwards(node.left, K - 1);
        findNodesDownwards(node.right, K - 1);
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
