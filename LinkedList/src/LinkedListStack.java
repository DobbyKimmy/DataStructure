public class LinkedListStack<E> implements Stack<E> {
    private LinkedListOptimized<E>linkedList;
    public LinkedListStack(){
        linkedList = new LinkedListOptimized();
    }
    @Override
    public void push(E e){
        linkedList.addFirst(e);
    }
    @Override
    public E pop(){
        return linkedList.removeFirst();
    }
    @Override
    public E peek(){
        return linkedList.getFirst();
    }
    @Override
    public int getSize(){
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack:top[");
        for(int i=0;i<getSize();i++){
            stringBuilder.append(linkedList.get(i));
            if(i<getSize()-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
