package problems;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/gridland-metro/problem
 * k = number of routes/tracks
 * Time Complexity : O( klogk )
 * Space complexity : O(k)
 */
class TrainSourceDestination implements Comparable {
  final int s;
  final int r;

  TrainSourceDestination(int s, int r) {
    this.s = s;
    this.r = r;
  }

  @Override
  public String toString() {
    return "TrainSourceDestination{" +
      "s=" + s +
      ", r=" + r +
      '}';
  }

  @Override
  public int compareTo(Object o) {
    return this.s - ((TrainSourceDestination)o).s;
  }
}

public class GridLandMetro {

  // Complete the gridlandMetro function below.
  static long gridlandMetro(int n, int m, int k, int[][] track) {
    Map<Integer, PriorityQueue<TrainSourceDestination>> meta = new HashMap<>();

    for(int row = 0; row < k; row++) {
      PriorityQueue<TrainSourceDestination> trainSourceDestinations = meta.get(track[row][0]);
      if(trainSourceDestinations == null) trainSourceDestinations = new PriorityQueue<TrainSourceDestination>();
      trainSourceDestinations.add(new TrainSourceDestination(track[row][1], track[row][2]));
      meta.put(track[row][0], trainSourceDestinations);
    }

    //System.out.println("queues : " + meta);
    long output = 0;
    for(Map.Entry<Integer, PriorityQueue<TrainSourceDestination>> entrySet : meta.entrySet()) {
      long bookedBlocks = 0;
      PriorityQueue<TrainSourceDestination> queue = entrySet.getValue();
      int low = Integer.MAX_VALUE, high = 0;
      while(queue.size() > 0) {
        TrainSourceDestination poll = queue.poll();
        if(high != 0 && poll.s > high) {
          bookedBlocks += high - low + 1;
          low = poll.s;
          high = poll.r;
          continue;
        }
        if(poll.s < low) low = poll.s;
        if(poll.r > high) high = poll.r;
      }
      bookedBlocks += high - low + 1;
      output += m - bookedBlocks;
    }

    //Calculation where no station is present
    output += ((n - meta.size()) * (long)m);

    return output;
  }

  public static void main(String[] args) throws IOException {

    /*int n = 4, m = 4, k = 4;
    int[][] track = {
      {2, 2, 3},
      {3, 1, 4},
      {4, 4, 4},
      {4, 1, 2}
    };
    //Expected output = 7*/

    /*int n = 4, m = 4, k = 3;
    int[][] track = {
      {2, 2, 3},
      {3, 1, 4},
      {4, 4, 4}
    };
    //Expected output = 9*/

    /*int n = 4, m = 4, k = 4;
    int[][] track = {
      {2, 2, 3},
      {3, 1, 4},
      {4, 1, 3},
      {4, 2, 4}
    };
    //Expected output = 6*/

    /*int n = 4, m = 4, k = 4;
    int[][] track = {
      {1, 2, 3},
      {3, 1, 4},
      {2, 1, 3},
      {4, 2, 4}
    };
    //Expected output = 4*/

    int n = 4, m = 5, k = 7;
    int[][] track = {
      {1, 1, 2},
      {1, 4, 4},
      {2, 1, 2},
      {2, 2, 3},
      {2, 4, 5},
      {4, 1, 2},
      {4, 4, 5}
    };
    //Expected output = 8

    long result = gridlandMetro(n, m, k, track);

    System.out.println(result);

  }

/*
 To read it from path
  public static void main(String[] args) throws IOException {

    final Scanner scanner = new Scanner(new File("./extra-inputs-outputs/train_source_problem_input_1.txt"));
    String[] nmk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nmk[0]);

    int m = Integer.parseInt(nmk[1]);

    int k = Integer.parseInt(nmk[2]);

    int[][] track = new int[k][3];

    for (int i = 0; i < k; i++) {
      String[] trackRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 3; j++) {
        int trackItem = Integer.parseInt(trackRowItems[j]);
        track[i][j] = trackItem;
      }
    }

    long result = gridlandMetro(n, m, k, track);

    System.out.println(result);


    scanner.close();
  }*/
}
