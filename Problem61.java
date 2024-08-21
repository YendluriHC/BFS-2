// Time Complexity: O(n)
// Space Complexity: O(h)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // To store depth and parent information for x and y
        int[] xInfo = new int[2]; // xInfo[0] = depth of x, xInfo[1] = parent of x
        int[] yInfo = new int[2]; // yInfo[0] = depth of y, yInfo[1] = parent of y
        
        // Start DFS traversal
        dfs(root, x, y, 0, null, xInfo, yInfo);
        
        // Compare depth and parent information
        return xInfo[0] == yInfo[0] && xInfo[1] != yInfo[1];
    }
    
    private void dfs(TreeNode node, int x, int y, int depth, TreeNode parent, int[] xInfo, int[] yInfo) {
        if (node == null) return;
        
        // Check if the current node is x or y and store depth and parent information
        if (node.val == x) {
            xInfo[0] = depth;
            xInfo[1] = (parent != null) ? parent.val : -1;
        } else if (node.val == y) {
            yInfo[0] = depth;
            yInfo[1] = (parent != null) ? parent.val : -1;
        }
        
        // Traverse left and right children
        dfs(node.left, x, y, depth + 1, node, xInfo, yInfo);
        dfs(node.right, x, y, depth + 1, node, xInfo, yInfo);
    }
}
