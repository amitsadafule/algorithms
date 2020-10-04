package problems;

import ds.BinarySearchTree;
import ds.Node;

/**
 * Time Complexity : O(log n)
 * Space complexity : O(1)
 */
public class LowestCommonAncestorBT {

  public static int getLowestCommonAncestor(Node<Integer> node, int x, int y) {
    if(node == null) return -1;

    //System.out.println("Scanning node : " + node.getInfo());
    if(node.getInfo() <= y && node.getInfo() >= x) {
      return node.getInfo();
    }

    if(node.getInfo() > x) return getLowestCommonAncestor(node.getLeft(), x, y);
    return getLowestCommonAncestor(node.getRight(), x, y);
  }

  public static void main(String[] args) {
    int[] array = new int[]{4, 2, 3, 1, 7, 6, 8};

    BinarySearchTree tree = new BinarySearchTree(array);
    System.out.println(getLowestCommonAncestor(tree.getRoot(), 1, 7));
    System.out.println(getLowestCommonAncestor(tree.getRoot(), 1, 3));
    System.out.println(getLowestCommonAncestor(tree.getRoot(), 6, 8));
    System.out.println(getLowestCommonAncestor(tree.getRoot(), 6, 7));
  }
}
