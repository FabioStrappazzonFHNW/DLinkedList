package algd2.exercise3;

public class ListItem<E> {
	private DLinkedList<E>.Element<E> element;
	
	public ListItem(DLinkedList<E>.Element<E> e){
		element = e;
	}
	public E get(){
		return element != null?element.e:null;
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
}
