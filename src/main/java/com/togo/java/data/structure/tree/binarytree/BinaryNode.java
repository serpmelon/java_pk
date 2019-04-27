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

	private T element;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	public BinaryNode(T t) {

		this(t, null, null);
	}

	public BinaryNode(T t, BinaryNode<T> left, BinaryNode<T> right) {

		this.element = t;
		this.left = left;
		this.right = right;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}

}
