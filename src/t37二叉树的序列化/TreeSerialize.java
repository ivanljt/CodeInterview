package t37二叉树的序列化;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TreeSerialize {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    int index = -1;//当前反序列化的节点

    //反序列化
    //每一轮中，确定好一个节点
    TreeNode Deserialize(String str) {
        index++;//当前序列化的节点
        if (index >= str.length()) {//边界检查
            return null;
        }
        String[] strAry = str.split(",");
        TreeNode node = null;
        if (!strAry[index].equals("#")) {
            node = new TreeNode(Integer.parseInt(strAry[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
