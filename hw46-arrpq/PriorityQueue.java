// ScrombleTongs ( Kayli Matsuyoshi and Johnny Wong )
// APCS2 pd1
// HW46 -- Arrr, There Be Priorities Here Matey
// 2018-05-10t

public interface PriorityQueue{

     // Adds an item to this priority queue.
     public void add( String s );

     // Returns true if this stack is empty, otherwise returns false.
     public boolean isEmpty();

     // Returns the smallest item stored in this priority queue without removing it.
     public String peekMin();

     // Removes and returns the smallest item stored in this priority queue.
     public String removeMin();
}
