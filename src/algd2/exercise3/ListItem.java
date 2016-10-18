package algd2.exercise3;

public class ListItem<E> {
	protected DLinkedList<E>.Element<E> element;
	
	public ListItem(DLinkedList<E>.Element<E> e){
		element = e;
	}

	public E get(){
		return element != null?element.e:null;
	}

	public void set(E data) {
		element.e = data;
	}

	public ListItem<E> getNext(){
		if(element.next != null){
			return new ListItem<E>(element.next);
		}
		return null;
	}
	public ListItem<E> getPrevious(){
		if(element.prev != null){
			return new ListItem<E>(element.prev);
		}
		return null;
	}

	public ListItem<E> linkInAfter(DLinkedList<E>.Element<E> value) {
		DLinkedList<E>.Element<E> next = element.next;
		element.next = value;
		value.next = next;
		value.prev = element;
		next.prev = value;
		return new ListItem<E>(value);
	}

	public ListItem<E> linkInBefore(DLinkedList<E>.Element<E> value) {
		DLinkedList<E>.Element<E> prev = element.prev;
		element.prev = value;
		value.prev = prev;
		value.next = element;
		prev.next = value;
		return new ListItem<E>(value);
	}

	public E delete() {
		if (element.prev != null && element.next != null) {
			DLinkedList<E>.Element<E> prev = element.prev;
			DLinkedList<E>.Element<E> next = element.next;
			prev.next = next;
			next.prev = prev;
		} else if (element.prev != null) {
			DLinkedList<E>.Element<E> prev = element.prev;
			prev.next = null;
		} else if (element.next != null){
			DLinkedList<E>.Element<E> next = element.next;
			next.prev = null;
	}
		return element.e;
	}
	
	public boolean equals(ListItem other){
		if(other == null){
			return false;
		}
		if(this == other){
			return true;
		}
		return element == other.element;
	}
}
