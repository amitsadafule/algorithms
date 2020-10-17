package problems;

/**
 * https://www.hackerrank.com/challenges/truck-tour/problem
 * n = number of petrol pumps
 * Time Complexity : O(n)
 * Space complexity : O(1)
 */
public class TruckTour {

  private static int findPetrolPump(long[][] petrolPumps) {

    long petrol = 0;
    int output = -1;

    for(int index = 0; index < petrolPumps.length; index++) {
      if(output == -1) {
        petrol = petrolPumps[index][0] - petrolPumps[index][1];
        output = index;
      } else {
        petrol += (petrolPumps[index][0] - petrolPumps[index][1]);
      }

      if(petrol < 0) {
        output = -1;
      }
    }
    return output;
  }

  public static void main(String[] args) {

    /*long[][] petrolPumps = {
      {1, 5},
      {10, 3},
      {3, 4}
    };
    //Expected output = 1*/

    /*long[][] petrolPumps = {
      {1, 1},
      {10, 1},
      {3, 1}
    };
    //Expected output = 0*/

    long[][] petrolPumps = {
      {1, 1},
      {1, 2},
      {3, 1}
    };
    //Expected output = 2

    System.out.println(findPetrolPump(petrolPumps));
  }
}
