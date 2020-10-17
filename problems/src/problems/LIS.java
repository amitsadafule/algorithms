package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-using-dynamic-programming/
 * Time Complexity : O(n*n)
 * Space complexity : O(n*n)
 * ****IMPORTANT Does not work with duplicate values
 */
public class LIS {

  private static int lengthOfLIS(int[] sequence) {

    int LISLength = 0;

    for(int index = 0; index < sequence.length; index++) {
      int currentMax = Integer.MIN_VALUE;
      int length = 0;
      for(int j = index; j < sequence.length; j++) {
        if(sequence[j] > currentMax) {
          currentMax = sequence[j];
          length++;
        }
        //System.out.print(currentMax + " ");
      }
      if(LISLength < length) {
        LISLength = length;
      }
    }
    return LISLength;
  }

  private static List<Integer> lis(int[] sequence) {

    List<Integer> lis = new LinkedList<>();
    for(int index = 0; index < sequence.length; index++) {
      int currentMax = Integer.MIN_VALUE;
      List<Integer> tempLIS = new LinkedList<>();
      for(int j = index; j < sequence.length; j++) {
        if(sequence[j] > currentMax) {
          currentMax = sequence[j];
          tempLIS.add(sequence[j]);
        }
        //System.out.print(currentMax + " ");
      }
      if(lis.size() < tempLIS.size()) {
        lis = tempLIS;
      }
    }
    return lis;
  }

  public static void main(String[] args) {
    /*int[] sequence = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    //Expected length = 6
    //Expected lis = 10, 22, 33, 50, 60, 80*/

    /*int[] sequence = {10, 22, 9, 12, 21, 50, 51, 60, 80};
    //Expected ans = 7
    //Expected lis = 9, 12, 21, 50, 51, 60, 80*/

    /*int[] sequence = {50, 40, 23, 1};
    //Expected ans = 1
    //Expected lis = [50]*/

    int[] sequence = {50, 40, 1, 3, 2};
    //Expected ans = 2
    //Expected lis = [1, 3] or [1, 2]

    /*int[] sequence = {50, 40, 1, 3, 2, 3}; //This input will give wrong answer
    //Expected ans = 3
    //Expected lis = [1, 2, 3]*/

    System.out.println(lengthOfLIS(sequence));
    System.out.println(lis(sequence));
  }
}
