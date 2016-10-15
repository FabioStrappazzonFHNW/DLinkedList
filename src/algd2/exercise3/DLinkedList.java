package algd2.exercise3;

import java.util.AbstractList;
import java.util.List;

public class DLinkedList<E> extends AbstractList<E> implements IList<E> {
	
	private int size = 0;
	public class Element<E>{
		public Element<E> prev;
		public Element<E> next;
		public E e;

		public Element(E data) {
			e = data;
		}
	}
	private Element<E> head;
	private Element<E> tail;

	@Override
	public boolean checkMembership(ListItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ListItem head() {
		return new ListItem<E>(head);
	}

	@Override
	public ListItem tail() {
		return new ListItem<E>(tail);
	}

	@Override
	public ListItem next(ListItem item) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		return item.getNext();
	}

	@Override
	public ListItem previous(ListItem item) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		return item.getPrevious();
	}

	@Override
	public ListItem cyclicNext(ListItem item) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		return item.getNext() != null ? item.getNext() : head();
	}

	@Override
	public ListItem cyclicPrevious(ListItem item) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		return item.getPrevious() != null ? item.getPrevious() : tail();
	}

	@Override
	public ListItem delete(ListItem item, boolean next) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItem cyclicDelete(ListItem item, boolean next) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(ListItem item) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		return (E) item.get();
	}

	@Override
	public void set(ListItem item, E data) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		item.set(data);
	}

	@Override
	public E remove(ListItem item) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		if (item.get() == tail) {
			tail = (Element<E>) item.getNext().get();
		} else if (item.get() == head) {
			head = (Element<E>) item.getPrevious().get();
		}
		size--;
		return (E) item.delete();
	}
	
	@Override 
	public boolean add(E data){
		addTail(data);
		return true;
	}

	@Override
	public ListItem<E> addHead(E data) {
		Element<E> newE = new Element<>(data);
		newE.next = head;
		head = newE;
		size++;
		return new ListItem<E>(head);
	}

	@Override
	public ListItem addTail(E data) {
		Element<E> newE = new Element<>(data);
		newE.prev = tail;
		tail = newE;
		size++;
		return new ListItem<E>(tail);
	}

	@Override
	public ListItem addAfter(ListItem item, E data) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		if (item.getNext() == null) {
			return addHead(data);
		} else {
			Element<E> newE = new Element<>(data);
			item.linkInAfter(newE);
			return new ListItem(newE);
		}
	}

	@Override
	public ListItem addBefore(ListItem item, E data) {
		if (! checkMembership(item)) throw new IllegalArgumentException();
		if (item.getPrevious() == null) {
			return addTail(data);
		} else {
			Element<E> newE = new Element<>(data);
			item.linkInBefore(newE);
			return new ListItem(newE);
		}
	}

	@Override
	public void moveToHead(ListItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveToTail(ListItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate(ListItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swap(ListItem item1, ListItem item2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAfter(ListItem item, List<E> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBefore(ListItem item, List<E> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void conc(List<E> list, boolean after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IList<E> remove(ListItem startInclusive, ListItem endExclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	

}
