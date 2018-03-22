// Johnny Wong
// APCS2 pd1
// HW 16 -- About Face
// 2018-03-08

public class Mysterion {

     // swap method given inputted array and two indexes
     public static void swap( int[] arr, int i, int j ){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
     }

     /******************************************************************
     * This mystery function places the values less than the value at the inputted
     * index within the leftBound and rightBound of the inputted array to the left
     * of that index, and values greater to the right. When inputting an array that
     * is in descending order, this function swaps the values and makes the array to
     * be in ascending order.
     *
     * This function runs in O(n) time due to it processing in a linear operation.

     ******************************************************************/
     public static int descendingToAscending( int[] arr, int leftBound, int rightBound, int index){
          int comparedTo = arr[index];
          swap(arr, index, rightBound);
          int indexOfMax = leftBound;
          for (int i = leftBound; i < rightBound; i++){
               if (arr[i] < comparedTo){
                    swap(arr, indexOfMax, i);
                    indexOfMax += 1;
               }
          }
          swap(arr, rightBound, indexOfMax);
          return indexOfMax;
     }

     // return String representation of inputted array
     public static String strArray(int[] arr){
          String ret = "{";
          for (int item: arr){
               ret += item + ", ";
          }
          ret = ret.substring(0, ret.length() - 2) + "}";
          return ret;
     }

     public static void main (String [] args){
          int[] tester = {0,4,8,3,12};
          System.out.println(strArray(tester));
          //swap(tester, 5, 8);
          //System.out.println(strArray(tester));
          System.out.println(descendingToAscending(tester, 0, 4, 3));
          System.out.println(strArray(tester));
     }

}
