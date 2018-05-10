// ScrombleTongs ( Kayli Matsuyoshi and Johnny Wong )
// APCS2 pd1
// HW46 -- Arrr, There Be Priorities Here Matey
// 2018-05-10t

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

     // INSTANCE VARIABLES
     private ArrayList<String> _data;
     private int _size;

     // CONSTRUCTOR(S)
     public ArrayPriorityQueue() {
          _data = new ArrayList<String>();
          _size = 0;
     }

     // METHODS

     // Adds an item to this priority queue.
     public void add( String s ) {
          _data.add(s);
          _size++;
     }

     // Returns true if this stack is empty, otherwise returns false.
     public boolean isEmpty() {
          return _size == 0;
     }

     // Returns the smallest item stored in this priority queue without removing it.
     public String peekMin() {
          String min = _data.get(0);
          int i = 1;
          while ( i < _size ) {
               if ( _data.get(i).length() < min.length() ) {
                    min = _data.get(i);
               }
               i++;
          }
          return min;
     }

     // Removes and returns the smallest item stored in this priority queue.
     public String removeMin() {
          String min = _data.get(0);
          int i = 1;
          while ( i < _size ) {
               if ( _data.get(i).length() < min.length() ) {
                    min = _data.get(i);
               }
               i++;
          }

          i = 0;
          while ( i < _size ) {
               if ( _data.get(i).equals( min ) ) {
                    break;
               }
               i++;
          }
          _size--;
          return _data.remove(i);
     }

     // MAIN METHOD
     public static void main( String[] args ) {

          System.out.println( "...INITIATING TESTING..." );

          System.out.println( "...testing default constructor..." );
          ArrayPriorityQueue scromble = new ArrayPriorityQueue();

          System.out.println( "...testing add()..." );
          scromble.add("all");
          scromble.add("women");
          scromble.add("are");
          scromble.add("queens");

          System.out.println( "...testing peekMin()..." );
          System.out.println( scromble.peekMin() ); // are

          System.out.println( "...testing isEmpty()..." );
          System.out.println( scromble.isEmpty() ); // false

          System.out.println( "...testing removeMin()..." );
          System.out.println( scromble.removeMin() ); // all
          System.out.println( scromble.removeMin() ); // are
          System.out.println( scromble.removeMin() ); // women
          System.out.println( scromble.removeMin() ); // queens

          System.out.println( "...testing isEmpty()..." );
          System.out.println( scromble.isEmpty() ); // true

          System.out.println( "...TERMINATING TESTING..." );
     }


} // end class ArrPQ
