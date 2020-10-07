package problems;

/**
 * n = nth ugly number
 * Time Complexity : O(n)
 * Space complexity : O(n)
 */
public class UglyNumbers {

  private static int findNthUglyNumber(int n) {
    int[] uglyNumbers = new int[n];
    uglyNumbers[0] = 1;

    int counter2 = 0, counter3 = 0, counter5 = 0;
    for(int i = 1; i < n; i++) {
      int value2 = uglyNumbers[counter2] * 2;
      int value3 = uglyNumbers[counter3] * 3;
      int value5 = uglyNumbers[counter5] * 5;
      int nextValue = Math.min(Math.min(value2, value3), value5);
      uglyNumbers[i] = nextValue;
      if(nextValue == value2) counter2++;
      if(nextValue == value3) counter3++;
      if(nextValue == value5) counter5++;
    }

    return uglyNumbers[n - 1];
  }

  public static void main(String[] args) {
    System.out.println(findNthUglyNumber(150));
    //Expected ans = 5832
  }
}
