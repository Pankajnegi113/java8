package com.multiThreading.main;



//BlockingQueue interface supports flow control (in addition to queue) by introducing
//blocking if either BlockingQueue is full or empty. A thread trying to enqueue an element
//in a full queue is blocked until some other thread makes space in the queue, either by
//dequeuing one or more elements or clearing the queue completely. Similarly, it blocks
//a thread trying to delete from an empty queue until some other threads insert an item.
//BlockingQueue does not accept a null value. If we try to enqueue the null item, then
//it throws NullPointerException.

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//BlockingQueue implementations such as LinkedBlockingQueue, ArrayBlockingQueue,
//PriorityBlockingQueue, SynchronousQueue, etc. Java BlockingQueue interfacee
//implementations are thread-safe.
public class BlockingQueueDemo {

    public static void main(String[] args)
    {
        // Create an ArrayBlockingQueue object with somecapacity
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(4);

        // Create 1 object each for producer
        // and consumer and pass them the common
        // buffer created above
        Producer p1 = new Producer(blockingQueue);
        Consumer c1 = new Consumer(blockingQueue);

        // Create 1 thread each for producer
        // and consumer and pass them their
        // respective objects.
        Thread pThread = new Thread(p1);
        Thread cThread = new Thread(c1);

        pThread.start();
        cThread.start();
    }
}

class Producer implements Runnable {
    private BlockingQueue<Integer> blockingQueue;
    private static int count=1;

    public Producer(BlockingQueue<Integer> blockingQueue)
    {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run()
    {
        while(true) {
            try {
                blockingQueue.put(count);
                System.out.println("Produced " + count);
                count++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue)
    {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run()
    {
        while(true) {
            try {
                int value = blockingQueue.take();
                System.out.println("Consumed " + value);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
