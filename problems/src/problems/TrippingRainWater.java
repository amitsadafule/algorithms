package problems;

/**
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * n = number of walls
 * Time Complexity : O(n)
 * Space complexity : O(1)
 */
public class TrippingRainWater {

  private static int harvestWater(int[] arr) {
    int low = 0, high = arr.length - 1;
    int leftHigh = arr[low], rightHigh = arr[high];
    int harvestedWaterQuantity = 0;
    while(low <= high) {
      if(leftHigh < rightHigh) {
        if(arr[low] > leftHigh) {
          leftHigh = arr[low];
        }
        else {
          harvestedWaterQuantity += leftHigh - arr[low];
        }
        low++;
      } else {
        if(arr[high] > rightHigh) {
          rightHigh = arr[high];
        }
        else {
          harvestedWaterQuantity += rightHigh - arr[high];
        }
        high--;
      }

      //System.out.println("Left high : " + leftHigh + ", Right  high : " + rightHigh + " at value : " +
      //  arr[low] + "; Harvested water : " + harvestedWaterQuantity);
    }
    return harvestedWaterQuantity;
  }

  public static void main(String[] args) {

    /*int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    //Expected output = 6*/

    /*int[] arr = {3, 0, 2, 0, 4};
    //Expected output = 7*/

    /*int[] arr = {1, 3, 5, 8, 3, 2};
    //Expected output = 0*/

    /*int[] arr = {1, 3, 5, 8};
    //Expected output = 0*/

    int[] arr = {10, 8, 3, 2};
    //Expected output = 0

    System.out.println(harvestWater(arr));
  }
}
