package com.sc.cd.datastruct.binarytree;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import com.google.common.collect.Lists;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = createTree(null);

        // 前序遍历
        System.out.println("===========前序遍历==============");
        preOrderTraverse(rootNode);

        // 中序遍历
        System.out.println("===========中序遍历==============");
        inOrderTraverse(rootNode);

        // 后序遍历
        System.out.println("===========后序遍历==============");
        afterOrderTraverse(rootNode);

        // 层序遍历
        System.out.println("===========层序遍历==============");
        layerOrderTraverse(rootNode);
    }

    /**
     * 按序号生成二叉树
     * 二叉树生成规则 ABDH##I##E##CF###
     * @param node
     * @return
     */
    private static BinaryTreeNode createTree(BinaryTreeNode node) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter tree data:");
        String data = sc.nextLine();
        System.out.println(data);
        if (Objects.equals("#", data)) {
            return null;
        }
        node = new BinaryTreeNode();
        node.setData(data);

        node.setLeftChildNode(createTree(node.getLeftChildNode()));
        node.setRightChildNode(createTree(node.getRightChildNode()));
        return node;
    }

    /**
     * 前序遍历
     * @param node
     */
    private static void preOrderTraverse(BinaryTreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        System.out.println(node.getData());
        preOrderTraverse(node.getLeftChildNode());
        preOrderTraverse(node.getRightChildNode());
    }

    /**
     * 中序遍历
     * @param node
     */
    private static void inOrderTraverse(BinaryTreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        inOrderTraverse(node.getLeftChildNode());
        System.out.println(node.getData());
        inOrderTraverse(node.getRightChildNode());
    }

    /**
     * 后序遍历
     * @param node
     */
    private static void afterOrderTraverse(BinaryTreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        afterOrderTraverse(node.getLeftChildNode());
        afterOrderTraverse(node.getRightChildNode());
        System.out.println(node.getData());
    }

    /**
     * 层序遍历
     * @param node
     */
    private static void layerOrderTraverse(BinaryTreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        BinaryTreeNode currentNode;
        List<BinaryTreeNode> treeNodes = Lists.newArrayList();
        treeNodes.add(node);
        while (!treeNodes.isEmpty()) {
            currentNode = treeNodes.get(0);
            BinaryTreeNode leftChildNode = currentNode.getLeftChildNode();
            if (Objects.nonNull(leftChildNode)) {
                treeNodes.add(leftChildNode);
            }
            BinaryTreeNode rightChildNode = currentNode.getRightChildNode();
            if (Objects.nonNull(rightChildNode)) {
                treeNodes.add(rightChildNode);
            }
            treeNodes.remove(currentNode);
            System.out.println(currentNode.getData());
        }
    }


}
