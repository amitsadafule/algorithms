package problems;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor/problem?h_r=next-challenge&h_v=zen
 * n = number of items in arr
 * Time Complexity : O(n)
 * Space complexity : O(n)
 */
public class IcecreamParlor {

  private static int[] icecreamParlor(int m, int[] arr) {
    Map<Integer, Integer> history = new HashMap<>();

    for(int index = 0; index < arr.length; index++) {
      Integer part = history.get(m - arr[index]);
      if(part != null) {
        return new int[] {part + 1, index + 1};
      }
      history.put(arr[index], index);
    }
    return new int[] {0, 0};
  }

  public static void main(String[] args) {

    /*int m = 4;
    int[] arr = {1, 4, 5, 3, 2};
    //Expected ans = 1, 4*/

    int m = 4;
    int[] arr = {2, 2, 4, 3};
    //Expected ans = 1, 2

    int[] ans = icecreamParlor(m, arr);
    System.out.println(ans[0] + " " + ans[1]);
  }
}
