package problems;

/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * n = number of items in arr
 * Time Complexity : O(n)
 * Space complexity : O(1)
 */
public class LargestSumContiguousSubArray {

  static private int findSum(int[] arr) {

    int maxSum = Integer.MIN_VALUE;
    int maxTillThis = 0;

    for(int element : arr) {
      maxTillThis = maxTillThis + element;
      if(maxSum < maxTillThis) {
        maxSum = maxTillThis;
      }
      if(maxTillThis < 0) {
        maxTillThis = 0;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {

    /*int[] arr = {2, 2, 4, 3};
    //Expected ans = 11*/

    /*int[] arr = {2, -1, 4, 3};
    //Expected ans = 8*/

   /* int[] arr = {-2, -3, 4, 1, -2, 1, 5, -3};
    //Expected ans = 7*/

    /*int[] arr = {-2, 1, 4, -1, -2, 1, 5, -3};
    //Expected ans = 8*/

    /*int[] arr = {-4, -3, -10};
    //Expected ans = -3*/

    int[] arr = {-4, -3, 1};
    //Expected ans = 1

    int ans = findSum(arr);
    System.out.println(ans);
  }
}
