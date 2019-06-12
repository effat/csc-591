package Project_1;




public class LinkedList<E> {
		
		private int size;
		
	    private LinkedListNode<E> head;
	    
	    private LinkedListNode<E> back;
	    
	    //constructor
	    public LinkedList() {
	        back = null;

	    	head = new LinkedListNode<E>(null);
	        size = 0;
	    }
	    /**
	     * constructor for the linedlistnode
	     * @author baris
	     * @param <E>
	     */
		 private class LinkedListNode<E> {
			 
			 private E data;
			 
		     private LinkedListNode next;
		     
		     public LinkedListNode(E value) {
		    	 this(value, null);
		     }
		     
		     public LinkedListNode(E value, LinkedListNode<E> next) {
		    	 setElement(value);
		    	 setNext(next);
		     }
		     
		     
		     public E getValue() {
		     	return data;
	 	    }
		     
		     public void setNext(LinkedListNode<E> next) {
		    	 this.next = next;
		     }
		     
		     public void setElement(E value) {
		    	 data = value;
		     }
		 }
		public void addFront(int index, E value) {
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException("Invalid index.");
			}
	 		if(value == null) {
				throw new NullPointerException();
			}
			if(index == 0) {
				head = new LinkedListNode<E>(value, head); 
				if (size == 0) {
				back = head; 
				}
			} 
			 size = size + 1;

			
		}
		public E get(int index) {
			LinkedListNode<E> node = head;
			for(int i = 0; i < index; i++) {
				node = node.next;
			}
			return node.data;
		}
		public E remove(int index) {
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException("Invalid index.");
			}
			E element = null;
			LinkedListNode<E> node = head;
	        LinkedListNode<E> prev = null;
	        int i = 0;
	        while (node != null && i != index) {
	        	prev = node;
	            node = node.next;
	            i = i + 1;
	        } 
	        if (node != null) {
	            if (node == head) {
	                element = head.data;
	                head = head.next;
	            } else if(node == back) {
	            	element = back.data;
	            	node.next = prev;
	            	back.next = prev;
	            } 
	            else {
	                element = node.data;
	                prev.next = node.next;
	            }
	        }
	        size = size - 1;
			return element;
		}
		public int size() {
			return size;
		}
		public E set(int index, E value) {
			//checkIndex(index);
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException("Invalid index.");
			}
			LinkedListNode<E> node = head;
			for(int i = 0; i < index; i++) {
				node = node.next;
			}
			E element = node.data;
			node.data = value;
			return element;
		} 
		
		
	 
	
					
		

}

