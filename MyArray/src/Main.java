public class Main {
    public static void main(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        for(int i=0;i<10;i++){
            myArray.addLast(i);
        }
        myArray.addLast(100);
        System.out.println(myArray);
        myArray.removeFirst();
        System.out.println(myArray);
        myArray.addFirst(100);
        myArray.removeAllElements(100);
        System.out.println(myArray);
    }
}
