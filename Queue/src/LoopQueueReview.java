public class LoopQueueReview<E> implements Queue<E> {
    private E[]data;
    private int front;
    private int tail;
    public LoopQueueReview(int capacity){
        data = (E[])new Object[capacity+1];
    }
    public LoopQueueReview(){
        this(10);
    }
    @Override
    public int getSize(){
        if(tail<front)
            return data.length-(front-tail);
        else{
            return tail-front;
        }
    }

    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public boolean isEmpty(){
        return getSize()==0;
    }

    private void resize(int newCapacity){
        E[]newData = (E[])new Object[newCapacity+1];
        for(int i=0;i<getSize();i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        tail = getSize();
        front = 0;
    }
    @Override
    public void enqueue(E e){
        if(front==(tail+1)%data.length)
            resize(2*getSize());

        data[tail] = e;
        tail = (tail+1)%data.length;
    }

    @Override
    public E dequeue(){
        E ret = data[front];
        // Loitering Object
        data[front] = null;
        front = (front+1)%data.length;
        if(getSize() == getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront(){
        if(getSize()==0)
            throw new IllegalArgumentException("LoopQueue is empty");

        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("LoopQueue size:%d,capacity:%d\n",getSize(),getCapacity()));
        stringBuilder.append("front:[");
        for(int i=front;i!=tail;i=(i+1)%data.length){
            stringBuilder.append(data[i]);
            if((i+1)%data.length!=tail)
                stringBuilder.append(",");
            else{
                stringBuilder.append("]tail");
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[]args){
        LoopQueueReview<Integer> loopQueue = new LoopQueueReview<>();
        for(int i=0;i<11;i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        System.out.println(loopQueue);
    }
}
