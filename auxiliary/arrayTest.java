class arrayTest {
  public static void main (String[] args) {
      /**
      int arr[] = new int[3];

      arr[0] = 0;
      arr[1] = 1;
      arr[2] = 2;

      for (int i = 0; i<3; i++) {
        System.out.println("Element at index " + i + ":" + arr[i]);
      }
      **/
      System.out.println("hello");
      Node node1 = new Node();
      node1.newNode(1);
      Node node2 = new Node();
      node2.newNode(2);

      node1.addArr(node2.getArr());
      System.out.println("node1 array after it has added node2's array: ");
      node1.getArr();
      System.out.println("node 1 array length: ");
      node1.getLength();

  }
}

class Node {
  int label;
  int arr[];
  int length;

  public void setLabel(int i) {
    this.label = i;
  }
  public int getLabel() {
    return label;
  }
  public void setArr(int i) {
    arr = new int[i];
    length = 1;
    this.arr[0] = i;
  }
  public void newNode(int i) {
    this.setLabel(i);
    this.setArr(i);
    System.out.println("New node made with label: " + this.getLabel() + " with array size: " + this.getLength());
  }
  public void addArr(int difArr[]) {
    int temp[] = new int[arr.length + difArr.length];
    int count = 0;
    for (int i = 0; i < this.arr.length; i++) {
      temp[i] = this.arr[i];
    }
    for (int j = 0; j < difArr.length; j++) {
      temp[count++] = difArr[j];
    }
    for (int i = 0; i < arr.length + difArr.length; i++) {
      System.out.println(temp[i] + " ");
    }
    System.out.println("Temps length is: " + temp.length);
    System.out.println("Arr.length + difArr.length is: " + arr.length + difArr.length + " ");
      //this.array =
    //this.arr = difArr.clone();
  }
  public int[] getArr() {
    for (int i = 0; i < this.length; i++) {
      System.out.println(arr[i]);
    }
    return this.arr;
  }
  public int getLength() {
    System.out.println(this.length);
    return this.length;
  }


}
