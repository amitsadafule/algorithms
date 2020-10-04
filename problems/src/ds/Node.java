package ds;

public class Node<T> {
  private T info;
  private int level;
  private Node left, right;

  public Node(T info) {
    this.info = info;
  }

  public T getInfo() {
    return info;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}
