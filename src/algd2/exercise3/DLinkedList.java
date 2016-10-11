package algd2.exercise3;

import java.util.AbstractList;
import java.util.List;

public class DLinkedList<E> extends AbstractList<E> implements IList<E> {
	
	private int size = 0;
	public class Element<E>{
		public Element<E> prev;
		public Element<E> next;
		public E e;
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
		return item.getNext();
	}

	@Override
	public ListItem previous(ListItem item) {
		return item.getPrevious();
	}

	@Override
	public ListItem cyclicNext(ListItem item) {
		return item.getNext() != null ? item.getNext() : head();
	}

	@Override
	public ListItem cyclicPrevious(ListItem item) {
		return item.getPrevious() != null ? item.getPrevious() : tail();
	}

	@Override
	public ListItem delete(ListItem item, boolean next) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItem cyclicDelete(ListItem item, boolean next) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(ListItem item) {
		return (E) item.get();
	}

	@Override
	public void set(ListItem item, E data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(ListItem item) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override 
	public boolean add(E data){
		addTail(data);
		return true;
	}

	@Override
	public ListItem<E> addHead(E data) {
		Element<E> newE = new Element<>();
		newE.e = data;
		newE.next = head;
		head = newE;
		size++;
		return new ListItem<E>(head);
	}

	@Override
	public ListItem addTail(E data) {
		Element<E> newE = new Element<>();
		newE.e = data;
		newE.prev = tail;
		tail = newE;
		size++;
		return new ListItem<E>(tail);
	}

	@Override
	public ListItem addAfter(ListItem item, E data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItem addBefore(ListItem item, E data) {
		// TODO Auto-generated method stub
		return null;
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
