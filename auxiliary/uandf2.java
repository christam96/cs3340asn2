public class uandf2 {

  // The constructor should create an list of n sets
  public void uandf2(int n) {
    uandf2 uandfObj = new uandf2(n);

    SinglyLinkedListImpl list = new SinglyLinkedListImpl();
    for (int i = 0; i < n; i++) {
      list.add(i);
    }
  }

  public static void main (String[] args) {
    Union_Find_DS uandfObj = new uandf2(n);
  }
}

class Union_Find_DS {

    private Node head;
    private Node tail;

    public void add(int element){

        Node nd = new Node();
        nd.createNode(element);
        System.out.println("Adding: "+element);
        /**
         * check if the list is empty
         */
        if(head == null){
            //since there is only one element, both head and
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new node
            tail.setNextNode(nd);
            //set tail as newly created node
            tail = nd;
        }
    }
}

class Node {

    int label;
    int arr[] = new int[1];
    Node nextNode;

    int length = 0;

    // CODE FROM nodeTest.java
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

    public void setNextNode(Node nextNode) {
      this.nextNode = nextNode;
    }
/**
    @Override
    public int compareTo(T arg) {
        if(arg == this.label){
            return 0;
        } else {
            return 1;
        }
    }
**/
}
