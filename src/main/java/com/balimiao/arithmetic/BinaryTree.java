package com.balimiao.arithmetic;

import com.balimiao.arithmetic.data.BinaryTreeNode;

/**
 * @Description: 二叉树的遍历
 * @Author zhushaopeng
 * @Date 2020/9/28
 **/
public class BinaryTree {


    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = generateTree();
//        //遍历二叉树,前序
//        Stack<BinaryTreeNode> stack = new Stack<>();
//        stack.push(binaryTreeNode);
//        while (!stack.empty()) {
//            BinaryTreeNode pop = stack.pop();
//            System.out.println(pop.getValue());
//            if (pop.getRightNode() != null) {
//                stack.push(pop.getRightNode());
//            }
//            if (pop.getLeftNode() != null) {
//                stack.push(pop.getLeftNode());
//            }
//        }
//        pre(binaryTreeNode);

        in(binaryTreeNode);
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public static void pre(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getValue());
        pre(node.getLeftNode());
        pre(node.getRightNode());
    }

    /**
     * 序中遍历
     *
     * @param node
     */
    public static void in(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        pre(node.getLeftNode());
        System.out.println(node.getValue());
        pre(node.getRightNode());
    }

    /**
     * 后中遍历
     *
     * @param node
     */
    public static void pos(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        pre(node.getLeftNode());
        pre(node.getRightNode());
        System.out.println(node.getValue());
    }


    public static BinaryTreeNode generateTree() {

        BinaryTreeNode root = new BinaryTreeNode();
        Integer[] nodeValue = new Integer[]{7, 3, 89, 65, 8, 87, 5, 2, 7, 9, 0, 1};
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
