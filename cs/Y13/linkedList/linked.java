public class Node {
    private int data; 
    private Node nextNode; 
    public Node (int data, Node nextNode){
        this.data = data;
        this.nextNode = nextNode;
    }
    public int getData(){
        return data;
    }
    public Node getNode(){
        return nextNode;
    }
    public void setNode(Node next){
        this.nextNode = next;
    }

    public static void main(String args[]){
        Node head = new Node(1,null);
        System.out.println(head.getNode());
        Node one = new Node(2,null);
        head.setNode(one);
        System.out.println(head.getNode());
    }
}
//class Linked { 
//    private Node head;
//    private Node tail;
//    private int size;
//    
//    void Add Node()
//    public static void main(String args[]){
//        Node head = new Node(1,null);
//        System.out.println(a);
//    }
//}
