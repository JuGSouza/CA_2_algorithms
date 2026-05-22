package CA_2;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    // as a tree this is the root. the first node of the tree.
    TreeNode root;

     public void insert(Employee employee) {

         // create a new node with the employee information.
        TreeNode newNode = new TreeNode(employee);

        // it is saying if the tree is empty, the root will become the first node.
        if (root == null) {
            root = newNode;
            return;
        }

        // create a queue to check the tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // it says to keep checking while the queue is not empty
        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            // if the left side is empty, put the new node there
            if (current.left == null) {
                current.left = newNode;
                return;
                // if the left side exists, add it to the queue
            } else {
                queue.add(current.left);
            }

            // if the right side is empty, put the new node there
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    public void displayLevelOrder() {

        // if there is no root, it will print it
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // it will keep going until the queue is not empty
        while (!queue.isEmpty()) {

            // get the next node from the queue
            TreeNode current = queue.poll();
            System.out.println(current.employee);

            // print the employee stored in this node
            if (current.left != null) {
                queue.add(current.left);
            }

            // add the right child if it exists
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public int countNodes(TreeNode node) {

        // if the node is null, it counts as zero
        if (node == null) {
            return 0;
        }

        // count this node plus every nodes in the left and right
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int getHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // count the height of the left
        int leftHeight = getHeight(node.left);
        
        // count the height of the right
        int rightHeight = getHeight(node.right);

        // return 1 plus the big height
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
