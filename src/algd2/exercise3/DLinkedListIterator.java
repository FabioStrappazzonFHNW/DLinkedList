package algd2.exercise3;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DLinkedListIterator<E> implements IListIterator<E> {
	private ListItem<E> item;
	private DLinkedList<E> list;
	private int index = 0;
	
	 public DLinkedListIterator(ListItem<E> item, DLinkedList<E> list) {
		this.item = item;
		this.list = list;
	}

	@Override
	public void add(E value) {
		item.linkInAfter(list.new Element<E>(value));
	}

	@Override
	public boolean hasNext() {
		return item.getNext() != null;
	}

	@Override
	public boolean hasPrevious() {
		return item.getPrevious() != null;
	}

	@Override
	public E next() {
		if (!hasNext()) throw new NoSuchElementException();
		item = item.getNext();
		return item.get();
	}

	@Override
	public int nextIndex() {
		return index+1;
	}

	@Override
	public E previous() {
		if (!hasPrevious()) throw new NoSuchElementException();
		item = item.getPrevious();
		return item.get();
	}

	@Override
	public int previousIndex() {
		return index-1;
	}

	@Override
	public void remove() {
		item.delete();
		
	}

	@Override
	public void set(E e) {
		item.set(e);
		
	}

	@Override
	public ListItem getVisited() {
		// TODO Auto-generated method stub
		return null;
	}

}
