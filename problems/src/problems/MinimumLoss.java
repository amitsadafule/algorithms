package problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/minimum-loss/problem
 * n = number of items in price
 * Time Complexity : O( nlogn )
 * Space complexity : O(n)
 */
public class MinimumLoss {

  static int minimumLoss(long[] price) {

    TreeSet<Long> tree = new TreeSet<>();
    Map<Long, Integer> indexList = new HashMap<>();

    for(int index = 0; index < price.length; index++) {
      tree.add(price[index]);
      indexList.put(price[index], index);
    }

    Iterator<Long> iterator = tree.descendingIterator();
    long min = Long.MAX_VALUE;
    Long lastValue = null;
    while(iterator.hasNext()) {
      Long element = iterator.next();
      if(lastValue == null) {
        lastValue = element;
        continue;
      }

      long diff = lastValue - element;
      if(diff < min && indexList.get(lastValue) < indexList.get(element)) {
        min = diff;
      }
      lastValue = element;
    }

    return (int) min;

  }

  public static void main(String[] args) {

    /*long[] arr = {5, 10, 3};
    //Expected ans = 2*/

    /*long[] arr = {20, 7, 8, 2, 5};
    //Expected ans = 2*/

    /*long[] arr = {20, 17, 13, 12, 2, 4};
    //Expected ans = 1*/

    long[] arr = {11, 34, 24, 54};
    //Expected ans = 10

    int ans = minimumLoss(arr);
    System.out.println(ans);
  }
}
