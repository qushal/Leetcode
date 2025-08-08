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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val){
           root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else{
            // reached at the equal node
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            TreeNode lastrightNode = findRightLast(root.left);
            lastrightNode.right = root.right;
            return root.left;
        }
        return root;
    }
    public TreeNode findRightLast(TreeNode root){
        if(root.right == null) return root;
        return findRightLast(root.right);
    }
}