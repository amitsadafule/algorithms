package problems;

import ds.BinarySearchTree;
import ds.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Time Complexity : Scan for finding level and keeping sorted map O(n log n) + printing O(n) = O(n log n)
 * Space complexity : O(n)
 */
public class TopViewOfTree {

  private static void printTopView(Node<Integer> root) {
    Queue<Node<Integer>> queue = new LinkedList<>();
    root.setLevel(0);
    queue.add(root);

    TreeMap<Integer, Node<Integer>> visited = new TreeMap<>();
    while(!queue.isEmpty()) {
      Node<Integer> element = queue.poll();
      if(visited.get(element.getLevel()) == null) {
        visited.put(element.getLevel(), element);
      }

      if(element.getLeft() != null) {
        element.getLeft().setLevel(element.getLevel() - 1);
        queue.add(element.getLeft());
      }

      if(element.getRight() != null) {
        element.getRight().setLevel(element.getLevel() + 1);
        queue.add(element.getRight());
      }
    }

    visited.forEach((level, node) -> System.out.print(node.getInfo() + " "));
  }

  public static void main(String[] args) {
    int[] array = new int[]{37,23,108,59,86,64,94,14,105,17,111,65,55,31,79,97,78,25,50,22,66,46,104,98,81,90,68,40,
      103,77,74,18,69,82,41,4,48,83,67,6,2,95,54,100,99,84,34,88,27,72,32,62,9,56,109,115,33,15,91,29,85,114,112,20,
      26,30,93,96,87,42,38,60,7,73,35,12,10,57,80,13,52,44,16,70,8,39,107,106,63,24,92,45,75,116,5,61,49,101,71,11,53,
      43,102,110,1,58,36,28,76,47,113,21,89,51,19,3};

    BinarySearchTree tree = new BinarySearchTree(array);
    printTopView(tree.getRoot());
    /**
     * Expected output 1 2 4 14 23 37 108 111 115 116 83 84 85
     */
  }
}
