package problems;

import ds.MinHeap;

/**
 * Time Complexity : Construction of min heap O(n log n) + finding kth element O(k log n) = O(n log n)
 * Space complexity : O(n)
 */
public class KthSmallestElement {

  public static void main(String[] args) {
    int[] array = new int[]{2, 7, 6, 32, 2, 5, 23};

    MinHeap minHeap = new MinHeap(array);
    int k = 3;
    int output = -1;
    for(int i = 0; i < k; i++) {
      output = minHeap.deleteAt(0);
    }

    System.out.println("Kth Smallest Element is " + output);
  }
}
