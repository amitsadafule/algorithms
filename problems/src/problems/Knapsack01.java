package problems;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/?ref=rp
 * n = total items
 * W = capacity
 * Time Complexity : O(n*W)
 * Space complexity : O(n*W)
 *
 */

public class Knapsack01 {

  private static int solveKnapsack(int[] val, int[] wt, int capacity) {
    int[][] memory = new int[val.length + 1][capacity + 1];
    for(int row = 0; row < val.length + 1; row++) {
      for(int column = 0; column < capacity + 1; column++) {
        memory[row][column] = -1;
      }
    }

    return findMaxValue(val, wt, capacity, val.length, memory);
  }

  private static int findMaxValue(int[] val, int[] wt, int capacity, int pos, int[][] memory) {

    //System.out.println(capacity + ":" + pos);
    if(pos == 0 || capacity == 0)  return 0;
    if(memory[pos][capacity] != -1) return memory[pos][capacity];

    if(wt[pos - 1] > capacity) {
      memory[pos][capacity] = findMaxValue(val, wt, capacity, pos - 1, memory);
      return memory[pos][capacity];
    }

    int out = Math.max((val[pos - 1] +
      findMaxValue(val, wt, capacity - wt[pos - 1], pos - 1, memory)), //considering wt[pos - 1]
      findMaxValue(val, wt, capacity, pos - 1, memory)); //not considering wt[pos - 1]
    //System.out.println(capacity + ":" + pos + ":"  +out);
    //System.out.println("================");
    memory[pos][capacity] = out;
    return out;
  }

  public static void main(String[] args) {
    /*int[] val = new int[]{60, 100, 120};
    int[] wt = new int[]{10, 20, 30};
    int W = 50;*/
    //expected answer = 220

    int[] val = new int[]{20,5,10,40,15,25};
    int[] wt = new int[]{1,2,3,8,7,4};
    int W = 10;
    //expected answer = 60

    /*int[] val = new int[]{60, 100, 120, 50};
    int[] wt = new int[]{10, 20, 30, 40};
    int W = 40;*/
    //expected answer = 60
    System.out.println(solveKnapsack(val, wt, W));


  }
}
