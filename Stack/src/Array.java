public class Array<E> {
    private E[]data;
    private int size;
    // 构造方法
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    public Array(){
        this(10);
    }
    public int getSize(){
        return this.size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    // resize
    private void resize(int newCapacity){
        E []newData = (E[])new Object[newCapacity];
        for(int i=0;i<data.length;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
    // contains(E e)
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }
    // find(E e)
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }
    // 增加元素
    public void add(int index,E e){
        if(index<0 || index>size)
            throw new IllegalArgumentException("Index is Illegal");
        if(size == data.length)
            resize(2*data.length);

        for(int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
    // addLast(E e)
    public void addLast(E e){
        add(size,e);
    }
    // addFirst(E e)
    public void addFirst(E e){
        add(0,e);
    }
    // 删除元素
    public E remove(int index){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Index is Illegal");

        if(isEmpty())
            throw new IllegalArgumentException("Array is Empty,can't remove element");

        E ret = data[index];
        for(int i=index+1;i<=size-1;i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length/4 && data.length/2!=0)
            resize(data.length/2);
        return ret;
    }
    // removeFirst
    public E removeFirst(){
        return remove(0);
    }
    // removeLast
    public E removeLast(){
        return remove(size-1);
    }

    // removeElement(E e)
    public void removeElement(E e){
        int index = find(e);
        if(index!=-1){
            remove(index);
        }
    }

    // removeAllElements(E e)
    public void removeAllElements(E e){
        int index;
        while((index=find(e))!=-1){
            remove(index);
        }
    }

    // 改
    public void set(int index,E e){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Index is Illegal");

        data[index] = e;
    }

    // 查
    public E get(int index){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Index is Illegal");

        return data[index];
    }

    // toString
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array:size=%d,capacity=%d\n",this.size,data.length));
        stringBuilder.append("[");
        for(int i=0;i<size;i++){
            stringBuilder.append(data[i]);
            if(i!=size-1)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
