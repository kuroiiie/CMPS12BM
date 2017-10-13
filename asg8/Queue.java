//Queue.java
//Queue with iteration

import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue <Item> implements Iterable <Item> {

   private class Node {
      Item item;
      Node next;
   }
   private Node head = null;
   private Node tail = null;

   public boolean isempty() {
	   return (head==null); //Checks if head null, means queue is empty
   }

   public void insert(Item newitem) {
	   Node temp = new Node(); //Creating a node with newitem
	   temp.item = newitem;
	   temp.next = null;
	   if(head == null) { //If imserting into an empty queue
		   head = temp;
		   tail = temp;
	   }
	   else { //If inserting into an existing queue
		   tail.next = temp;
		   tail = temp;
	   }
   }

   public Iterator <Item> iterator() {
      return new Itor (); //Creates an itorator item
   }

   class Itor implements Iterator <Item> { //Iterator class
      Node current = head;
      public boolean hasNext() {
         return current != null;
      }
      public Item next() { //Iterates through <Item> and returns current result
         if (! hasNext ()) throw new NoSuchElementException();
         Item result = current.item;
         current = current.next;
         return result;
      }
      public void remove() { //Doesn't have to be implemented
         throw new UnsupportedOperationException();
      }
   }

}
