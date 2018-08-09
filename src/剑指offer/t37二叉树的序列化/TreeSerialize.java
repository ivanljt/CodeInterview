package 剑指offer.t37二叉树的序列化;


import base.TreeNode;

/**
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class TreeSerialize {
    /**
     * 序列化二叉树。按照前序遍历的顺序进行序列化，每一个节点之间使用「，」分开，空节点使用「#」表示。
     * <p>
     * * 时间复杂度 O()。
     * * 空间复杂度 O()。「递归调用栈」
     */
    String serialize(TreeNode root) {
        if (root == null) {
            return "#,";
        }
        return String.valueOf(root.val) + "," +
                serialize(root.left) +
                serialize(root.right);
    }

    private int index = -1;//当前反序列化的节点

    /**
     * 反序列化。
     *
     * 序列化的时候，使用「，」分隔元素，先使用 String 的 split 函数将字符串拆为数组。
     * 每一轮完成一个节点的反序列化（包括节点的值和左右节点）。
     * * 时间复杂度 O()
     * * 空间复杂度 O()
     */
    TreeNode deserialize(String str) {
        index++;//当前序列化的节点
        if (index >= str.length()) {//边界检查
            return null;
        }
        String[] strAry = str.split(",");
        TreeNode node = null;
        if (!strAry[index].equals("#")) {//不是「#」，说明节点不为 null
            node = new TreeNode(Integer.parseInt(strAry[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);

        treeNode.left = left;
        treeNode.right = right;
        TreeSerialize treeSerialize = new TreeSerialize();
        String serializeStr = treeSerialize.serialize(treeNode);
        System.out.println(serializeStr);

        TreeNode root = treeSerialize.deserialize(serializeStr);
        System.out.println(root);
        assert root.val == 10;
    }
}
