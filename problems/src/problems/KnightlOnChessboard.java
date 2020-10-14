package problems;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.hackerrank.com/challenges/knightl-on-chessboard/problem
 * n = width or length of chess board
 * Time Complexity : O(n*n*n*n)
 * Space complexity : O(n*n)
 */
public class KnightlOnChessboard {

  static int[][] adj(int x, int y, int l1, int l2) {
    return new int[][] {
      {x + l1, y + l2},
      {x + l1, y - l2},
      {x - l1, y + l2},
      {x - l1, y - l2},
      {x + l2, y + l1},
      {x + l2, y - l1},
      {x - l2, y + l1},
      {x - l2, y - l1}
    };
  }

  static class Place {
    int x;
    int y;
    int depth;
    Place(int x, int y, int depth) {
      this.x = x;
      this.y = y;
      this.depth = depth;
    }
  }

  static int findWays(int x, int y, int n, int[][] memory) {

    if(memory[x][y] != 0) return memory[x][y];

    boolean[][] visited = new boolean[n][n];
    Queue<Place> queue = new LinkedList<Place>();
    queue.add(new Place(0, 0, 0));

    while(queue.size() > 0) {

      Place place = queue.poll();
      if(place.x == n - 1 && place.y == n - 1) {
        memory[place.x][place.y] = place.depth;
        memory[place.y][place.x] = place.depth;
        return place.depth;
      }
      visited[place.x][place.y] = true;

      for(int[] neighbour : adj(place.x, place.y, x + 1, y + 1)) {
        if(neighbour[0] < 0 || neighbour[0] >= n || neighbour[1] < 0 || neighbour[1] >= n) continue;
        if(visited[neighbour[0]][neighbour[1]]) continue;
        visited[neighbour[0]][neighbour[1]] = true;
        queue.add(new Place(neighbour[0], neighbour[1], place.depth + 1));
      }
    }

    memory[x][y] = -1;
    memory[y][x] = -1;

    return -1;

  }

  static int[][] knightlOnAChessboard(int n) {
    int[][] output = new int[n - 1][n - 1];
    int[][] memory = new int[n][n];
    for(int index = 0; index < n; index++) {
      for(int innerIndex = 0; innerIndex < n; innerIndex++) {
        if(index >= n - 1 || innerIndex >= n - 1) continue;
        output[index][innerIndex] = findWays(index, innerIndex, n, memory);
      }
    }
    return output;
  }

  public static void main(String[] args) throws IOException {

    //int n = 5;
    //Expected output =
    /*4 4 2 8
    4 2 4 4
    2 4 -1 -1
    8 4 -1 1*/

    int n = 13;
    //Expected output =
    /*12 8 6 8 4 4 8 12 6 20 2 24
    8 6 6 4 10 4 12 8 12 2 12 12
    6 6 4 8 6 4 8 8 2 8 8 8
    8 4 8 3 8 4 12 2 36 16 -1 3
    4 10 6 8 -1 4 2 -1 -1 -1 -1 -1
    4 4 4 4 4 2 4 4 4 4 4 4
    8 12 8 12 2 4 -1 -1 -1 -1 -1 -1
    12 8 8 2 -1 4 -1 -1 -1 -1 -1 -1
    6 12 2 36 -1 4 -1 -1 -1 -1 -1 -1
    20 2 8 16 -1 4 -1 -1 -1 -1 -1 -1
    2 12 8 -1 -1 4 -1 -1 -1 -1 -1 -1
    24 12 8 3 -1 4 -1 -1 -1 -1 -1 1*/

    int[][] result = knightlOnAChessboard(n);

    for(int[] i : result) {
      for(int j : i) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}
