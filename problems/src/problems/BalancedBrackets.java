package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/equal-stacks/problem
 * n = length of string
 * Time Complexity : O(n)
 * Space complexity : O(n)
 */
public class BalancedBrackets {

  static String isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> opp = new HashMap<>();
    opp.put('}', '{');
    opp.put(')', '(');
    opp.put(']', '[');

    for(int index = 0; index < s.length(); index++) {
      char c = s.charAt(index);
      if(c == '{' || c == '(' || c == '[') stack.push(c);
      else if(c == '}' || c == ')' || c == ']'){
        if(stack.isEmpty()) return "NO";
        char topChar = stack.pop();
        if(topChar != opp.get(c)) return "NO";
      }
    }

    if(stack.isEmpty()) return "YES";
    return "NO";
  }

  public static void main(String[] args) {

    /*String s = "{[()]}";
    //Expected output = YES*/

    /*String s = "{[(])}";
    //Expected output = NO*/

    /*String s = "{{[[(())]]}}";
    //Expected output = YES*/

    String s = "{{()";
    //Expected output = NO

    System.out.println(isBalanced(s));
  }
}
