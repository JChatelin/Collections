package blueprints;

public interface IList<T> extends IBase<T> {
	// This interface extends the Base interface with four functions 
	// to push and retrieve data in and list
	void pushBack(T data); // add data at the end of the list
	void pushFront(T data); // add data at the beginning of the list
	T popBack(); // return the data at the end of the list
	T popFront(); // return the data at the beginning of the list
}
