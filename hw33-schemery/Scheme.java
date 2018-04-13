// Johnny Wong
// APCS2 -- pd1
// HW33 -- What a Racket
// 2018-04-13

/*****************************************************
* class Scheme
* Simulates a rudimentary Scheme interpreter
*
* ALGORITHM for EVALUATING A SCHEME EXPRESSION:
*   1. Place entire inputted expression into a Stack.
*   2. Pop while storing/remembering each item until most inner expression is found.
*   3. Unload most inner expression and replace it with its returned value.
*   4. Continue until all parens are accounted for and evaluated.
*   5. Profit!
*
* STACK OF CHOICE: LLStack
* b/c its methods have a constant runtime.
******************************************************/

public class Scheme
{
     /******************************************************
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
     // Debug:
     // THIS ONLY WORKS FOR SINGLE PAREN EXPRESSIONS CURRENTLY :<
     // NEED TO ADDRESS STARTING FROM TOP OF STACK AND INCLUDING OUTTER VALUES AGAIN
     public static String evaluate( String expr )
     {
          String[] expression = expr.split("\\s+");
          Stack<String> stack = new LLStack<String>();
          for (String str: expression){
               stack.push(str);
          }
          Stack<String> currentEval = new LLStack<String>();
          String storeMe = "";
          boolean finishedWithCurrent = false;
          while(!stack.isEmpty()){
               if (stack.peek().equals(")") && !finishedWithCurrent){
                    storeMe = " " + stack.pop() + storeMe;
                    finishedWithCurrent = false;
               }
               else if (isNumber(stack.peek())){
                    currentEval.push(stack.pop());
               }
               else if (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*")){
                    if (stack.peek().equals("+")){
                         stack.pop();
                         stack.pop();
                         stack.push(unload(1, currentEval));
                    }
                    else if (stack.peek().equals("-")){
                         stack.pop();
                         stack.pop();
                         stack.push(unload(2, currentEval));
                    }
                    if (stack.peek().equals("*")){
                         stack.pop();
                         stack.pop();
                         stack.push(unload(3, currentEval));
                    }
               }
          }
          return currentEval.pop();



     }//end evaluate()


     /******************************************************
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
     public static String unload( int op, Stack<String> numbers )
     {
          if (op == 1){
               int sum = 0;
               while(!numbers.isEmpty()){
                    sum += Integer.parseInt(numbers.pop());
               }
               return new Integer(sum).toString();
          }
          else if (op == 2){
               int subtractMe = Integer.parseInt(numbers.pop());
               int current;
               int difference = 0;
               while(!numbers.isEmpty()){
                    current = Integer.parseInt(numbers.pop());
                    if (numbers.isEmpty()){
                         difference = current - subtractMe;
                    }
                    else{
                         subtractMe += current;
                    }
               }
               return new Integer(difference).toString();
          }
          else if (op == 3){
               int product = Integer.parseInt(numbers.pop());
               while(!numbers.isEmpty()){
                    product *= Integer.parseInt(numbers.pop());
               }
               return new Integer(product).toString();
          }
          else{
               System.out.println("Invalid operation...");
               return null;
          }
     }//end unload()



     //optional check-to-see-if-its-a-number helper fxn:
     public static boolean isNumber( String s ) {
          try {
               Integer.parseInt(s);
               return true;
          }
          catch( NumberFormatException e ) {
               return false;
          }
     }



     //main method for testing
     public static void main( String[] args )
     {


          String zoo1 = "( + 4 3 )";
          System.out.println(zoo1);
          System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
          //...7

          String zoo2 = "( + 4 ( * 2 5 ) 3 )";
          System.out.println(zoo2);
          System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
          //...17

          String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
          System.out.println(zoo3);
          System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
          //...29

          String zoo4 = "( - 1 2 3 )";
          System.out.println(zoo4);
          System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
          //...-4
          /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
     }//main

}//end class Scheme
