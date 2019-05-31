package collections;

class TreeNode<T> {
	private TreeNode<T> leftSon;
	private TreeNode<T> rightSon;
	private TreeNode<T> father;
	private T data;
	private int key;
	
	TreeNode(T data, int key) {
		this.data = data;
		this.key = key;
		leftSon = null;
		rightSon = null;
		father = null;
	}
	
	int getKey() {
		return key;
	}
	
	void setKey(int key) {
		this.key = key;
	}
	
	T getData() {
		return data;
	}
	
	void setData(T data) {
		this.data = data;
	}
	
	TreeNode<T> getLeftSon() {
		return leftSon;
	}
	
	void setLeftSon(TreeNode<T> leftSon) {
		this.leftSon = leftSon;
	}
	
	TreeNode<T> getRightSon() {
		return rightSon;
	}
	
	void setRightSon(TreeNode<T> rightSon) {
		this.rightSon = rightSon;
	}
	
	TreeNode<T> getFather() {
		return father;
	}
	
	void setFather(TreeNode<T> father) {
		this.father = father;
	}
}
