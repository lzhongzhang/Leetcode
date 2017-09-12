// Problem 536 Construct Binary Tree From String

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
    public TreeNode str2tree(String s) {
        if(s.length() == 0 || s == null)
            return null;
        int first = s.indexOf("(");
        // if "(" is not found, return -1.
        int val = first == -1 ? Integer.parseInt(s): Integer.parseInt(s.substring(0, first));
        TreeNode node = new TreeNode(val);
        if(first == -1)
            return node;
        int start = first, count = 0;
        for(int i = start; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')')
                count--;
            if(count == 0 && start == first) {
                node.left = str2tree(s.substring(start + 1, i));
                start = i + 1;
            }
            else if(count == 0)
                node.right = str2tree(s.substring(start + 1, i));
            
        }
        return node;
    }
}