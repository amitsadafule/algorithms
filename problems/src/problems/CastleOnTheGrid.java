package problems;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/castle-on-the-grid/problem
 * n = number of points
 * m = number of points rows or columns (=sqrt(n))
 * Time Complexity : O(n*m)
 * Space complexity : O(n*m)
 */
public class CastleOnTheGrid {

  static class Position {
    final int depth, i, j;

    Position(int i, int j, int depth) {
      this.depth = depth;
      this.i = i;
      this.j = j;
    }
  }

  private static Set<List<Integer>> adj(int x, int y, String[] grid) {

    Set<List<Integer>> output = new HashSet<>();
    for(int index = x; index < grid.length; index++) {
      if(grid[index].charAt(y) == 'X') break;
      output.add(Arrays.asList(index, y));
    }

    for(int index = x; index >= 0; index--) {
      if(grid[index].charAt(y) == 'X') break;
      output.add(Arrays.asList(index, y));
    }

    for(int index = y; index >= 0; index--) {
      if(grid[x].charAt(index) == 'X') break;
      output.add(Arrays.asList(x, index));
    }

    for(int index = y; index < grid.length; index++) {
      if(grid[x].charAt(index) == 'X') break;
      output.add(Arrays.asList(x, index));
    }
    //No diagonal travel support
/*

    for(int indexX = x, indexY = y; indexX < grid.length && indexY >= 0; indexX++, indexY--) {
      if(grid[indexX].charAt(indexY) == 'X') break;
      output.add(Arrays.asList(indexX, indexY));
    }

    for(int indexX = x, indexY = y; indexX < grid.length && indexY < grid.length; indexX++, indexY++) {
      if(grid[indexX].charAt(indexY) == 'X') break;
      output.add(Arrays.asList(indexX, indexY));
    }

    for(int indexX = x, indexY = y; indexX >= 0 && indexY < grid.length; indexX--, indexY++) {
      if(grid[indexX].charAt(indexY) == 'X') break;
      output.add(Arrays.asList(indexX, indexY));
    }

    for(int indexX = x, indexY = y; indexX >= 0 && indexY >= 0; indexX--, indexY--) {
      if(grid[indexX].charAt(indexY) == 'X') break;
      output.add(Arrays.asList(indexX, indexY));
    }
*/

    return output;
  }

  static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

    if(grid[startX].charAt(startY) == 'X') return 0;

    Queue<Position> queue = new LinkedList<>();
    boolean visited[][] = new boolean[grid.length][grid.length];
    queue.add(new Position(startX, startY, 0));
    visited[startX][startY] = true;

    while(queue.size() > 0) {
      Position p = queue.poll();

      if(p.i == goalX && p.j == goalY) {
        return p.depth;
      }

      Set<List<Integer>> neighbours = adj(p.i, p.j, grid);
      int ub = -1, urb = -1, rb = -1, rbb = -1, bb = -1, lbb = -1, lb = -1, lub = -1;
      for(List<Integer> neighbor : neighbours) {
        //if(neighbor.get(0) < 0 || neighbor.get(1) < 0 || neighbor[0] >= grid.length || neighbor[1] >= grid.length) continue;
        if(visited[neighbor.get(0)][neighbor.get(1)]) continue;
        //if(grid[neighbor.get(0)].charAt(neighbor.get(1)) == 'X') continue;
        visited[neighbor.get(0)][neighbor.get(1)] = true;

        queue.add(new Position(neighbor.get(0), neighbor.get(1), p.depth + 1));
      }
    }

    return 0;
  }

  public static void main(String[] args) {

    /*String[] grid = {
      ".X.",
      ".X.",
      "..."
    };
    int startX = 0, startY = 0, goalX = 0, goalY = 2;
    //Expected output = 3*/

    /*String[] grid = {
      "....",
      "....",
      "..X.",
      "...."
    };
    int startX = 0, startY = 0, goalX = 3, goalY = 3;
    //Expected output = 2*/

    /*String[] grid = {
      "....",
      "...X",
      "X.X.",
      "...."
    };
    int startX = 0, startY = 0, goalX = 3, goalY = 3;
    //Expected output = 3*/

    /*String[] grid = {
      "....",
      ".X.X",
      "X.X.",
      "...."
    };
    int startX = 0, startY = 0, goalX = 3, goalY = 3;
    //Expected output = 3*/

    String[] grid = {
      ".....",
      "..XX.",
      ".X.X.",
      "X.XX.",
      "....."
    };
    int startX = 4, startY = 2, goalX = 2, goalY = 2;
    //Expected output = 0

    /*String[] grid = {
      "...X......XX.X...........XX....X.XX.....",
      ".X..............X...XX..X...X........X.X",
      "......X....X....X.........X...........X.",
      ".X.X.X..X........X.....X.X...X.....X..X.",
      "....X.X.X...X..........X..........X.....",
      "..X......X....X....X...X....X.X.X....XX.",
      "...X....X.......X..XXX.......X.X.....X..",
      "...X.X.........X.X....X...X.........X...",
      "XXXX..X......X.XX......X.X......XX.X..XX",
      ".X........X....X.X......X..X....XX....X.",
      "...X.X..X.X.....X...X....X..X....X......",
      "....XX.X.....X.XX.X...X.X.....X.X.......",
      ".X.X.X..............X.....XX..X.........",
      "..X...............X......X........XX...X",
      ".X......X...X.XXXX.....XX...........X..X",
      "...X....XX....X...XX.X..X..X..X.....X..X",
      "...X...X.X.....X.....X.....XXXX.........",
      "X.....XX..X.............X.XX.X.XXX......",
      ".....X.X..X..........X.X..X...X.X......X",
      "...X.....X..X.............X......X..X..X",
      "........X.....................X....X.X..",
      "..........X.....XXX...XX.X..............",
      "........X..X..........X.XXXX..X.........",
      "..X..X...X.......XX...X.....X...XXX..X..",
      ".X.......X..............X....X...X....X.",
      ".................X.....X......X.....X...",
      ".......X.X.XX..X.XXX.X.....X..........X.",
      "X..X......X..............X..X.X.......X.",
      "X........X.....X.....X....XX.......XX...",
      "X.....X.................X.....X..X...XXX",
      "XXX..X..X.X.XX..X....X.....XXX..X......X",
      "..........X.....X.....XX................",
      "..X.........X..X.........X...X.....X....",
      ".X.X....X...XX....X...............X.....",
      ".X....X....XX.XX........X..X............",
      "X...X.X................XX......X..X.....",
      "..X.X.......X.X..X.....XX.........X..X..",
      "........................X..X.XX..X......",
      "........X..X.X.....X.....X......X.......",
      ".X..X....X.X......XX...................."
    };
    int startX = 34, startY = 28, goalX = 16, goalY = 8;
    //Expected output = 9*/


    int result = minimumMoves(grid, startX, startY, goalX, goalY);

    System.out.println(result);

  }
}
