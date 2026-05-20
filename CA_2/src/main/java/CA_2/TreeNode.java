package CA_2;

// This class is one node in the binary tree.
// Each node stores one employee.
public class TreeNode {

    Employee employee;
    TreeNode left;
    TreeNode right;

    public TreeNode(Employee employee) {
        this.employee = employee;
        this.left = null;
        this.right = null;
    }
}
