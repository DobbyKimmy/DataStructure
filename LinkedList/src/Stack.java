public interface Stack<E> {
    // 入栈
    void push(E e);
    // 出栈
    E pop();
    // 查看栈顶元素
    E peek();
    int getSize();
    boolean isEmpty();
}
