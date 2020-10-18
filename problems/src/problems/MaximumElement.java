package problems;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

  private static class Node {
    private final int currentMax;
    private final int e;

    Node(int e, int currentMax) {
      this.e = e;
      this.currentMax = currentMax;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Stack<Node> stack = new Stack<>();

    for(int index = 0; index < n; index++) {
      int choice = sc.nextInt();
      if(choice == 1) {
        int e = sc.nextInt();
        if(stack.isEmpty()) {
          stack.push(new Node(e, e));
        } else {
          Node topE = stack.peek();
          stack.push(new Node(e, topE.currentMax < e ? e: topE.currentMax));
        }
      } else if(choice == 2) {
        stack.pop();
      } else if(choice == 3) {
        if(!stack.isEmpty()) {
          Node topE = stack.peek();
          System.out.println(topE.currentMax);
        }
      }
    }
    sc.close();
  }
}
