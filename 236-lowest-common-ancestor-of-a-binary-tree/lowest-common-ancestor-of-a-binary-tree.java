/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> pp = new ArrayList<>();
    List<TreeNode> qq = new ArrayList<>();
    List<TreeNode> temp = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        int i=0;
        TreeNode ans = new TreeNode(0);
        while(i<pp.size() && i<qq.size() && pp.get(i) == qq.get(i)){
            ans = pp.get(i++);
        }
        return ans;
    }
    void dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return;
        temp.add(root);
        if(root == p) pp = new ArrayList<>(temp);
        if(root == q) qq = new ArrayList<>(temp);
        dfs(root.left, p, q);
        dfs(root.right, p, q);
        temp.remove(temp.size() - 1);
    }
}