package algd2.exercise3;

public class ListItem<E> {
	private DLinkedList<E>.Element<E> element;
	
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

	public void linkInAfter(DLinkedList<E>.Element<E> value) {
		DLinkedList<E>.Element<E> next = element.next;
		element.next = value;
		value.next = next;
		value.prev = element;
		next.prev = value;
	}

	public void linkInBefore(DLinkedList<E>.Element<E> value) {
		DLinkedList<E>.Element<E> prev = element.prev;
		element.prev = value;
		value.prev = prev;
		value.next = element;
		prev.next = value;
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
}
