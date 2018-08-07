package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

 * 
*/
class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flattenRecursive(root);
    }
    //递归
    TreeNode flattenRecursive(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = flattenRecursive(root.left);
        TreeNode right = flattenRecursive(root.right);
        root.left = null;
        root.right = null;
        TreeNode lastLeft = left;

        if(left == null) {//左子树为空
            root.right = right;
            return root;
        }
        
        root.right = left;//
        while(lastLeft.right!=null){//找出「最右」的那个节点
            lastLeft = lastLeft.right;
        }
        lastLeft.right = right;

        return root;
    }    
}