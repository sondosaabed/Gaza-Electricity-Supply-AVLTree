package model;

public class AVLTree<T> {
    private Node<T> root;

    private int height(Node<T> n) {
        return n == null ? 0 : n.getHeight();
    }

    private int getBalance(Node<T> n) {
        return n == null ? 0 : height(n.getRight()) - height(n.getLeft());
    }

    private void updateHeight(Node<T> n) {
        n.setHeight(1 + Math.max(height(n.getLeft()), height(n.getRight())));
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.getLeft();
        Node<T> z = x.getRight();
        x.setRight(y);
        y.setLeft(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<T> rotateLeft(Node<T> y) {
        Node<T> x = y.getRight();
        Node<T> z = x.getLeft();
        x.setLeft(y);
        y.setRight(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    
    /*
     * Each time we make an update to the AVL tree
     * it is neccessary to rebalnce it
     */
    private Node<T> rebalance(Node<T> z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.getRight().getRight()) > height(z.getRight().getLeft())) {
                z = rotateLeft(z);
            } else {
                z.setRight(rotateRight(z.getRight()));
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.getLeft().getLeft()) > height(z.getLeft().getRight()))
                z = rotateRight(z);
            else {
                z.setLeft(rotateLeft(z.getLeft()));
                z = rotateRight(z);
            }
        }
        return z;
    }
    
    /*
     * We insert a key and a data by creating a new node
     * 
     */
    public void insert(int key, T data) {
        root = insert(root, key, data);
    }

    private Node<T> insert(Node<T> node, int key, T data) {
        if (node == null) {
            return new Node<T>(key, data);
        } else if (node.getKey() > key) {
            node.setLeft(insert(node.getLeft(), key, data));
        } else if (node.getKey() < key) {
            node.setRight(insert(node.getRight(), key, data));
        } 
        return rebalance(node);
    }
    
    /*
     * We delete the data using the key of the node
     * could be day month year based on the year
     */
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node<T> delete(Node<T> node, int key) {
        if (node == null) {
            return node;
        } else if (node.getKey() > key) {
            node.setLeft(delete(node.getLeft(), key));
        } else if (node.getKey() < key) {
            node.setRight(delete(node.getRight(), key));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
            } else {
                Node<?> mostLeftChild = mostLeftChild(node.getRight());
                node.setKey(mostLeftChild.getKey());
                node.setRight(delete(node.getRight(), node.getKey()));
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }
    
    /*
     * To update the node we delete the already existing and then insert the updated one
     * We also check if it exists or not
     */
    public void update(int key, T newData) {
        root = update(root, key, newData);
    }
    
    private Node<T> update(Node<T> root2, int key, T newData) {
    	delete(key);	
    	return insert(root2, key, newData);
	}

	private Node<T> mostLeftChild(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
	
	/*
	 * The search is done using the key, which is integer 
	 * could be month, year, day
	 */
    public Node<T> search(int key) {
        return search(root, key);
    }

    private Node<T> search(Node<T> node, int key) {
        while (node != null) {
            if (node.getKey() == key) {
                break;
            }
            node = (node.getKey() < key) ? node.getRight() : node.getLeft();
        }
        return node;
    }

    /*
     * Getters & setters
     */
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
}