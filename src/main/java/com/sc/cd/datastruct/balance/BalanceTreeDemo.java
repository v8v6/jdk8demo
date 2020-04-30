package com.sc.cd.datastruct.balance;

public class BalanceTreeDemo {

    /**
     * 右高
     */
    public static final int RH = -1;

    /**
     * 等高
     */
    public static final int EH = 0;

    /**
     * 左高
     */
    public static final int LH = 1;


    public static void main(String[] args) {

    }

    /**
     * 右旋操作
     * @param treeNode 最小不平衡树
     */
    private void R_Rotate(BinaryTreeNode treeNode) {
        // P结点 treeNode
        // L结点
        BinaryTreeNode leftChildNode = treeNode.getLeftChildNode();
        // L的右结点为P的左结点
        treeNode.setLeftChildNode(leftChildNode.getRightChildNode());
        // L的右结点为P结点
        leftChildNode.setRightChildNode(treeNode);
    }

    /**
     * 左旋操作
     * @param treeNode 最小不平衡树
     */
    private void L_Rotate(BinaryTreeNode treeNode) {
        // P结点 treeNode
        // L结点
        BinaryTreeNode rightChildNode = treeNode.getRightChildNode();
        // L的左结点为P的右结点
        treeNode.setRightChildNode(rightChildNode.getLeftChildNode());
        // L的左结点为P结点
        rightChildNode.setLeftChildNode(treeNode);
    }

    /**
     *
     * @param treeNode 最小不平衡子树
     */
    private void leftBalance(BinaryTreeNode treeNode) {
        BinaryTreeNode L,Lr;
        L = treeNode.getLeftChildNode();
        switch (L.getBf()) {
            // 新结点插在左孩子的左子树上，需要做右旋处理
            case LH:
                // 修改树的平衡因子 bf
                treeNode.setBf(EH);
                L.setBf(EH);
                // 右旋
                R_Rotate(treeNode);
                break;
            // 新结点
            case RH:

        }
    }

}
