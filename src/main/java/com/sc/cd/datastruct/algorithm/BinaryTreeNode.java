package com.sc.cd.datastruct.algorithm;


import lombok.Data;

@Data
public class BinaryTreeNode {

    private int data;

    private BinaryTreeNode leftChildNode,rightChildNode,parentNode;

    @Override
    public String toString() {
        return "" + data;
    }
}
