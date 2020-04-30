package com.sc.cd.datastruct.binarytree;

import java.util.Objects;
import java.util.Scanner;

public class ThreadedBinaryTreeDemo {

    private static ThreadedBinaryTreeNode pre = null;

    public static void main(String[] args) {
        ThreadedBinaryTreeNode rootNode = createTree(null);

        // 中序遍历-线索二叉树
        System.out.println("===========中序遍历-线索二叉树==============");
        // inOrderTraverse(rootNode);
        // 前序遍历-线索二叉树
        System.out.println("===========前序遍历-线索二叉树==============");
        preOrderTraverse(rootNode);

        System.out.println(rootNode);
    }

    /**
     * 按序号生成二叉树
     * 二叉树生成规则 ABD###C##
     * @param node
     * @return
     */
    private static ThreadedBinaryTreeNode createTree(ThreadedBinaryTreeNode node) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter tree data:");
        String data = sc.nextLine();
        System.out.println(data);
        if (Objects.equals("#", data)) {
            return null;
        }
        node = new ThreadedBinaryTreeNode();
        node.setData(data);
        node.setLeftChildNode(createTree(node.getLeftChildNode()));
        node.setRightChildNode(createTree(node.getRightChildNode()));
        return node;
    }

    /**
     * 中序遍历-线索二叉树
     * @param node
     */
    private static void inOrderTraverse(ThreadedBinaryTreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        ThreadedBinaryTreeNode leftChildNode = node.getLeftChildNode();
        ThreadedBinaryTreeNode rightChildNode = node.getRightChildNode();

        inOrderTraverse(leftChildNode);

        // 左子结点
        if (Objects.isNull(leftChildNode)) {
            // 前驱标记为1
            node.setLeftChildTag(1);
            // 前驱结点为前一结点
            node.setLeftChildNode(pre);
        }

        // 右子结点
        if (Objects.nonNull(pre) && Objects.isNull(pre.getRightChildNode())) {
            // 后继标记为1
            pre.setRightChildTag(1);
            // 后继结点为双亲结点
            pre.setRightChildNode(node);
        }

        pre = node;

        inOrderTraverse(rightChildNode);
    }


    /**
     * 前序遍历-线索二叉树
     * @param node
     */
    private static void preOrderTraverse(ThreadedBinaryTreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        ThreadedBinaryTreeNode leftChildNode = node.getLeftChildNode();
        ThreadedBinaryTreeNode rightChildNode = node.getRightChildNode();

        // 左子结点
        if (Objects.isNull(leftChildNode)) {
            node.setLeftChildTag(1);
            node.setLeftChildNode(pre);
        }

        // 右子结点
        if (Objects.isNull(rightChildNode)) {
            // 后继标记为1
            pre.setRightChildTag(1);
            // 后继结点为双亲结点
            pre.setRightChildNode(node);
        }

        // pre = A -> pre = B -> pre = D
        pre = node;

        preOrderTraverse(leftChildNode);
        preOrderTraverse(rightChildNode);
    }
}
