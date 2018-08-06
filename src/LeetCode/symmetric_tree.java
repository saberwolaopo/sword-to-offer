package LeetCode;
/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:
    1
   / \
  2   2
   \   \
   3    3
 */
public class symmetric_tree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private boolean check(TreeNode a, TreeNode b) {
        if(a==null & b==null){
            return true;
        }
        if((a== null && b !=null) || (a!=null && b==null)){
            return false;
        }
        return a.val == b.val && check(a.left,b.right) && check(a.right,b.left);
    }
}
