package collections;
import blueprints.IList;

public class List<T> extends BaseList<T> implements IList<T> {
	public List() {
		super(); // call BaseList constructor
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
			begin.setPredecessor(newNode);
			begin = newNode;
			incrementIndex(begin.getSuccessor());
		}
		counter += 1;
	}
	
	public void pushBack(T data) {
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
	
	public T popFront() {
		if (this.isEmpty()) {
			return null;
		} else {
			ListNode<T> currentNode = begin;
			T data = currentNode.getData();
			begin = begin.getSuccessor();
			if (begin == null) {
				end = null;
			} else {
				decrementIndex(begin);
				begin.setPredecessor(null);
				currentNode.setSuccessor(null);
			}
			currentNode = null;
			counter -= 1;
			return data;
		}
	}
	
	public T popBack() {
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
				currentNode.setPredecessor(null);
			}
			currentNode = null;
			counter -= 1;
			return data;
		}
	}
	
	public void insert(T data, int index) {
		ListNode<T> newNode = new ListNode<T>(data);
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
				newNode.setPredecessor(end);
				end = newNode;
			} else if (index <= begin.getIndex()) {
				newNode.setIndex(begin.getIndex());
				newNode.setSuccessor(begin);
				begin.setPredecessor(newNode);
				begin = newNode;
				incrementIndex(begin.getSuccessor());
			} else {
				ListNode<T> currentNode = begin;
				ListNode<T> predecessor = null;
				while(currentNode.getIndex() < index) {
					currentNode = currentNode.getSuccessor();
				}
				newNode.setIndex(currentNode.getIndex());
				predecessor = currentNode.getPredecessor();
				predecessor.setSuccessor(newNode);
				newNode.setPredecessor(predecessor);
				newNode.setSuccessor(currentNode);
				currentNode.setPredecessor(newNode);
				incrementIndex(currentNode);
			}
		}
		counter += 1;
	}
	
	public void delete(int index) {
		ListNode<T> currentNode = begin;
		while (currentNode != null && currentNode.getIndex() != index) {
			currentNode = currentNode.getSuccessor();
		}
		if (currentNode != null) {
			ListNode<T> predecessor = currentNode.getPredecessor();
			ListNode<T> successor = currentNode.getSuccessor();
			if (predecessor != null) {
				predecessor.setSuccessor(successor);
				currentNode.setPredecessor(null);
			}
			if (successor != null) {
				successor.setPredecessor(predecessor);
				currentNode.setSuccessor(null);
				decrementIndex(successor);
			}
			currentNode = null;
			counter -= 1;
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
