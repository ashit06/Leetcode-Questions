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
    int helper(TreeNode root,long targetSum){//this function calculates the total number of paths for each node for which the targetSum is achived
        if(root==null) return 0;
        int count=0;
        if(root.val==targetSum)//if the a valid path exists then we are incrementing the value of count to 1 so that whent it goes back its value is changed and incremented to the value equal to the targetSum
        count=1;
        count+=helper(root.left,targetSum-root.val);
        count+=helper(root.right,targetSum-root.val);
        return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
        return 0;
        return helper(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);//finding the total number of paths in the tree which is equal to the no of paths of root + right subtree and left subbtree
    }
}