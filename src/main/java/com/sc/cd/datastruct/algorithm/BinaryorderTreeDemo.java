package com.sc.cd.datastruct.algorithm;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class BinaryorderTreeDemo {

    public static void main(String[] args) {
        /*BinaryTreeNode binaryTreeNode = createTree(null);
        System.out.println(binaryTreeNode);
        boolean b = inOrderTraverseSearch(binaryTreeNode, 51);
        System.out.println(b);*/

        // 1、数组
        BinaryTreeNode binaryTreeNode = createOrderTree(new int[]{62, 58, 88, 47, 73, 99, 35, 51, 93, 37});
        System.out.println(binaryTreeNode);
        boolean bb = inOrderTraverseSearch(binaryTreeNode, 51);
        System.out.println(bb);

        // 2、并发
        binaryTreeNode = createOrderTree1(new int[]{62, 58, 88, 47, 73, 99, 35, 51, 93, 37});
        System.out.println(binaryTreeNode);
        boolean cc = inOrderTraverseSearch(binaryTreeNode, 51);
        System.out.println(cc);

        binaryTreeNode = createOrderTree1(new int[]{62,58,88,47,73,99,35,51,93,29,37,49,56,36,48,50});
        System.out.println(binaryTreeNode);
        boolean dd = inOrderTraverseSearch(binaryTreeNode, 51);
        System.out.println(dd);

        //deleteTreeNode(binaryTreeNode, 47);
        //System.out.println(binaryTreeNode);

        binaryTreeNode = createOrderTree1(new int[]{62,58,88,47,73,99,51,93,49,56,48,50});
        System.out.println(binaryTreeNode);
        dd = inOrderTraverseSearch(binaryTreeNode, 51);
        System.out.println(dd);
        deleteTreeNode(binaryTreeNode, 47);

        //
        System.out.println(binaryTreeNode);

        binaryTreeNode = createOrderTree1(new int[]{62,58,88,47,73,99,35,51,93,29,49,56,48,50});
        System.out.println(binaryTreeNode);
        dd = inOrderTraverseSearch(binaryTreeNode, 51);

        System.out.println(dd);
        deleteTreeNode(binaryTreeNode, 47);
        System.out.println(binaryTreeNode);

        // 插入node
        binaryTreeNode = createOrderTree1(new int[]{62,58,88,47,73,99,51,93,29,49,56,48,50});
        System.out.println(binaryTreeNode);
        insertTreeNode(binaryTreeNode, 35);
        System.out.println(binaryTreeNode);

        binaryTreeNode = createOrderTree1(new int[]{3,2,1,4,5,6,7,10,9,8});
        System.out.println(binaryTreeNode);

    }


    /**
     * 前序普通创建-二叉排序树
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
        node.setData(Integer.valueOf(data));

        node.setLeftChildNode(createTree(node.getLeftChildNode()));
        node.setRightChildNode(createTree(node.getRightChildNode()));
        return node;
    }

    /**
     * 创建-二叉排序树
     * @return
     */
    private static BinaryTreeNode createOrderTree(int[] arr) {

        BinaryTreeNode root = new BinaryTreeNode();
        root.setData(arr[0]);
        BinaryTreeNode parentNode[] = new BinaryTreeNode[]{root};
        for (int i = 1; i<arr.length; i++) {
            if (!inOrderTraverseSearch(root, arr[i], parentNode)) {
                if (Objects.nonNull(parentNode)){
                    BinaryTreeNode node = new BinaryTreeNode();
                    node.setData(arr[i]);
                    int parentNodeData = parentNode[0].getData();
                    if (parentNodeData > arr[i]) {
                        parentNode[0].setLeftChildNode(node);
                    } else {
                        parentNode[0].setRightChildNode(node);
                    }
                }
            }
        }
        return root;
    }


    private static BinaryTreeNode createOrderTree1(int[] arr) {

        BinaryTreeNode root = new BinaryTreeNode();
        root.setData(arr[0]);
        AtomicReference<BinaryTreeNode> atomicReference = new AtomicReference();
        for (int i = 1; i<arr.length; i++) {
            if (!inOrderTraverseSearch(root, arr[i], atomicReference)) {
                if (Objects.nonNull(atomicReference.get())){
                    BinaryTreeNode node = new BinaryTreeNode();
                    node.setData(arr[i]);
                    node.setParentNode(atomicReference.get());
                    int parentNodeData = atomicReference.get().getData();
                    if (parentNodeData > arr[i]) {
                        atomicReference.get().setLeftChildNode(node);
                    } else {
                        atomicReference.get().setRightChildNode(node);
                    }
                }
            }
        }
        return root;
    }

    private static boolean insertTreeNode(BinaryTreeNode root, int key) {
        BinaryTreeNode[] arr = new BinaryTreeNode[1];
        if (!inOrderTraverseSearch(root, key, arr)) {
            if (arr.length != 0){
                BinaryTreeNode node = new BinaryTreeNode();
                node.setData(key);
                node.setParentNode(arr[0]);
                int parentNodeData = arr[0].getData();
                if (parentNodeData > key) {
                    arr[0].setLeftChildNode(node);
                } else {
                    arr[0].setRightChildNode(node);
                }
            }
        }
        return true;
    }

    /**
     * 搜索是否存在数据
     * @param node
     * @param searchValue
     * @return
     */
    private static boolean inOrderTraverseSearch(BinaryTreeNode node, int searchValue) {
        if (Objects.isNull(node)) {
            return false;
        }

        if (node.getData() > searchValue) {
            return inOrderTraverseSearch(node.getLeftChildNode(), searchValue);
        } else if (node.getData() < searchValue) {
            return inOrderTraverseSearch(node.getRightChildNode(), searchValue);
        } else {
            return true;
        }
    }

    /**
     * 搜索是否存在数据
     * @param node
     * @param searchValue
     * @return
     */
    private static boolean inOrderTraverseSearch(BinaryTreeNode node, int searchValue, BinaryTreeNode[] parentNode) {
        if (Objects.isNull(node)) {
            return false;
        }

        if (node.getData() > searchValue) {
            parentNode[0] = node;
            return inOrderTraverseSearch(node.getLeftChildNode(), searchValue, parentNode);
        } else if (node.getData() < searchValue) {
            parentNode[0] = node;
            return inOrderTraverseSearch(node.getRightChildNode(), searchValue, parentNode);
        } else {
            return true;
        }
    }


    /**
     * 搜索是否存在数据
     * @param node
     * @param searchValue
     * @return
     */
    private static boolean inOrderTraverseSearch(BinaryTreeNode node, int searchValue, AtomicReference<BinaryTreeNode> parentNode) {
        if (Objects.isNull(node)) {
            return false;
        }

        if (node.getData() > searchValue) {
            parentNode.set(node);
            return inOrderTraverseSearch(node.getLeftChildNode(), searchValue, parentNode);
        } else if (node.getData() < searchValue) {
            parentNode.set(node);
            return inOrderTraverseSearch(node.getRightChildNode(), searchValue, parentNode);
        } else {
            return true;
        }
    }


    /**
     * 删除二叉排序树的节点
     * @param node
     * @param searchValue
     * @return
     */
    private static boolean deleteTreeNode(BinaryTreeNode node,int searchValue) {
        if (Objects.isNull(node)) {
            return false;
        }

        if (node.getData() > searchValue) {
            return deleteTreeNode(node.getLeftChildNode(), searchValue);
        } else if (node.getData() < searchValue) {
            return deleteTreeNode(node.getRightChildNode(), searchValue);
        } else {
            return deleteNode(node);
        }
    }

    private static boolean deleteNode(BinaryTreeNode node) {
        if (Objects.isNull(node)) {
            return false;
        }

        // 左子树为空，只需要连接右子树
        if (Objects.isNull(node.getLeftChildNode())) {
            node.getParentNode().setRightChildNode(node.getRightChildNode());
            node.getParentNode().setLeftChildNode(null);
            node.getRightChildNode().setParentNode(node.getParentNode());
        } else if (Objects.isNull(node.getRightChildNode())) {
            node.getParentNode().setLeftChildNode(node.getLeftChildNode());
            node.getParentNode().setRightChildNode(null);
            node.getLeftChildNode().setParentNode(node.getParentNode());
        } else { // 左子树&右子树都存在
            // 1、获取当前节点的前继节点,也就是按照中序遍历之后的前继结点
            BinaryTreeNode leftChildNode = node.getLeftChildNode();
            BinaryTreeNode q = node;
            while (Objects.nonNull(leftChildNode.getRightChildNode())) {
                q = leftChildNode;
                leftChildNode = leftChildNode.getRightChildNode();
            }

            // 2、设置要删除的结点的值为当前找到的前继节点
            node.setData(leftChildNode.getData());

            // 3、前继结点的左子树
            if (q != node) {
                q.setRightChildNode(leftChildNode.getLeftChildNode());
                leftChildNode.getLeftChildNode().setParentNode(q);
            } else { // 待删除结点的左子结点没有右子结点
                q.setLeftChildNode(leftChildNode.getLeftChildNode());
                leftChildNode.getLeftChildNode().setParentNode(q);
            }
        }
        return true;
    }
}
