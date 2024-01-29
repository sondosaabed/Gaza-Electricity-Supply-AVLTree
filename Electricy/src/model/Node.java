package model;

public class Node<T> {
    private int key; 
    private T data; //AVLTree<AVLTRE<DailyRecord>>, AVLTREE<DailyRecord>, DailyREcord
    private int height;
    private Node<T> left;
    private Node<T> right;

    public Node(int key, T data) {
    	setKey(key);
    	setHeight(1);
		setData(data);
    }
    
    /*
     * Getters & setters
     */
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}