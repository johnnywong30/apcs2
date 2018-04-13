// Johnny Wong
// APCS2 -- pd1
// HW32 -- Leon Leonwood Stack
// 2018-04-12

import java.util.LinkedList;

public class LLStack<T> implements Stack<T>{
     // inst vars
     LinkedList<T> _stack;
     int _stackSize;

     public LLStack(){
          _stack = new LinkedList<T>();
          _stackSize = 0;
     }

     //Return true if this stack is empty, otherwise false.
     public boolean isEmpty(){ // O(1)
          return _stackSize == 0;
     }

     //Return top element of stack without popping it.
     public T peek(){ // O(1) because the _tail of a LinkedList is stored
          return _stack.getLast();
     }

     //Pop and return top element of stack.
     public T pop(){ // O(1) because the _tail of a LinkedList is stored
          _stackSize--;
          return _stack.removeLast();
     }

     //Push an element onto top of this stack.
     public void push( T x ){ // O(1) because the _tail of a LinkedList becomes x
          _stack.add(x);
          _stackSize++;
     }
}
