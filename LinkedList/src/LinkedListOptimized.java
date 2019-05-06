public class LinkedListOptimized<E> {
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
    // 虚拟头节点
    private Node dummyHead;
    private int size;
    public LinkedListOptimized(){
        dummyHead = new Node();
        size = 0;
    }
    // 获取链表中的元素的个数
    public int getSize(){
        return size;
    }
    // 返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //在链表中添加一个元素
    public void add(int index,E e){
        if(index<0 || index>size)
            throw new IllegalArgumentException("Index is Illegal");
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        prev.next = new Node(e,prev.next);
        size++;
    }
    // 在链表头添加新的元素e
    public void addFirst(E e){
        add(0,e);
    }
    // 在链表尾添加新的元素e
    public void addLast(E e){
        add(size,e);
    }

    // 获得链表的第index位置的元素
    public E get(int index){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Index is Illegal");
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        return prev.next.e;
    }
    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }
    // 获得链表的最后一个元素
    public E getLast(){
        return get(size-1);
    }

    // 修改链表第index位置的元素
    public void set(int index,E e){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Index is Illegal");

        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        prev.next.e = e;
    }

    // 查找链表中是否存在元素e
    public boolean contains(E e){
        Node prev = dummyHead;
        for(int i=0;i<size;i++){
            prev = prev.next;
            if(prev!=null && e.equals(prev.e)){
                return true;
            }
        }
        return false;
    }

    // 在链表中删除index位置的元素e
    public E remove(int index){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Index is Illegal");
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        E ret = delNode.e;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return ret;
    }
    // 从链表中删除第一个元素，并返回
    public E removeFirst(){
        return remove(0);
    }
    // 从链表中删除最后一个元素，并返回
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedList:");
        Node cur = dummyHead.next;
        while(cur!=null){
            stringBuilder.append(cur.e);
            if(cur.next!=null){
                stringBuilder.append("->");
            }
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

}
