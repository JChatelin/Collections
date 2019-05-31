package collections;

class BaseTree<T> extends Counter {
	protected TreeNode<T> root;
	
	public BaseTree() 
	{
		super();
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null; // shorter than using if statement
	}
	
	protected void transplant(TreeNode<T> currentNode, TreeNode<T> son) {
		// this functions is use in the delete function
		// to attach the son parameter with the currentNode parameter's father.
		TreeNode<T> father = currentNode.getFather();
		if (father == null)
		{
			root = son;
		} else if (father.getRightSon() == currentNode)
		{
			father.setRightSon(son);
		} else
		{
			father.setLeftSon(son);
		}
		if (son != null)
		{
			son.setFather(father);
		}
	}
	
	protected void clear(TreeNode<T> node) {
		// delete every no node from parameter node
		// It meant to be use only within the derived class
		if (node != null) {
			clear(node.getLeftSon());
			clear(node.getRightSon());
			node.setLeftSon(null);
			node.setRightSon(null);
			node = null;
		}
	}
}
