package com.sc.cd.datastruct.balance;


import lombok.Data;

@Data
public class BinaryTreeNode {

    private int data;

    private int bf;

    private BinaryTreeNode leftChildNode,rightChildNode,parentNode;

    @Override
    public String toString() {
        return "" + data;
    }
}
