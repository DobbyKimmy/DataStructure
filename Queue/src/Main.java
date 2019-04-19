import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer>q,int testCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i=0;i<testCount;i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));

        for(int i=0;i<testCount;i++)
            q.dequeue();

        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[]args){
        int testCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopQueueTime = testQueue(loopQueue,testCount);
        double arrayQueueTime = testQueue(arrayQueue,testCount);
        System.out.println("LoopQueue:"+loopQueueTime);
        System.out.println("ArrayQueue"+arrayQueueTime);
    }
}
