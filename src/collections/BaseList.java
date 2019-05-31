package collections;

class BaseList<T> extends Counter {
	protected ListNode<T> begin; 
	protected ListNode<T> end;
	
	public BaseList() {
		super(); // call Counter constructor
		begin = null;
		end = null;
	}
	
	public boolean isEmpty() {
		return begin == null; // I could have use if statement
	}
	
	public T search(int index) {
		if (this.isEmpty()) {
			return null; // in case list is empty
		} else {
			ListNode<T> currentNode = begin;
			while (currentNode != null && currentNode.getIndex() < index) {
				currentNode = currentNode.getSuccessor();
			}
			return currentNode.getData();
		}
	}
	
	protected void incrementIndex(ListNode<T> currentNode) {
		// increment all the index from the parameter node
		while (currentNode != null) {
			currentNode.setIndex(currentNode.getIndex() + 1);
			currentNode = currentNode.getSuccessor();
		}
	}
	
	protected void decrementIndex(ListNode<T> currentNode) {
		// decrement all the index from the parameter node
		while (currentNode != null) {
			currentNode.setIndex(currentNode.getIndex() - 1);
			currentNode = currentNode.getSuccessor();
		}
	}
}
