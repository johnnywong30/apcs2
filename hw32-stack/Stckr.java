// Johnny Wong
// APCS2 -- pd1
// HW32 -- Leon Leonwood Stack
// 2018-04-12

/*****************************************************
* class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
*****************************************************/

public class Stckr
{
     public static void populate(Stack x){
          String addToMe = "cake+";
          for (int i = 0; i < 10; i++){
               x.push(addToMe);
               addToMe += 1;
          }
     }
     public static void clear(Stack x){
          for (int i = 0; i < 10; i++){
               System.out.println("You eat: " + x.pop());
          }
     }

     public static void main( String[] args )
     {
          Stack<String> cakesAL = new ALStack<String>();
          Stack<String> cakesLL = new LLStack<String>();
          populate(cakesAL);
          populate(cakesLL);

          System.out.println("This is an ALStack of cake");
          clear(cakesAL);
          System.out.println("\n");
          System.out.println("This is an LLStack of cake");
          clear(cakesLL);
          System.out.println("\n");

          populate(cakesAL);
          populate(cakesLL);

          System.out.println("After eating them, the top of the ALStack in your stomach is " + cakesAL.peek());
          System.out.println("Is your stomach empty now? " + cakesAL.isEmpty());
          System.out.println("After eating them, the top of the LLStack in your stomach is " + cakesLL.peek());
          System.out.println("Is your stomach empty now? " + cakesLL.isEmpty());

     }//end main

}//end class
