public class uandf {

  // The constructor should create an list of n sets
  uandf(int n) {
    SinglyLinkedListImpl list = new SinglyLinkedListImpl();
    for (int i = 0; i < n; i++) {

    }
  }


}

class SinglyLinkedListImpl {

    private Node head;
    private Node tail;

    public void add(element){

        Node nd = new Node();
        nd.setValue(element);
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
            tail.setNextRef(nd);
            //set tail as newly created node
            tail = nd;
        }
    }

    public void addAfter(int element, int after){

        Node tmp = head;
        Node refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            //add element after the target node
            Node nd = new Node();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNextRef(nd);

        } else {
            System.out.println("Unable to find the given element...");
        }
    }

    public void deleteFront(){

        if(head == null){
            System.out.println("Underflow...");
        }
        Node tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
        System.out.println("Deleted: "+tmp.getValue());
    }

    public void deleteAfter(after){

        Node tmp = head;
        Node refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if(refNode.getNextRef() == null){
                tail = refNode;
            }
            System.out.println("Deleted: "+tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }

    public void traverse(){

        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }

    public static void main(String a[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.addAfter(76, 54);
        sl.deleteFront();
        sl.deleteAfter(76);
        sl.traverse();

    }
}

class Node<T> implements Comparable<T> {

    T label = i;
    T arr[] = new T[1];
    Node<T> nextNode;

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






    // ORIGIN ADT CODE
    public T getLabel() {
        return this.label;
    }
    public void setLabel(T label) {
        this.label = i;
    }
    public T getArr() {
        return arr;
    }
    public void addArr(T arr[]) {
        this.arr
    }
    public Node<T> getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
    @Override
    public int compareTo(T arg) {
        if(arg == this.label){
            return 0;
        } else {
            return 1;
        }
    }
}
