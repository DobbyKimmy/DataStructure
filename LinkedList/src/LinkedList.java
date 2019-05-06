public class LinkedList <E>{
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
    private int size;

    // 构造函数
    public LinkedList(){
        head = null;
        size = 0;
    }
    //  获取链表中元素的个数
    public int getSize(){
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
        head = new Node(e,head);
        size++;
    }

    // 在链表中间添加一个元素
    // 添加用到了index，实际上链表是没有索引这样一个概念的，仅作为对链表加深印象用
    public void add(int index,E e){
        if(index<0 || index>size)
            throw new IllegalArgumentException("Index is Illegal");
        if(index==0){
            addFirst(e);
        }else{
            Node prev = head;
            for(int i=0;i<index-1;i++){
                prev = prev.next;
            }
            prev.next = new Node(e,prev.next);
            size++;
        }
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size,e);
    }
}
