public class LoopQueue<E> implements Queue<E> {
    private E[]data;
    private int front,tail;
    private int size;
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public boolean isEmpty(){
        return front==tail;
    }

    @Override
    public int getSize(){
        return this.size;
    }

    private void resize(int newCapacity){
        E[]newData = (E[])new Object[newCapacity+1];
        for(int i=0;i<size;i++){
            newData[i]=data[(front+i)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    // 循环队列入队
    @Override
    public void enqueue(E e){
        // 首先判断当前队列是否为满，如果队列为满则扩容
        if((tail+1)%data.length == front)
            resize(2*getCapacity());

        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
}

    // 循环队列出队
    @Override
    public E dequeue(){
        E ret = data[front];
        // 处理Loitering Objects的方法，让GC主动回收
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        if(getSize()==getCapacity()/4 && getCapacity()/2!=0)
            resize(getCapacity()/2);

        return ret;
    }

    @Override
    public E getFront(){
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("LoopQueue size:%d,capacity=%d\n",getSize(),getCapacity()));
        stringBuilder.append("Front[");
        for(int i=front;i!=tail;i=(i+1)%data.length){
            stringBuilder.append(data[i]);
            if((i+1)%data.length!=tail)
                stringBuilder.append(",");
        }
        stringBuilder.append("]Tail");
        return stringBuilder.toString();
    }

}
