// Team ScrombleTongs (Kayli Matsuyoshi and Johnny Wong)
// APCS2 pd1
// HW 23 -- Give and Take
// 2018-03-23

public class LList implements List{
     // inst vars
     private LLNode _head;
     private int _size;

     // constructor
     public LList(){
          _head = new LLNode();
          _size = 0;
     }

     //add node to list, containing input String as its data
     // this version adds to the front of the LList
     public boolean add( String x ){
          if (_size == 0){
               _head = new LLNode(x);
          }
          else{
               _head = new LLNode(x, _head);
          }
          _size++;
          return true;
     }

     //insert a node containing newVal at position index
     public void add( int index, String newVal ){
          if (index < 0 || index > _size){
               throw new IndexOutOfBoundsException();
          }
          // if you want to add to front of LList
          if (index == 0){
               add(newVal);
               return;
          }
          LLNode temp = _head;
          // iterate until you are one index away from inputted index
          for (int i = 0; i < index - 1; i++){
               temp = temp.getNext();
          }
          // insert LLNode with cargo newVal at inputted index that points to
          // previous LLNode at inputted index
          temp.setNext(new LLNode(newVal, temp.getNext()));
          _size++;

     }


     //remove node at pos index, return its cargo
     public String remove( int index ){
          if (index < 0 || index > _size){
               throw new IndexOutOfBoundsException();
          }
          String removed = get(index);
          LLNode temp = _head;
          // iterate until you are one index away from inputted index
          for (int i = 0; i < index - 1; i++){
               temp = temp.getNext();
          }
          // skip LLNode at inputted index - leave it for garbage
          // point to LLNode after inputted index
          temp.setNext(temp.getNext().getNext());
          _size--;
          return removed;
     }


     //return data in element at position i
     public String get( int i ){
          if (_size == 0){
               throw new IndexOutOfBoundsException();
          }
          LLNode old = _head;
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
          if (_size == 0){
               throw new IndexOutOfBoundsException();
          }
          LLNode old = _head;
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
         LLNode temp = _head; //init tr
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
