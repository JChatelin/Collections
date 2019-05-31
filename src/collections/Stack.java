package collections;

public class Stack<T> extends BaseList<T>{
	// Here I choose to implement the Stack using a linked list
	// the implementation may change later
	public Stack() {
		super();
	}
	
	// add data at the end
	public void push(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.setIndex(counter);
		if (this.isEmpty()) {
			begin = newNode;
			end = begin;
		} else {
			end.setSuccessor(newNode);
			newNode.setPredecessor(end);
			end = newNode;
		}
		counter += 1;
	}
	
	// retrieve data from the beginning
	public T pop() {
		if (this.isEmpty()) {
			return null;
		} else {
			ListNode<T> currentNode = end;
			T data = currentNode.getData();
			end = end.getPredecessor();
			if (end == null) {
				begin = null;
			} else {
				end.setSuccessor(null);
			}
			currentNode.setPredecessor(null);
			currentNode = null;
			counter -= 1;
			return data;
		}
	}
	
	public void clear() {
		ListNode<T> currentNode = null;
		while(!this.isEmpty()) {
			currentNode = begin;
			begin = begin.getSuccessor();
			if (begin == null) {
				end = null;
			} else {
				begin.setPredecessor(null);
			}
			currentNode.setSuccessor(null);
			currentNode = null;
			counter -= 1;
		}
	}
}
