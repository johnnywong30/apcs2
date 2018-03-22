// Johnny Wong
// APCS2 pd1
// HW 21b -- We Got a Little Ol’ Convoy...
// 2018-03-20

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String value;
    private LLNode next;

    // constructor
    public LLNode(){
         value = null;
         next = null;
    }

    public LLNode(String value){
         this.value = value;
         this.next = null;
    }

    public LLNode(String value, LLNode nextNode){
         this.value = value;
         this.next = nextNode;
    }

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
         return value;
    }

    public LLNode getNext()
    {
         return next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String cargo)
    {
         String old = value;
         value = cargo;
         return old;
    }

    public LLNode setNext(LLNode nextNode)
    {
         LLNode old = next;
         next = nextNode;
         return old;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
         if (next == null){
              return this.value;
         }
         return getCargo() + "--" + getNext().toString();
    }


    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...
     LLNode traversable = new LLNode("small");
     LLNode connected = new LLNode("big", traversable);
     System.out.println(connected.getCargo());
     System.out.println(traversable.getCargo());
     System.out.println(connected.toString());
     System.out.println(traversable.toString());
    }//end main

}//end class LLNode
