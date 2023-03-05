package org.example.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void addNode(int value) {
        root = addNodeInternal(root, value);
    }

    private Node addNodeInternal (Node root, int value ) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.left  = addNodeInternal(root.left , value);
        } else {
            root.right = addNodeInternal(root.right, value);
        }

        return root;
    }

    public void inOrder() {
        System.out.println("InOrder Traversal:");
        String traversal = inOrderRec(root, new StringBuilder());
        System.out.println(traversal);
    }

    private String inOrderRec(Node root, StringBuilder sb) {
        if(root.left != null) inOrderRec(root.left, sb);
        sb.append(root.value + "\t");
        if(root.right != null) inOrderRec(root.right, sb);
        return sb.toString();
    }

    public void levelOrder() {
        System.out.println("LevelOrder Traversal:");
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        StringBuilder sb = new StringBuilder();
        while(!nodes.isEmpty()) {
            Node node = nodes.poll();
            sb.append(node.value).append("\t");
            if(node.left != null) nodes.add(node.left);
            if(node.right != null) nodes.add(node.right);
        }
        System.out.println(sb);
    }

    @Override
    public String toString() {
        System.out.println("BinarySearchTree:");
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        StringBuilder sb = new StringBuilder();
        while(!nodes.isEmpty()) {
            Node node = nodes.poll();
            sb.append(node).append("\n");
            if(node.left != null) nodes.add(node.left);
            if(node.right != null) nodes.add(node.right);
        }
        return sb.toString();
    }

    class Node{
        public Node left;
        public Node right;
        public int value;

        public Node (int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append("[")
                    .append(left == null ? null : left.value)
                    .append(",")
                    .append(value)
                    .append(",")
                    .append(right == null ? null : right.value)
                    .append("]")
                    .toString();
        }
    }
}
