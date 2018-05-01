// Johnny Wong
// APCS2 -- pd1
// HW34 -- The English Do Not Wait In Line
// 2018-04-16

public class NodeQueueDriver{
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
          System.out.println("Is the line for the iPhone XI empty? " + iPhoneLine.isEmpty()); // true
     }
}
