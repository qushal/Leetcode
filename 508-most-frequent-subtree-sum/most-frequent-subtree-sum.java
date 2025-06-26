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
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        subSum(root);

        List<Integer> ans = new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key) == max) ans.add(key);
        }
        return ans.stream().mapToInt(i -> i).toArray();


    }
    public int subSum(TreeNode root){
        if(root == null) return 0;
        int total = subSum(root.left) + subSum(root.right) + root.val;
        map.put(total, map.getOrDefault(total , 0 ) + 1);
        max = Math.max(map.get(total), max);
        return total;
    }
}