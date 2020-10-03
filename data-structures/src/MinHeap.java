import java.util.ArrayList;


/**
 * Min find time complexity : O(1)
 * insert element time complexity : O(log n)
 * creation time complexity : O(n log n)
 * Space complexity : O(n)
 */
public class MinHeap {

  ArrayList<Integer> heapArray;

  public MinHeap(int[] array) {
    assert array.length != 0;

    heapArray = new ArrayList<>(array.length);
    createHeap(array);
  }

  public int getMin() {
    return heapArray.get(0);
  }

  public int deleteAt(int index) {
    assert heapArray.size() < index;

    int farthestElement = heapArray.remove(heapArray.size() - 1);
    int removedElement = heapArray.set(index, farthestElement);
    heapDown(farthestElement, index);
    return removedElement;
  }

  public void insert(int element) {
    heapArray.add(element);
    heapUp(element, heapArray.size() - 1);
  }

  private void heapDown(int element, int index) {

    int leftChildIndex = 2 * index + 1;
    int rightChildIndex = 2 * index + 2;

    if(leftChildIndex < heapArray.size() && heapArray.get(leftChildIndex) < element) {
      int childElement = heapArray.get(leftChildIndex);
      heapArray.set(leftChildIndex, element);
      heapArray.set(index, childElement);
      heapDown(element, leftChildIndex);
      return;
    }

    if(rightChildIndex < heapArray.size() && heapArray.get(rightChildIndex) < element) {
      int childElement = heapArray.get(rightChildIndex);
      heapArray.set(rightChildIndex, element);
      heapArray.set(index, childElement);
      heapDown(element, rightChildIndex);
      return;
    }

  }

  private void createHeap(int[] array) {
    for(int element : array) {
      heapArray.add(element);
      heapUp(element, heapArray.size() - 1);
    }
  }

  private void heapUp(int element, int position) {
    if(position == 0) return;

    int parentIndex = (position - 1) / 2;
    int parentValue = heapArray.get(parentIndex);
    if(parentValue > element) {
      heapArray.set(parentIndex, element);
      heapArray.set(position, parentValue);
      heapUp(element, parentIndex);
    }
  }

  @Override
  public String toString() {
    int height = (int) Math.ceil(Math.log(heapArray.size()) / Math.log(2));

    int elementIndex = 0;
    StringBuilder stringBuilder = new StringBuilder();
    for(int level = 0; level < height; level++) {
      int numberOfElementsOnLevel = (int) Math.pow(2, level);
      int spaces = (int) Math.pow(2, height - level) / 2;
      for(int i = 0; i < spaces; i++) stringBuilder.append(" ");
      for(int counter = 0; counter < numberOfElementsOnLevel && elementIndex < heapArray.size(); counter++, elementIndex++) {
        if(counter > 0) stringBuilder.append(" ");
        stringBuilder.append("|" + heapArray.get(elementIndex) + "|");
      }
      stringBuilder.append("\n");
    }

    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    int[] array = new int[] {2, 7, 6,32, 2, 5, 23};

    MinHeap minHeap = new MinHeap(array);
    System.out.println(minHeap);
    System.out.println("Removing element at index 3");
    minHeap.deleteAt(3);
    System.out.println(minHeap);
    System.out.println("Removing element at index 0");
    minHeap.deleteAt(0);
    System.out.println(minHeap);

    System.out.println("Removing element 1");
    minHeap.insert(1);
    System.out.println(minHeap);
  }
}
