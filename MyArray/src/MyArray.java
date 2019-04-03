public class MyArray<E> {
    private E[]data;
    private int size;
    //构造方法
    public MyArray(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    public MyArray(){
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

    // 改
    public void set(int index,E e){
        if(index<0 || index>=this.size)
            throw new IllegalArgumentException("Index is Illegal");

        data[index] = e;
    }
    // 查
    // 查：get
    public E get(int index){
        if(index<0 || index>=this.size)
            throw new IllegalArgumentException("Index is Illegal");

        return data[index];
    }

    // 查：contains
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查：find
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    // resize：实现动态数组
    private void resize(int newCapacity){
        E[]newData = (E[])new Object[newCapacity];
        for(int i=0;i<this.size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
    //增加元素
    public void add(int index,E e){
        if(index<0 || index>size)
            throw new IllegalArgumentException("Index is Illegal");

        if(size == data.length)
            resize(2*data.length);

        for(int i=this.size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(this.size,e);
    }

    // 删除元素
    public E remove(int index){
        if(index<0 || index>=this.size)
            throw new IllegalArgumentException("Index is Illegal");

        E ret = data[index];
        for(int i=index+1;i<=this.size-1;i++){
            data[i-1] = data[i];
        }
        size--;
        // data[size] 为loitering Object 最好将其赋值为null 让jvm GC自动进行垃圾回收
        data[size] = null;

        // &&data.length/2!=0的原因：防止出现当 data.length = 1 且当前无元素即size=0时
        if(this.size == data.length/4 && data.length/2!=0)
            resize(data.length/2);

        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(this.size-1);
    }

    // removeElement 删除数组中第一个为 e 的元素
    public void removeElement(E e){
        int index = 0;
        if((index = find(e))!=-1){
            remove(index);
        }
    }

    // removeAllElements 删除数组中所有为 e 的元素
    public void removeAllElements(E e){
        int index = 0;
        while((index = find(e))!=-1){
            remove(index);
        }
    }

    // toString
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array:size=%d , capacity=%d\n",size,data.length));
        stringBuilder.append("Array:[");
        for(int i=0;i<size;i++){
            stringBuilder.append(data[i]);
            if(i != size-1){
                stringBuilder.append(",");
            }else{
                stringBuilder.append("]");
            }
        }
        return stringBuilder.toString();
    }
}
