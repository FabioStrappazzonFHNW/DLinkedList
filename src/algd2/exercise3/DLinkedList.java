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
		if (item.get() == head) {
			head = (Element<E>) item.getPrevious().get();
		} else if (item.get() == tail) {
		 	tail = (Element<E>) item.getNext().get();
		}
		ListItem value;
		if (next) {
			value = item.getNext();
		} else {
			value = item.getPrevious();
		}
		item.delete();
		size--;
		return value;
	}

	@Override
	public ListItem<E> cyclicDelete(ListItem item, boolean next) {
		if (item.get() == head) {
			head = (Element<E>) item.getPrevious().get();
		} else if (item.get() == tail) {
			tail = (Element<E>) item.getNext().get();
		}
		ListItem value;
		if (next) {
			value = cyclicNext(item);
		} else {
			value = cyclicPrevious(item);
		}
		item.delete();
		size--;
		return value;
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
	public ListItem<E> addTail(E data) {
		Element<E> newE = new Element<>(data);
		newE.prev = tail;
		tail = newE;
		size++;
		return new ListItem<E>(tail);
	}

	@Override
	public ListItem<E> addAfter(ListItem item, E data) {
		if (item.getNext() == null) {
			return addHead(data);
		} else {
			Element<E> newE = new Element<>(data);
			item.linkInAfter(newE);
			size++;
			return new ListItem(newE);
		}
	}

	@Override
	public ListItem<E> addBefore(ListItem item, E data) {
		if (item.getPrevious() == null) {
			return addTail(data);
		} else {
			Element<E> newE = new Element<>(data);
			item.linkInBefore(newE);
			size++;
			return new ListItem(newE);
		}
	}

	@Override
	public void moveToHead(ListItem item) {
		Element<E> e = (Element) item.get();
		this.delete(item, true);
		this.addHead(e.e);
		
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

	public E get(int index) {
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
			i = size;
			elem = tail;
			while(i != index) {
				elem = elem.prev;
				i--;
			}
		}
		return (E) elem.e;
	}

	@Override
	public int size() {
		return size;
	}

	

}
