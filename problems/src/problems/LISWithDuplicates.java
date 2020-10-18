package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-using-dynamic-programming/
 */
public class LISWithDuplicates {

  /**
   * Time Complexity : O(n*n)
   * Space complexity : O(n)
   * @param sequence
   * @return
   */
  private static int lengthOfLIS(int[] sequence) {

    int[] lis = new int[sequence.length];
    lis[0] = 1;
    for(int index = 1; index < sequence.length; index++) {
      lis[index] = 1;
      for(int j = 0; j < index; j++) {
        if(sequence[index] > sequence[j] && lis[j] + 1 > lis[index]) {
          lis[index] = lis[j] + 1;
        }
      }
    }
    return lis[sequence.length - 1];
  }

  public static void main(String[] args) {
    int[] sequence = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    //Expected length = 6
    //Expected lis = 10, 22, 33, 50, 60, 80

    /*int[] sequence = {10, 22, 9, 12, 21, 50, 51, 60, 80};
    //Expected ans = 7
    //Expected lis = 9, 12, 21, 50, 51, 60, 80*/

    /*int[] sequence = {50, 40, 23, 1};
    //Expected ans = 1
    //Expected lis = [50]*/

    /*int[] sequence = {50, 40, 1, 3, 2};
    //Expected ans = 2
    //Expected lis = [1, 3] or [1, 2]*/

    /*int[] sequence = {50, 40, 1, 3, 2, 3};
    //Expected ans = 3
    //Expected lis = [1, 2, 3]*/

    System.out.println(lengthOfLIS(sequence));
    //System.out.println(lis(sequence));
  }
}
