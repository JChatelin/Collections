package blueprints;

public interface ITree<T> extends IBase<T>{
	T maximum(); // return highest key in the tree
	T minimum(); // return the lowest key in the tree
}
