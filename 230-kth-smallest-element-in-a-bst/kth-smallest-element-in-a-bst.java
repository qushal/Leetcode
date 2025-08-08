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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        traverse(root, q);
        while(k-- > 1) q.poll();
        return q.poll();
    }
    public void traverse(TreeNode root, PriorityQueue<Integer> q){
        if(root == null) return;
        q.offer(root.val);
        traverse(root.left, q);
        traverse(root.right, q);
    }
}