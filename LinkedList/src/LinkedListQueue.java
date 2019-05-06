public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }

    // 链表队列入队操作
    @Override
    public void enqueue(E e){
        Node node = new Node(e);
        if(isEmpty()){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    // 链表队列出队操作
    @Override
    public E dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is Empty");
        Node retNode = head;
        if(head==tail){
            head = null;
            tail = null;

        }else{
            head = head.next;
        }
        size--;
        retNode.next = null;
        return retNode.e;
    }

    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is Empty");

        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedListQueue:front[");
        Node cur = head;
        while(cur!=null){
            stringBuilder.append(cur.e+"->");
            cur = cur.next;
        }
        stringBuilder.append("Null ]tail");
        return stringBuilder.toString();
    }
    public static void main(String[]args){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for(int i=0;i<10;i++){
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue);
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
        linkedListQueue.enqueue(666);
        System.out.println(linkedListQueue);
    }
}
