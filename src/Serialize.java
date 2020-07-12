/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Serialize {
    int index = 0;//记录遍历到的string的下标

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        dfs1(root, str);
        return str.toString();
    }

    public void dfs1(TreeNode root, StringBuilder str) {
        if (root == null) { //先序遍历，先处理根节点
            str.append("#,");
            return;
        }
        str.append(root.val).append(",");
        dfs1(root.left, str);//再递归遍历左子树
        dfs1(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replaceAll("null", "#");
        return dfs2(data);
    }

    public TreeNode dfs2(String data) {
        if (data.charAt(index) == '#') {
            index += 2;//跳过‘#’，和‘，’
            return null;
        }
        boolean is_minus = false;
        if (data.charAt(index) == '-') {
            is_minus = true;
            index++;//跳过减号
        }
        int t = 0;
        while (data.charAt(index) != ',') {
            t = t * 10 + data.charAt(index) - '0';
            index++;//算好一个数的每位数
        }
        index++;//跳过逗号
        if (is_minus) t = -t;
        TreeNode root = new TreeNode(t);
        root.left = dfs2(data);
        root.right = dfs2(data);
        return root;
    }
}
