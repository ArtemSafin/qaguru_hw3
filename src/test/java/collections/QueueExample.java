package collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public final Queue<Integer> queRay = new LinkedList<>();
    public void addQue(Integer value) {
        queRay.add(value);
    }
    public void removeQue(Integer value) {
        queRay.remove(value);
    }
    public void getQue(Queue<Integer> queRay) {
        for (Integer que : queRay) {
            System.out.println(que);
        }
    }

    public final Deque<Integer> deqRay = new LinkedList<>();
    public void addDeq() {
        for (int i = 0; i <= 100; i++) {
            deqRay.add(i);
        }
    }
    public void removeDeq(Integer value) {
        deqRay.remove(value);
    }

    public static void main(String[] args) {

        QueueExample queueExample = new QueueExample();
        queueExample.addQue(1);
        queueExample.addQue(2);
        queueExample.addQue(3);
        queueExample.addQue(4);
        queueExample.addQue(5);
        queueExample.addQue(6);
        queueExample.removeQue(6);
        queueExample.getQue(queueExample.queRay);

        queueExample.removeDeq(13);
        queueExample.addDeq();
//        System.out.println(queueExample.deqRay);



    }
}