package com.balimiao.arithmetic;

import com.alibaba.fastjson.JSON;
import com.balimiao.arithmetic.data.BinaryTreeNode;

import java.util.Stack;

/**
 * @Description: 二叉树的遍历
 * @Author zhushaopeng
 * @Date 2020/9/28
 **/
public class BinaryTree {


    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = generateTree();
        //遍历二叉树,前序
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(binaryTreeNode);
        while (!stack.empty()) {
            BinaryTreeNode pop = stack.pop();
            System.out.println(pop.getValue());
            if (pop.getRightNode() != null) {
                stack.push(pop.getRightNode());
            }
            if (pop.getLeftNode() != null) {
                stack.push(pop.getLeftNode());
            }
        }

        //遍历二叉树,中
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack.push(binaryTreeNode);
        while (!stack.empty()) {
            BinaryTreeNode pop = stack.pop();
            if (pop.getRightNode() != null) {
                stack.push(pop.getRightNode());
            }
            if (pop.getLeftNode() != null) {
                stack.push(pop.getLeftNode());
            }
        }



    }


    public static BinaryTreeNode generateTree() {

        BinaryTreeNode root = new BinaryTreeNode();
        Integer[] nodeValue = new Integer[]{7, 3, 89, 65, 3, 87, 5, 3, 7, 9, 0, 3};
        for (Integer value : nodeValue) {


            if (root.getValue() == null) {
                root.setValue(value);
                continue;
            }
            BinaryTreeNode temp = root;
            boolean flag = true;
            while (flag) {
                if (temp.getValue().compareTo(value) == 0) {
                    flag = false;
                }
                if (value.compareTo(temp.getValue()) < 0) {  //小, 左边
                    BinaryTreeNode leftNode = temp.getLeftNode();
                    if (leftNode == null) {
                        temp.setLeftNode(new BinaryTreeNode(value));
                        flag = false;
                    } else {
                        temp = leftNode;
                    }
                } else { //大,右边
                    BinaryTreeNode rightNode = temp.getRightNode();
                    if (rightNode == null) {
                        temp.setRightNode(new BinaryTreeNode(value));
                        flag = false;
                    } else {
                        temp = rightNode;
                    }
                }
            }
        }
        return root;
    }
}
