package collections;
import blueprints.ITree;

public class SearchTree<T> extends BaseTree<T> implements ITree<T> {
	public SearchTree() {
		super(); // call BaseTree constructor
	}
	
	private void displayData(TreeNode<T> node) {
		if (node != null) {
			displayData(node.getLeftSon());
			System.out.println("Data : " + node.getData());
			displayData(node.getRightSon());
		}
	}
	
	public void displayData() {
		displayData(root);
	}
	
	public void insert(T data, int key) {
		TreeNode<T> newNode = new TreeNode<T>(data, key);
		if (this.isEmpty()) {
			root = newNode;
		} else {
			TreeNode<T> currentNode = root;
			TreeNode<T> father = null;
			while (currentNode != null) {
				father = currentNode;
				if (currentNode.getKey() < newNode.getKey()) {
					currentNode = currentNode.getRightSon();
				} else {
					currentNode = currentNode.getLeftSon();
				}
			}
			if (father != null) {
				if (father.getKey() < newNode.getKey()) {
					father.setRightSon(newNode);
				} else {
					father.setLeftSon(newNode);
				}
				newNode.setFather(father);
			}
		}
		counter += 1;
	}
	
	public T maximum() {
		TreeNode<T> currentNode = root;
		TreeNode<T> father = null;
		if (this.isEmpty()) {
			return null;
		} else if (counter == 1) {
			return root.getData();
		} else {
			while (currentNode != null) {
				father = currentNode;
				currentNode = currentNode.getRightSon();
			}
			return father.getData();
		}
	}
	
	public T minimum() {
		TreeNode<T> currentNode = root;
		TreeNode<T> father = null;
		if (this.isEmpty()) {
			return null;
		} else if (counter == 1) {
			return root.getData();
		} else {
			while (currentNode != null) {
				father = currentNode;
				currentNode = currentNode.getLeftSon();
			}
			return father.getData();
		}
	}
	
	private TreeNode<T> findNode(TreeNode<T> currentNode, int key) {
		while (currentNode != null && currentNode.getKey() != key) {
			if (currentNode.getKey() < key) {
				currentNode = currentNode.getRightSon();
			} else {
				currentNode = currentNode.getLeftSon();
			}
		}
		return currentNode;
	}
	
	public T search(int key) {
		if (this.isEmpty()) {
			return null;
		} else {
			TreeNode<T> currentNode = findNode(root, key);
			if (currentNode != null) {
				return currentNode.getData();
			} else {
				return null;
			}
		}
	}
	
	public void delete(int key) {
		TreeNode<T> currentNode = findNode(root, key);
		if (currentNode != null) {
			// I will define the code that goes here later.
		}
	}
	
	
	public void clear() {
		clear(root);
		root = null;
		counter = 0;
	}
}
