package com.balimiao.arithmetic.data;

/**
 * @Description: 二叉树的节点
 * @Author zhushaopeng
 * @Date 2020/9/28
 **/
public class BinaryTreeNode {
    //值
    private Integer value;
    //左节点
    private BinaryTreeNode leftNode;
    //右节点
    private BinaryTreeNode rightNode;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
