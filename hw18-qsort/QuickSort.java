//Johnny Wong
//APCS2 pd1
//HW18 -- So So Quick
//2018-03-13

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 *    Given an array,
 *    partition the initial array to place the pivot into
 *    its final resting position. Recursively sort the partitions
 *    to the left and right of the pivot using the same
 *    partition method.
 *
 * 2a. Worst pivot choice and associated runtime:
 *    If the pivot choice was always the smallest number in
 *    each partition, then there would be no left partition to sort.
 *    There would only be the right partition to sort, causing
 *    the sort to be O(n*n).
 *
 * 2b. Best pivot choice and associated runtime:
 *    The pivot is either the median or left or right bound of the
 *    given array. The median would be good as there would be
 *    approximately the same amount of elements unsorted
 *    in each partition after the initial swap to place
 *    the pivot in its final resting position. The runtime
 *    would be O(nlogn), similar to mergeSort.
 *
 * 3. Approach to handling duplicate values in array:
 *    Duplicate values should already be handled in qsort.
 *    Values less than or greater than the pivot are shifted.
 *    If one item is equal to the pivot, the other items
 *    shift around till they are in their proper partitions.
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

  // swap method given inputted array and two indexes
public static void swap( int[] arr, int i, int j ){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
}

  // return index of final resting position of pvtPos if array was sorted
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


  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * wrapper function of qsort(int[] arr, int left, int right)
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
  {
       if (d.length < 2){
            return;
       }
       qsort(d, 0, d.length - 1);
  }

  //you may need a helper method...
  // recursive solution to qsort
  public static void qsort(int[] arr, int left, int right){
       if (left < right){
            // partitionIndex is the index of the pivot that is at it's sorted location
            int partitionIndex = partition(arr, left, right, right); // partition the entire array arr
            // recursively sort elements before and after the sorted value
            qsort(arr, left, partitionIndex - 1); // sort the left partition of the sorted value
            qsort(arr, partitionIndex + 1, right); // sort the right partition of the sorted value
       }
 }

  //main method for testing
  public static void main( String[] args )
  {


    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/




    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
