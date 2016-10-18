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
		for(Element<E> current = head; current != tail; current= current.next)
			if(item.get() == current)
				return true;
		return false;
	}

	@Override
	public ListItem<E> head() {
		return new ListItem<E>(head);
	}

	@Override
	public ListItem<E> tail() {
		return new ListItem<E>(tail);
	}

	@Override
	public ListItem<E> next(ListItem item) {
		return item.getNext();
	}

	@Override
	public ListItem<E> previous(ListItem item) {
		return item.getPrevious();
	}

	@Override
	public ListItem<E> cyclicNext(ListItem item) {
		return item.getNext() != null ? item.getNext() : head();
	}

	@Override
	public ListItem<E> cyclicPrevious(ListItem item) {
		return item.getPrevious() != null ? item.getPrevious() : tail();
	}

	@Override
	public ListItem<E> delete(ListItem item, boolean next) {
		if (item.getPrevious() == null) {
			head = head.next;
		} else if (item.getNext() == null) {
		 	tail = tail.prev;
		}
		ListItem<E> value;
		if (next) {
			value = item.getNext();
		} else {
			value = item.getPrevious();
		}
		item.delete();
		size--;
		modCount++;
		return value;
	}

	@Override
	public ListItem<E> cyclicDelete(ListItem item, boolean next) {
		if (item.getPrevious() == null) {
			head = head.next;
		} else if (item.getNext() == null) {
			tail = tail.prev;
		}
		ListItem<E> value;
		if (next) {
			value = cyclicNext(item);
		} else {
			value = cyclicPrevious(item);
		}
		item.delete();
		modCount++;
		if (--size > 0) {
			return value;
		} else {
			return null;
		}
	}

	@Override
	public E get(ListItem item) {
		return (E) item.get();
	}

	@Override
	public void set(ListItem item, E data) {
		item.set(data);
	}

	@Override
	public E remove(ListItem item) {
		if (item.getPrevious() == null) {
			head = head.next;
		} else if (item.getNext() == null) {
			tail = tail.prev;
		}
		size--;
		modCount++;
		return (E) item.delete();
	}
	
	@Override
	public E remove(int index){
		if(index<0 || index>= size){
			throw new IndexOutOfBoundsException();
		}
		Element<E> el = getEl(index);
		return remove(new ListItem<E>(el));
	}
	
	@Override 
	public boolean add(E data){
		addTail(data);
		return true;
	}

	@Override
	public ListItem<E> addHead(E data) {
		Element<E> newE = new Element<>(data);
		if (size == 0) {
			tail = newE;
			head = newE;
		} else {
			newE.next = head;
			head.prev = newE;
			head = newE;
		}
		size++;
		modCount++;
		return new ListItem<E>(head);
	}

	@Override
	public ListItem<E> addTail(E data) {
		Element<E> newE = new Element<>(data);
		if (size == 0) {
			tail = newE;
			head = newE;
		} else {
			newE.prev = tail;
			tail.next = newE;
			tail = newE;
		}
		size++;
		modCount++;
		return new ListItem<E>(tail);
	}

	@Override
	public ListItem<E> addAfter(ListItem item, E data) {
		if (item == null) return addHead(data);
		if (item.getNext() == null) {
			return addTail(data);
		} else {
			Element<E> newE = new Element<>(data);
			item.linkInAfter(newE);
			size++;
			modCount++;
			return new ListItem<E>(newE);
		}
	}

	@Override
	public ListItem<E> addBefore(ListItem item, E data) {
		if (item == null) return addTail(data);
		if (item.getPrevious() == null) {
			return addHead(data);
		} else {
			Element<E> newE = new Element<>(data);
			item.linkInBefore(newE);
			size++;
			modCount++;
			return new ListItem<E>(newE);
		}
	}

	@Override
	public void moveToHead(ListItem item) {
		E e = (E) item.get();
		this.delete(item, true);
		this.addHead(e);
		
	}

	@Override
	public void moveToTail(ListItem item) {
		E e = (E) item.get();
		this.delete(item, true);
		this.addTail(e);
	}

	@Override
	public void rotate(ListItem item) {
		if(item.element != head){
			Element<E> segment = head;
			ListItem<E> oldTail = new ListItem<E>(tail);
			head = item.element;
			tail = head.prev;
			head.prev = null;
			tail.next = null;
			oldTail.linkInAfter(segment);
			modCount++;
		}
	}

	@Override
	public void swap(ListItem item1, ListItem item2) {
		E tmp = (E) item1.get();
		item1.element.e= item2.get();
		item2.element.e= tmp;
		Element<E> el = item1.element;
		item1.element = item2.element;
		item2.element = el;
		modCount++;
	}

	@Override
	public void reverse() {
		ListItem<E> item1 = head();
		ListItem<E> item2 = tail();
		while (item1 != null &&
				item2 != null &&
				!item1.equals(item2) &&
				!item2.equals(item1.getPrevious())){
			swap(item1, item2);
			item1 = item2.getNext();
			item2 = item1.getPrevious();
		}
		modCount++;
	}

	@Override
	public void addAfter(ListItem item, List<E> list) {
		if(item == null){
			conc(list, false);
		} else {
			E el;
			while (!list.isEmpty()) {
				el = list.remove(0);
				item = addAfter(item, el);
			}
		}
		modCount++;
	}

	@Override
	public void addBefore(ListItem item, List<E> list) {
		if (item == null) {
			conc(list, true);
		} else {
			E el;
			while (!list.isEmpty()) {
				el = list.remove(list.size()-1);
				item = addBefore(item, el);
			}
		}
		modCount++;
	}

	@Override
	public void conc(List<E> list, boolean after) {
		ListItem<E> item;
		if (after) {
			item = new ListItem<E>(tail);
			addAfter(item, list);
		} else {
			item = new ListItem<E>(head);
			addBefore(item, list);
		}
		modCount++;
	}

	@Override
	public IList<E> remove(ListItem startInclusive, ListItem endExclusive) {
		DLinkedList<E> l = new DLinkedList<>();
		while(startInclusive != null && !startInclusive.equals(endExclusive)){
			l.addTail((E)startInclusive.get());
			startInclusive = cyclicDelete(startInclusive, true);
		}
		modCount++;
		return l;
	}

	@Override
	public IListIterator<E> listIterator() {
		return new DLinkedListIterator<E>(new ListItem<E>(head), this);
	}

	@Override
	public IListIterator<E> listIterator(int index) {
		return new DLinkedListIterator<E>(new ListItem<E>(getEl(index)), this);
	}

	public E get(int index) {
		return getEl(index).e;
	}
	
	private Element<E> getEl(int index){
		if(index <0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		int i;
		Element<E> elem;
		if(index <= size/2) {
			i = 0;
			elem = head;
			while(i != index) {
				elem = elem.next;
				i++;
			}
		} else {
			i = size-1;
			elem = tail;
			while(i != index) {
				elem = elem.prev;
				i--;
			}
		}
		return elem;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
}
