package com.togo.java.data.structure.tree.test;

import com.togo.java.data.structure.tree.binarytree.BinarySearchTree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> btree = new BinarySearchTree<>();
		btree.insert(6);
		btree.insert(2);
		btree.insert(8);
		btree.insert(1);
		btree.insert(5);
		btree.insert(3);
		btree.insert(4);
		btree.printTree();
		btree.remove(2);
		btree.printTree();
	}
}
