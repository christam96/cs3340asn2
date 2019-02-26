class nodeTest {
  public static void main (String[] args) {
    Node node1 = new Node();
    node1.createNode(1);
    System.out.println("Node1 label: " + node1.getLabel());
    System.out.println("Node1 array contents: " + node1.getArrayContents());

    Node node2 = new Node();
    node2.createNode(2);
    System.out.println("Node2 label: " + node2.getLabel());
    System.out.println("Node2 array contents: " + node2.getArrayContents());

    node1.addArr(node2.getArray());
    System.out.println("Node1 array contents: ");
    node1.getArrayContents();

    Node node3 = new Node();
    node3.createNode(3);

    node1.addArr(node3.getArray());
    System.out.println("Node1 array contents: ");
    node1.getArrayContents();

    Node node4 = new Node();
    node4.createNode(4);

    node4.addArr(node1.getArray());
    System.out.println("Node4 array contents: ");
    node4.getArrayContents();

  }
}

class Node {
  int label;
  int arr[] = new int[1];
  Node next;

  int length = 0;

  public void createNode(int value) {
    this.label = value;
    this.arr[0] = value;
    this.length++;
  }

  public int getLabel() {
    return this.label;
  }

  public int getArrayContents() {
    for (int i = 0; i < this.length; i++) {
      System.out.println(this.arr[i]);
      //return this.arr[i];
    }
    return 0;
  }

  public int[] getArray() {
    return this.arr;
  }

  public void addArr(int difArr[]) {
    System.out.println("This arrays length: " + this.arr.length);
    System.out.println("Diff arrays length: " + difArr.length);
    int tempLength = this.arr.length + difArr.length;

    int temp[] = new int[tempLength];
    int count = 0;
    for (int i = 0; i < this.arr.length; i++) {
      System.out.println(this.arr[i]);
      temp[i] = this.arr[i];
      count++;
    }
    for (int j = 0; j < difArr.length; j++) {
      System.out.println(difArr[j]);
      temp[count++] = difArr[j];
    }

    this.arr = new int[tempLength];
    this.length = tempLength;
    this.arr = temp.clone();

    for (int k = 0; k < this.length; k++) {
      System.out.println(this.length);
      System.out.println("Node" + this.getLabel() + " at position " + k + " holds: " + this.arr[k] + " ");
    }
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
