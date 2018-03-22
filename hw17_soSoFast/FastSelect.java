// Johnny Wong
// APCS2 pd1
// HW17 -- So So Fast
// 2018-03-12

public class FastSelect{
     // swap method given inputted array and two indexes
   public static void swap( int[] arr, int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
   }
   public static int partition( int[] arr, int left, int right, int pvtPos){
          int pvtVal = arr[pvtPos];
          swap(arr, pvtPos, right); // move pivot to end
          int storePos = left;
          for (int i = left; i < right; i++){
               if (arr[i] < pvtVal){
                    swap(arr, storePos, i);
                    storePos += 1;
               }
          }
          // move pivot back to final resting position -- pivot is sorted!
          swap(arr, right, storePos);
          return storePos;
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

     // sort method using partition
     public static void partitionSort(int[] arr, int left, int right){
          if (left < right){
               // partitionIndex is the index of the pivot that is at it's sorted location
               int partitionIndex = partition(arr, left, right, right); // partition the entire array arr
               // recursively sort elements before and after the sorted value
               partitionSort(arr, left, partitionIndex - 1); // sort the left partition of the sorted value
               partitionSort(arr, partitionIndex + 1, right); // sort the right partition of the sorted value
          }
     }
     /*
     Sort array arr using above partitionSort method.
     partitionSort sorts in O(nlogn) time, as it must traverse through each partition created after
     placing the last item in its final resting position.
     As a result, this method runs in O(nlogn) time, which is the same as mergeSort
     worstCase - greatest/least value is placed at the end, causing more than arr.length/2 + 1 partitions to be made
     bestCase - middle value placed at the end, causing arr.length/2 + 1 partitions to be made
     */
     public static int fastSelectMin(int[] arr, int y){
          if (arr.length < y){
               System.out.println("Array " + strArray(arr) + " has less than " + y + " elements.");
               return -1; // invalid input
          }
          partitionSort(arr, 0, arr.length - 1);
          // arr is now sorted
          return arr[y - 1];
     }
     public static void main(String [] args){
          // worst case since the least value is at the end, causing more than 3 partitions to be made
          int[] worstCase = {4,3,2,1,0};
          // best case since the middle is at the end and only 3 partitions have to be made
          int[] bestCase = {0,4,3,1,2};


          System.out.println("Third smallest element of " + strArray(bestCase) + " is " + fastSelectMin(bestCase, 3));
          System.out.println("Third smallest element of " + strArray(worstCase) + " is " + fastSelectMin(worstCase, 3));
     }
}
