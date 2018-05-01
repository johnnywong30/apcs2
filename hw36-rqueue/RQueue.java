// Team Slippery Fingers -- Johnny Wong, Clarence Cheng
// APCS2 pd1
// HW36 -- Now Let’s Consider You Lot at Fake Terry’s
// 2018-04-18

/*****************************************************
* class RQueue
* A linked-list-based, randomized queue
* (a collection with FIIDKO property)
*
*       -------------------------------
*   end |  --->   Q U E U E   --->    | front
*       -------------------------------
*
*  linkages point opposite direction for O(1) en/dequeuing
*            N <- N <- ... <- N <- N
*      _end -^                     ^- _front
*
******************************************************/


public class RQueue<T> implements Queue<T>
{
     //instance variables
     private LLNode<T> _front, _end;
     private int _size;


     // default constructor creates an empty queue
     public RQueue()
     {
          _front = null;
          _end = null;
          _size = 0;
     }//end default constructor


     public void enqueue( T enQVal )
     {
          if (isEmpty()){
               _front = new LLNode<T>(enQVal, _end);
               _end = _front;
          }
          else if (_size == 1){
               _end = new LLNode<T>(enQVal, _front);
               _front.setNext(_end);
          }
          else{
               _end.setNext(new LLNode<T>(enQVal, _front));
               _end = _end.getNext();
          }
          _size++;
     }//end enqueue()


     // remove and return thing at front of queue
     // assume _queue ! empty
     public T dequeue()
     {
          int pew = (int)(Math.random() * 25 + Math.random() * 5);//random numero PEW
          for(int x = 0; x < pew; x++){
               _front = _front.getNext();
          }
          LLNode<T> phony = _front; //store the value before _front so you can bridge the chasm from dequeue
          _end = phony;//end is before front so therfore phony
          _front = _end.getNext();
          T bye = _front.getValue(); //stores the real _front to go bye bye
          _end.setNext(_front.getNext());
          _size--;
          return bye;
     }//end dequeue()


     public T peekFront()
     {
          return _front.getValue();
     }


     /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * Dequeue a random item and enqueue it back into the queue.
     * Occurs n times.
     * O(n)
     ******************************************/
     public void sample ()
     {
          for(int x = 0; x < _size; x++){
               T temp = dequeue();
               enqueue(temp);
          }

     }//end sample()


     public boolean isEmpty()
     {
          return _size == 0;
     } //O(1)


     // print each node, separated by spaces
     public String toString()
     {
          LLNode<T> current = _front;
          String ret = "_front -> ";
          for (int i = 0; i < _size; i++){
               ret += current;
               if (i != _size - 1){
                    ret += " -> ";
                    current = current.getNext();
               }
          }
          ret += " <- _end";
          return ret;

     }//end toString()



     //main method for testing
     public static void main( String[] args )
     {


          RQueue<String> PirateQueue = new RQueue<String>();

          System.out.println("\nnow enqueuing...");
          PirateQueue.enqueue("Dread");
          PirateQueue.enqueue("Pirate");
          PirateQueue.enqueue("Robert");
          PirateQueue.enqueue("Blackbeard");
          PirateQueue.enqueue("Peter");
          PirateQueue.enqueue("Stuyvesant");

          System.out.println("\nnow testing toString()...");
          System.out.println( PirateQueue ); //for testing toString()...

          System.out.println("\nnow dequeuing...");
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );

          System.out.println("\nnow dequeuing fr empty queue...");
          System.out.println( PirateQueue.dequeue() );
          /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

     }//end main

}//end class RQueue
