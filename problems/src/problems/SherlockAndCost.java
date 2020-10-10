package problems;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-cost/problem
 * Explanation:
 * At Each place i, to variables,
 * 1. low = keeps sum of differences till i - 1 places, considering value of (i - 1)th place as 1
 * 2. high = keeps sum of differences till i - 1 places, considering value of (i - 1)th place as B[i]
 * new high and low for ith position will be
 * low[i] (considering this place as 1) = max( hi[i-1] + current_high_to_low_diff, low[i - 1] + 0)
 *     // 0 because we are considering ith place as 1 hence diff between i - 1 place (considering it as 1) and i place = 0
 * high[i] (considering this place as B[i]) = max(low[i - 1] + current_low_to_high_diff, high[i - 1] + current_high_to_high_diff)
 *
 * Time Complexity : O(n)
 * Space complexity : O(1)
 */
public class SherlockAndCost {

  private static int findCost(int[] B) {
    int low = 0, high = 0;
    for(int index = 1; index < B.length; index++) {
      int current_low_to_high_diff = Math.abs(1 - B[index]);
      int current_high_to_low_diff = Math.abs(B[index - 1] - 1);
      int current_high_to_high_diff = Math.abs(B[index - 1] - B[index]);

      int current_low = Math.max(high + current_high_to_low_diff, low); // low + 0 = low
      int current_high = Math.max(low + current_low_to_high_diff, high + current_high_to_high_diff);

      low = current_low;
      high = current_high;
    }

    return Math.max(low, high);
  }

  public static void main(String[] args) {

    /*int[] B = {10, 1, 10, 1, 10};
    //Expected output = 36*/

    int[] B = {100, 2, 100, 2, 100};
    //Expected output = 396

    System.out.println(findCost(B));
  }
}
