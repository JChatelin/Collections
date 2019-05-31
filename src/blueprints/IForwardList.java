package blueprints;

public interface IForwardList<T> extends IBase<T> {
	// This interface extends the Base interface with three functions 
	// to push and retrieve data in and from forward list
	void pushBack(T data); // add data at the end of the list
	void pushFront(T data); // add data at the beginning of the list
	T pop(); // return the first data of the list
}
