/*
class Node{

    int value;
    Node next;
    Node prev;

   public  Node(int value){
        this.value=value;
        this.next=null;
        this.prev=null;
    }

}
public class CircularGame {

    public  static void printList(Node head){

        while(head.next!=null){

            System.out.println(head.value);
            head=head.next;
        }
    }

    static Node head;
    public static  int findTheWinner(int n, int k) {

        Node prevNode=null;
        Node newNode=head;
        for(int i=1;i<=n;i++){
            newNode=new Node(i);
            if(head==null){
                head=newNode;
            }else{
                prevNode.next=newNode;
                newNode.prev=prevNode;
            }
            prevNode=newNode;
        }
        newNode.next=head;
        head.prev=newNode;
       // printList(head);
        Node startNode=head;

        while(n!=1){
             Node tempNode=startNode;
            for(int i=1;i<k-1;i++){
               tempNode=tempNode.next;
            }
             startNode=tempNode.next.next;
            tempNode.next=tempNode.next.next;
            tempNode.next.prev=tempNode;
            n-=1;

        }
        return startNode.value;
    }



    public static void main(String[] args) {

        System.out.println(findTheWinner(6,5));

    }
}
*/
