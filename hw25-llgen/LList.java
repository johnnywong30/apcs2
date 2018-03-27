// Johnny Wong
// APCS2 pd1
// HW 25 -- Generically Speaking...
// 2018-03-27

public class LList implements List<String>{
     // inst vars
     private DLLNode _head;
     private DLLNode _tail;
     private int _size;

     // constructor
     public LList(){
          _head = _tail = new DLLNode();
          _size = 0;
     }

     //add node to list, containing input String as its data
     public boolean add( String x ){
          if (_size == 0){
               _head = new DLLNode(x);
               _tail = _head;
          }
          else if(_size == 1){
               _tail = _head;
               _tail.setNext(null);
               _head = new DLLNode(x, _tail, null);
          }
          else{
               DLLNode temp = _head;
               _head = new DLLNode(x, temp, null);
          }
          _size++;
          return true;
     }

     //insert a node containing newVal at position index
     public void add( int index, String newVal ){
          if (index < 0 || index > _size){
               throw new IndexOutOfBoundsException();
          }
          if (index == 0){
               add(newVal);
               return;
          }
          DLLNode temp = _head;
          for (int i = 0; i < index - 1; i++){
               temp = temp.getNext();
          }
          temp.setNext(new DLLNode(newVal, temp.getNext(), temp));
          _size++;
     }


     //remove node at pos index, return its cargo
     public String remove( int index ){
          if (index < 0 || index >= _size){
               throw new IndexOutOfBoundsException();
          }
          if (index == 0){
               _head = _head.getNext();
               _head.setPrev(null);
               return this.get(0);
          }
          String removed;
          DLLNode temp = _head;
          for (int i = 0; i < index - 1; i++){
               temp = temp.getNext();
          }
          removed = temp.getNext().getCargo();
          temp.setNext(temp.getNext().getNext());
          temp.getNext().getNext().setPrev(temp);
          _size--;
          return removed;
     }


     //return data in element at position i
     public String get( int i ){
          if (i < 0 || i >= _size){
               throw new IndexOutOfBoundsException();
          }
          DLLNode old = _head;
          for (int j = 0; j < i; j++){
               old = old.getNext();
               if (old == null){
                    throw new IndexOutOfBoundsException();
               }
          }
          return old.getCargo();
     }

     //overwrite data in element at position i
     public String set( int i, String x ){
          if (i < 0 || i >= _size){
               throw new IndexOutOfBoundsException();
          }
          DLLNode old = _head;
          for (int j = 0; j < i; j++){
               old = old.getNext();
               if (old == null){
                    throw new IndexOutOfBoundsException();
               }
          }
          String prev = get(i);
          old.setCargo(x);
          return prev;
     }

     //return length of list
     public int size(){
          return _size;
     }

     // override inherited toString
     public String toString() {
          String retStr = "head--";
          DLLNode temp = _head; //init tr
          while( temp != null ) {
               retStr += temp.getCargo() + "--";
               temp = temp.getNext();
          }
          retStr += "NULL";
          return retStr;
     }

     public static void main(String[] args){
          LList wongton = new LList();
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.add("moo");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.add("coo");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.set(0, "bloo");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.add("blob");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.add(2, "boo");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.remove(1);
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());
     }
}
