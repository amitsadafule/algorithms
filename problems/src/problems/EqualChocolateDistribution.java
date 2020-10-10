package problems;

/**
 * https://www.hackerrank.com/challenges/equal/problem
 * n = number of colleagues
 * Time Complexity : O(n)
 * Space complexity : O(1)
 *
 */
public class EqualChocolateDistribution {

  private static int equal(int[] arr) {
    int minimumValue = Integer.MAX_VALUE;
    for(int element : arr) {
      if(element < minimumValue) minimumValue = element;
    }

    int minOperations = Integer.MAX_VALUE;
    //why to use base ? Explanation : https://www.youtube.com/watch?v=rdlzz2GOcq4&feature=youtu.be&ab_channel=code_report
    for(int base = 0; base < 5; base++) {
      int currentOperations = 0;
      for(int element : arr) {
        int minWithBase = element - minimumValue + base;
        currentOperations += minWithBase / 5;
        minWithBase = minWithBase % 5;

        currentOperations += minWithBase / 2;
        minWithBase = minWithBase % 2;

        currentOperations += minWithBase;
      }

      if(currentOperations < minOperations) minOperations = currentOperations;
    }

    return minOperations;
  }

  public static void main(String[] args) {
    /*int[] arr = {1, 5, 4};
    //Expected output = 4*/

    /*int[] arr = {0, 4, 4};
    //Expected output = 3*/

    int[] arr = {2, 6, 6, 6};
    //Expected output = 4

    System.out.println(equal(arr));
  }
}
