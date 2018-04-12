// Johnny Wong
// APCS2 -- pd1
// HW32 -- Leon Leonwood Stack
// 2018-04-12

import java.util.ArrayList;

public class ALStack<T> implements Stack<T>{
     // inst vars
     ArrayList<T> _stack;
     int _stackSize;

     public ALStack(){
          _stack = new ArrayList<T>();
          _stackSize = 0;
     }

     //Return true if this stack is empty, otherwise false.
     public boolean isEmpty(){
          return _stackSize == 0;
     }

     //Return top element of stack without popping it.
     public T peek(){
          return _stack.get(_stackSize - 1);
     }

     //Pop and return top element of stack.
     public T pop(){
          _stackSize--;
          return _stack.remove(_stackSize);
     }

     //Push an element onto top of this stack.
     public void push( T x ){
          _stack.add(x);
          _stackSize++;
     }
}
