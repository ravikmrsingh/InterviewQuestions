package org.example;


import org.example.bst.BinarySearchTree;

public class App  {
    public static void main( String[] args ) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.addNode(50);
        tree.addNode(70);
        tree.addNode(40);
        tree.addNode(45);
        tree.addNode(75);
        tree.addNode(65);
        tree.inOrder();
        tree.levelOrder();
        System.out.println(tree);
    }
}
