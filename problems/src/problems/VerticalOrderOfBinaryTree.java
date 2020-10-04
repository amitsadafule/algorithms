package problems;

import ds.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Time Complexity : Scan for finding level and keeping sorted map O(n log n) + printing O(n) = O(n log n)
 * Space complexity : O(n)
 */
public class VerticalOrderOfBinaryTree {

  private static void printVerticalOrder(Node<Integer> root) {

    Queue<Node<Integer>> queue = new LinkedList<>();
    root.setLevel(0);
    queue.add(root);

    TreeMap<Integer, LinkedList<Node>> verticalOrder = new TreeMap<>();

    while(!queue.isEmpty()) {
      Node<Integer> element = queue.poll();

      //System.out.println("Element : " + element.getInfo() + ", level : " + element.getLevel());

      LinkedList<Node> order = verticalOrder.get(element.getLevel());
      if(order == null) {
        order = new LinkedList<>();
      }
      order.add(element);
      verticalOrder.put(element.getLevel(), order);

      if(element.getLeft() != null) {
        element.getLeft().setLevel(element.getLevel() - 1);
        queue.add(element.getLeft());
      }

      if(element.getRight() != null) {
        element.getRight().setLevel(element.getLevel() + 1);
        queue.add(element.getRight());
      }
    }

    verticalOrder.forEach((level, order) -> {
      order.forEach(node -> System.out.print(node.getInfo() + " "));
      System.out.println();
    });

  }

  public static void main(String[] args) {

    Node<Integer> root = new Node<>(1);
    root.setLeft(new Node<>(2));
    root.setRight(new Node<>(3));

    root.getLeft().setLeft(new Node<>(4));
    root.getLeft().setRight(new Node<>(5));
    root.getRight().setLeft(new Node<>(6));
    root.getRight().setRight(new Node<>(7));

    root.getRight().getRight().setLeft(new Node<>(8));
    root.getRight().getRight().setRight(new Node<>(9));
    printVerticalOrder(root);
    /**
     * Expected output 1 2 4 14 23 37 108 111 115 116 83 84 85
     */
  }
}
