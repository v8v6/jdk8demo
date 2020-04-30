package com.sc.cd.datastruct.binarytree;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThreadedBinaryTreeNode {

    private String data;

    private ThreadedBinaryTreeNode leftChildNode,rightChildNode;

    private int leftChildTag,rightChildTag;
}
