package problems;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/?ref=rp
 * n = total items
 * Time Complexity : O(n*n)
 * Space complexity : O( n(n+1)/2 ) = O(n)
 *
 */

class Info {
  int totalVal;
  int totalWt;
  Info(int totalVal, int totalWt) {
    this.totalVal = totalVal;
    this.totalWt = totalWt;
  }
}
public class Knapsack01 {

  private static int findMaxValue(int[] val, int[] wt, int capacity) {
    Info[][] matrix = new Info[wt.length][wt.length];

    matrix[0][0] = new Info(val[0], wt[0]);
    for(int counter = 1; counter < wt.length; counter++) {
      for(int combinationCounter = 0; combinationCounter < counter; combinationCounter++) {
        Info previous = matrix[combinationCounter][counter - 1];
        if(previous.totalWt + wt[counter] > capacity) {
          matrix[combinationCounter][counter] = previous;
        } else {
          matrix[combinationCounter][counter] = new Info(previous.totalVal + val[counter], previous.totalWt + wt[counter]);
        }
      }
      matrix[counter][counter] = new Info(val[counter], wt[counter]);;
    }

    int max = -1;
    for(int counter = 0; counter < wt.length; counter++) {
      if(matrix[counter][wt.length - 1].totalVal > max) {
        max = matrix[counter][wt.length - 1].totalVal;
      }
    }

    return max;
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
    System.out.println(findMaxValue(val, wt, W));


  }
}
