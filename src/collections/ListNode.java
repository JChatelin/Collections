package collections;

class ListNode<T> {
	private ListNode<T> successor;
	private ListNode<T> predecessor;
	private T data;
	private int index;
	
	ListNode(T data) {
		this.data = data;
		successor = null;
		predecessor = null;
	}
	
	T getData() {
		return data;
	}
	
	void setData(T data) {
		this.data = data;
	}
	
	int getIndex() {
		return index;
	}
	
	void setIndex(int index) {
		this.index = index;
	}
	
	ListNode<T> getSuccessor() {
		return successor;
	}
	
	void setSuccessor(ListNode<T> successor) {
		this.successor = successor;
	}
	
	ListNode<T> getPredecessor() {
		return predecessor;
	}
	
	void setPredecessor(ListNode<T> predecessor) {
		this.predecessor = predecessor;
	}
}
