
class DoubleLinkedList{
     Node head;
     Node tail;
    Node curr;

      DoubleLinkedList(){
        this.head=new Node("");
        this.tail=new Node("");
        this.curr=head;
        this.head.next=this.tail;
        this.tail.prev=head;
    }

    public void add(String value){
            Node prevCurr = curr;
            this.curr = new Node(value);
            this.curr.next = tail;
            this.tail.prev = curr;
            prevCurr.next = curr;
            this.curr.prev = prevCurr;

    }

    public String forward(int steps){

        while(this.curr.next!=tail && steps>0){
            this.curr=this.curr.next;
            steps--;
        }
        return this.curr.value;
    }

    public String backward(int steps){

        while(this.curr.prev!=head && steps>0){
            this.curr=this.curr.prev;
            steps--;
        }
        return this.curr.value;
    }

}
class Node{
     String value;
     Node next;
     Node prev;
    Node(String value){
        this.value=value;
    }
}


public class BrowserHistory {
    private DoubleLinkedList ddl;
    public BrowserHistory(String homepage) {
      ddl=new DoubleLinkedList();
      visit(homepage);
    }

    public void visit(String url) {
        ddl.add(url);
    }

    public String back(int steps) {
      return ddl.backward(steps);
    }

    public String forward(int steps) {
        return ddl.forward(steps);
    }
}