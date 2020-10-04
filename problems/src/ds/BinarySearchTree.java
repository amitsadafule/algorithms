package ds;

public class BinarySearchTree {

  private Node<Integer> root;

  public BinarySearchTree(int[] array) {
    buildTree(array);
  }

  public void inorderTraversal() {
    inorderTraversal(root);
  }

  public void preorderTraversal() {
    preorderTraversal(root);
  }

  private void buildTree(int[] array) {
    for(int element : array) {
      Node node = new Node(element);
      if(root == null) root = node;
      else insert(root, node);
    }
  }

  private void insert(Node<Integer> treeNode, Node<Integer> newNode) {
    if(treeNode.getInfo().compareTo(newNode.getInfo()) > 0) {
      if(treeNode.getLeft() == null) treeNode.setLeft(newNode);
      else insert(treeNode.getLeft(), newNode);
    } else {
      if(treeNode.getRight() == null) treeNode.setRight(newNode);
      else insert(treeNode.getRight(), newNode);
    }
  }

  private void inorderTraversal(Node<Integer> node) {
    if(node == null) return;

    inorderTraversal(node.getLeft());
    System.out.print(node.getInfo() + " ");
    inorderTraversal(node.getRight());
  }

  private void preorderTraversal(Node<Integer> node) {
    if(node == null) return;

    System.out.print(node.getInfo() + " ");
    preorderTraversal(node.getLeft());
    preorderTraversal(node.getRight());
  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree(new int[] {1,2,55,33,22, -1});
    System.out.print("In order traversal : ");
    tree.inorderTraversal();
    System.out.println();
    System.out.print("Pre order traversal : ");
    tree.preorderTraversal();
  }
}
