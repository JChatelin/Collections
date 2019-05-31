package collections;
import blueprints.IForwardList;

public class ForwardList<T> extends BaseList<T> implements IForwardList<T>{
	public ForwardList() {
		super(); // call BaseList constructor
	}
	
	public void pushBack(T data) {
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
	
	public void pushFront(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		if (this.isEmpty()) {
			newNode.setIndex(counter);
			begin = newNode;
			end = begin;
		} else {
			newNode.setIndex(begin.getIndex());
			newNode.setSuccessor(begin);
			begin = newNode;
			incrementIndex(begin.getSuccessor());
		}
		counter += 1;
	}
	
	public void insert(T data, int index) {
		ListNode<T> newNode = new ListNode<T>(data);
		ListNode<T> currentNode = null;
		ListNode<T> predecessor = null;
		if (this.isEmpty()) {
			newNode.setIndex(counter);
			begin = newNode;
			end = begin;
		} else {
			// make sure no matter what index you enter,
			// your data will be added at the right place
			if (index >= counter) {
				newNode.setIndex(counter);
				end.setSuccessor(newNode);
				end = newNode;
			} else if (index <= begin.getIndex()) {
				newNode.setIndex(begin.getIndex());
				newNode.setSuccessor(begin);
				begin = newNode;
				currentNode = begin.getSuccessor();
				incrementIndex(currentNode);
			} else {
				currentNode = begin;
				while (currentNode.getIndex() < index) {
					predecessor = currentNode;
					currentNode = currentNode.getSuccessor();
				}
				newNode.setIndex(currentNode.getIndex());
				predecessor.setSuccessor(newNode);
				newNode.setSuccessor(currentNode);
				incrementIndex(currentNode);
			}
		}
		counter += 1;
	}
	
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
			decrementIndex(begin);
			counter -= 1;
			return data;
		}
	}
	
	public void delete(int index) {
		ListNode<T> currentNode = begin;
		ListNode<T> predecessor = null;
		while(currentNode != null && currentNode.getIndex() != index) {
			predecessor = currentNode;
			currentNode = currentNode.getSuccessor();
		}
		if (currentNode != null) {
			if (predecessor != null) {
				predecessor.setSuccessor(currentNode.getSuccessor());
			}
			decrementIndex(currentNode.getSuccessor());
			currentNode.setSuccessor(null);
			currentNode = null;
		}
		counter -= 1;
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
