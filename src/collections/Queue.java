package collections;

public class Queue<T> extends BaseList<T> {
	// Here I choose to implement the Queue using a linked list
	// the implementation may change later
	public Queue() {
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
			end = newNode;
		}
		counter += 1;
	}
	
	// retrieve data from the beginning
	public T pop() {
		if(this.isEmpty()) {
			return null;
		} else {
			ListNode<T> currentNode = begin;
			T data = currentNode.getData();
			begin = begin.getSuccessor();
			if (begin == null) {
				end = null;
			}
			currentNode.setSuccessor(null);
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
			}
			currentNode.setSuccessor(null);
			currentNode = null;
			counter -= 1;
		}
	}
}
