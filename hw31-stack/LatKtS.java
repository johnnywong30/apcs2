// Johnny Wong
// APCS2 -- pd1
// HW31 -- Stack: What Is It Good For?
// 2018-04-11


/*****************************************************
* skeleton for class LatKtS
* Driver class for Latkes.
* Uses a stack to reverse a text string, check for sets of matching parens.
*****************************************************/


public class LatKtS
{

     /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
     public static String flip( String s )
     {
          Latkes stack = new Latkes(s.length());
          for (int i = 0; i < s.length(); i++){
               stack.push(s.substring(i, i + 1));
          }
          String retStr = "";
          while(!stack.isEmpty()){
               retStr += stack.pop();
          }
          return retStr;

     }//end flip()


     /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
     /* ALGO:
     Scan the String and push each character into the Stack for every
     '(', '{', or '[' that is found.
     If an ending such as ')', '}', or ']' is found, pop the corresponding
     'opening character' in the pair.
     The stack will be empty by the end of this process if no errors are found.
     */
     public static boolean allMatched( String s )
     {
          if (s.equals("")){
               return true;
          }
          Latkes stack = new Latkes(s.length());
          String current;
          for (int i = 0; i < s.length(); i++){
               current = s.substring(i, i + 1);
               if (current.equals("(") || current.equals("{") || current.equals("[")){
                    stack.push(current);
               }
               if (current.equals(")") || current.equals("}") || current.equals("]")){
                    if (stack.isEmpty()){
                         return false;
                    }
                    String last = stack.peek();
                    if (current.equals(")") && last.equals("(") || current.equals("}") && last.equals("{") || current.equals("]") && last.equals("[")){
                         stack.pop();
                    }
                    else{
                         return false;
                    }
               }
          }
          return stack.isEmpty();
     }//end allMatched()


     //main method to test
     public static void main( String[] args )
     {

          System.out.println(flip("stressed"));
          System.out.println(allMatched( "({}[()])" )); //true
          System.out.println(allMatched( "([)]" ) ); //false
          System.out.println(allMatched( "(){([])}" ) ); //true
          System.out.println(allMatched( "](){([])}" ) ); //false
          System.out.println(allMatched( "(){([])}(" ) ); //false
          System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
          /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
     }

}//end class LatKtS
