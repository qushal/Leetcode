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
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int canRob = root.val;
        if(root.left != null){
            canRob += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            canRob += rob(root.right.left) + rob(root.right.right);
        }
        int cannotRob = rob(root.left) + rob(root.right);

        map.put(root, Math.max(canRob, cannotRob));
        return map.get(root);
    }
    
}