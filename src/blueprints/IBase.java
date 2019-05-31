package blueprints;

interface IBase<T> {
	// this interface contains the functions all data structures have to implement
	boolean isEmpty(); // check if the data structure is empty or not
	int count(); // return the number of elements in the list
	void insert(T data, int indexOrKey); // add data at a specify index or with the specify key
	T search(int indexOrKey); // return the data at the specify index or with specify key
	void delete(int indexOrkey); // delete the data at the specify index or with the specify key
	void clear(); // delete all the data in the data structure
}
