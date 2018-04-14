// Johnny Wong
// APCS2 -- pd1
// HW34 -- The English Do Not Wait In Line
// 2018-04-16

public class NodeQueue<T> implements Queue<T>{
     // inst vars
     LLNode<T> _queue;
     int _queueSize;

     // constructor
     public NodeQueue(){
          _queue = new LLNode<T>(null, null);
          _queueSize = 0;
     }

     //means of removing an element from collection:
     //Dequeues and returns the first element of the queue.
     public T dequeue(){ // O(1)
          T first = _queue.getValue();
          _queue = _queue.getNext();
          _queueSize--;
          return first;
     }

     //means of adding an element to collection:
     //Enqueue an element onto the back of this queue.
     public void enqueue( T x ){ // O(n) to traverse through the _queue
          if (this.isEmpty()){
               _queue = new LLNode<T>(x, null);
          }
          else{
               LLNode<T> current = _queue;
               while (current != null){
                    if (current.getNext() == null){
                         current.setNext(new LLNode(x, null));
                         break;
                    }
                    else{
                         current = current.getNext();
                    }
               }
          }
          _queueSize++;
     }

     //Returns true if this queue is empty, otherwise returns false.
     public boolean isEmpty(){ // O(1)
          return _queueSize == 0;
     }

     //Returns the first element of the queue without dequeuing it.
     public T peekFront(){ O(1)
          return _queue.getValue();
     }

     public static void main(String [] args){
          Queue<String> iPhoneLine = new NodeQueue<String>();
          iPhoneLine.enqueue("Bee Gee");
          System.out.println("Look at who's waiting for the iPhone XI! It's " + iPhoneLine.peekFront());
          iPhoneLine.enqueue("Bon Java");
          iPhoneLine.enqueue("POST Request Malone");
          iPhoneLine.enqueue("Editor Sheeran");
          System.out.println(iPhoneLine.dequeue() + " just got the new iPhoneXI!");
          System.out.println(iPhoneLine.dequeue() + " just got the new iPhoneXI!");
          System.out.println(iPhoneLine.dequeue() + " just got the new iPhoneXI!");
          System.out.println(iPhoneLine.dequeue() + " just got the new iPhoneXI!");
          System.out.println("Is the line for the iPhone XI empty? " + iPhoneLine.isEmpty());
     }
}
