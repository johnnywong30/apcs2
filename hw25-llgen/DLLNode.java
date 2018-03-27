// Team ScrombleTongs (Kayli Matsuyoshi and Johnny Wong)
// APCS2 pd1
// HW 24a -- On the DLL
// 2018-03-26


/*****************************************************
* class DLLNode
* Implements a doubly-linked node,
* for use in lists and other collection classes.
* Stores data of type String
*****************************************************/

public class DLLNode
{
     // INSTANCE VARIABLES
     private String _cargo;    //cargo may only be of type String
     private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

     // CONSTRUCTORS
     public DLLNode() {
          _cargo = null;
          _nextNode = null;
          _prevNode = null;
     }

     public DLLNode( String cargoString ) {
          this();
          _cargo = cargoString;
     }

     public DLLNode( String cargoString, DLLNode next, DLLNode prev ) {
          this();
          _cargo = cargoString;
          _nextNode = next;
          _prevNode = prev;
     }

     // ACCESSORS
     public String getCargo() { return _cargo; }

     public DLLNode getNext() { return _nextNode; }

     public DLLNode getPrev() { return _prevNode; }

     // MUTATORS
     public String setCargo( String newCargo ) {
          String foo = getCargo();
          _cargo = newCargo;
          return foo;
     }

     public DLLNode setNext( DLLNode newNext ) {
          DLLNode foo = getNext();
          _nextNode = newNext;
          return foo;
     }

     public DLLNode setPrev( DLLNode newPrev ) {
          DLLNode foo = getPrev();
          _prevNode = newPrev;
          return foo;
     }

     // override inherited toString
     public String toString() { return _cargo.toString(); }

     //main method for testing
     public static void main( String[] args )
     {
          //PROTIP: try creating a few nodes: traversible, connected...
          //note anything notable as you develop and test...

          DLLNode zoo = new DLLNode("kayli");
          DLLNode mama = new DLLNode();
          DLLNode wee = new DLLNode( "wong", zoo, mama );
          System.out.println(zoo.setCargo( "johnny" ));
          System.out.println(mama.setCargo( "tong" ));
          System.out.println(mama.getCargo());
          System.out.println(zoo.setNext( wee ));
          System.out.println(wee.setNext( mama ));
          System.out.println(zoo.toString());
          System.out.println(wee.toString());

     }//end main


}//end class DLLNode
