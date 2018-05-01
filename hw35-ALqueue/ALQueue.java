//Team VERY COLD - ALexia Leong, Johnny Wong
//APCS2 pd1
//HW35 -- ...Nor Do Aussies
//2018-04-17

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T>{

     //inst vars
     private ArrayList<T> _queue;
     private int _size;

     //constructor
     public ALQueue(){
          _queue = new ArrayList<T>();  //where the end is the left and the front is the right side
          _size = 0;
     }

     //means of removing an element from collection:
     //Dequeues and returns the first element of the queue.
     public T dequeue(){   //O(1) runtime
          if(isEmpty()) return null;
          _size--;
          return _queue.remove(_size);
     }

     //means of adding an element to collection:
     //Enqueue an element onto the back of this queue.
     public void enqueue( T x ){   //O(n) runtime
          _queue.add(0, x);
          _size++;
     }

     //Returns true if this queue is empty, otherwise returns false.
     public boolean isEmpty(){
          return _size == 0;
     }

     //Returns the first element of the queue without dequeuing it.
     public T peekFront(){
          return _queue.get(_size - 1);
     }

}
