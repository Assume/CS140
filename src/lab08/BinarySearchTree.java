package lab08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<T> {

	private Comparator<T> comp;
	private T item;
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> right;

	public BinarySearchTree(Comparator<T> comp) {
		this.comp = comp;
	}

	public T find(T t) {
		if (item == null)
			return null;
		int original_compare = comp.compare(t, item);
		if (original_compare == 0)
			return t;
		else if (original_compare < 0)
			if (left != null)
				return left.find(t);
			else {
				if (right != null)
					right.find(t);
			}
		return null;

	}

	public void insert(T t) {
		if (item == null) {
			item = t;
			return;
		}
		int original_compare = comp.compare(t, item);
		if (original_compare == 0)
			return;
		else if (original_compare < 0) {
			if (left == null) {
				left = new BinarySearchTree<T>(comp);
				left.item = t;
			} else
				left.insert(t);
		}

		else {
			if (right == null) {
				right = new BinarySearchTree<T>(comp);
				right.item = t;
			} else
				right.insert(t);
		}
	}

	public List<T> getElems() {
		List<T> list = new ArrayList<T>();
		if (item == null)
			return list;
		if (left != null)
			list.addAll(left.getElems());
		if (right != null)
			list.addAll(right.getElems());
		return list;
	}

}
