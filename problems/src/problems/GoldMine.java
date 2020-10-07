package problems;

/**
 * https://www.geeksforgeeks.org/gold-mine-problem/
 * Time Complexity : O(n*m)
 * Space complexity : O(n*m)
 */
public class GoldMine {

  private static int findMaxGold(int[][] mines) {
    if(mines.length == 0) return 0;
    int rows = mines.length;
    int columns = mines[0].length;
    int[][] memory = new int[rows][columns];

    for(int row = 0; row < rows; row++) memory[row][0] = mines[row][0];

    for(int column = 1; column < columns; column++) {
      for(int row = 0; row < rows; row++) {
        int fromLeft = memory[row][column - 1];
        int fromTopLeft = 0;
        if(row - 1 >= 0) fromTopLeft = memory[row - 1][column - 1];
        int fromBottomLeft = 0;
        if(row + 1 < rows) fromBottomLeft = memory[row + 1][column - 1];
        memory[row][column] = Math.max(Math.max(fromLeft, fromTopLeft), fromBottomLeft) + mines[row][column];
      }
    }

    int max = 0;
    for(int row = 0; row < rows; row++) {
      if(max < memory[row][columns - 1]) max = memory[row][columns - 1];
    }

    return max;
  }

  public static void main(String[] args) {
    /*int[][] mines = {{1, 3, 3},
      {2, 1, 4},
      {0, 6, 4}};
    //output = 12*/

    /*int[][] mines = { {1, 3, 1, 5},
      {2, 2, 4, 1},
      {5, 0, 2, 3},
      {0, 6, 1, 2}};
    //output = 16*/

    int[][] mines = {{10, 33, 13, 15},
      {22, 21, 04, 1},
      {5, 0, 2, 3},
      {0, 6, 14, 2}};
    //output = 83
    System.out.println(findMaxGold(mines));
    //Expected ans = 5832
  }
}
