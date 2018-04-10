// Johnny Wong
// APCS2 -- pd1
// HW30 -- Stacks on Stacks on Stacks on Stacks…
// 2018-04-10

/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/
public class Latkes
{
  private String [] _stack;
  private int _stackSize;

  //constructor
  public Latkes( int size )
  {
       _stack = new String[size];
       _stackSize = 0;
  }

  //means of insertion
  public void push( String s ) // O(1)
  {
       if (isFull()){
            System.out.println("Stack is full. Unable to push " + s);
            return;
       }
       _stack[_stackSize] = s;
       _stackSize++;
  }

  //means of removal
  public String pop( ) // O(1)
  {
       if (_stackSize == 0){
            return null;
       }

       String removedString = _stack[_stackSize - 1];
       _stack[_stackSize - 1] = null;
       _stackSize--;
       return removedString;
  }

  //chk for emptiness
  public boolean isEmpty() // O(1)
  {
       return _stackSize == 0;
  }

  //chk for fullness
  public boolean isFull() // O(1)
  {
       return !(_stack[_stack.length - 1] == null);
  }


  //main method for testing
  public static void main( String[] args )
  {

      Latkes tastyStack = new Latkes(10);

      tastyStack.push("aoo"); // 1st item at index 0
      tastyStack.push("boo");
      tastyStack.push("coo");
      tastyStack.push("doo");
      tastyStack.push("eoo");
      tastyStack.push("foo");
      tastyStack.push("goo");
      tastyStack.push("hoo");
      tastyStack.push("ioo");
      tastyStack.push("joo"); // 10th item at index 9
      // _stackSize is now 10
      tastyStack.push("coocoo"); // can't push
      tastyStack.push("cachoo"); // can't push

      // //cachoo
      // System.out.println( tastyStack.pop() );
      //coocoo
      // System.out.println( tastyStack.pop() );

      //joo
      System.out.println( tastyStack.pop() );
      //ioo
      System.out.println( tastyStack.pop() );
      //hoo
      System.out.println( tastyStack.pop() );
      //goo
      System.out.println( tastyStack.pop() );
      //foo
      System.out.println( tastyStack.pop() );
      //eoo
      System.out.println( tastyStack.pop() );
      //doo
      System.out.println( tastyStack.pop() );
      //coo
      System.out.println( tastyStack.pop() );
      //boo
      System.out.println( tastyStack.pop() );
      //aoo
      System.out.println( tastyStack.pop() );

      //stack empty by now; SOP(null)
      System.out.println( tastyStack.pop() );
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
