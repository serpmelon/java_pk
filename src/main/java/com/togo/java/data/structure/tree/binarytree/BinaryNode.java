package com.togo.java.data.structure.tree.binarytree;

/**
 * 
 * @author AI
 * @desc 二叉树节点描述
 *
 * @date 2019年4月27日
 *
 */
public class BinaryNode<T> {

	private T t;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	public BinaryNode(T t) {

		this(t, null, null);
	}

	public BinaryNode(T t, BinaryNode<T> left, BinaryNode<T> right) {

		this.t = t;
		this.left = left;
		this.right = right;
	}
}
