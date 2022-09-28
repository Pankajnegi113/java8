package com.multiThreading.main;

//source : https://www.geeksforgeeks.org/java-util-concurrent-cyclicbarrier-java/

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


class ThirdPartyService extends Thread{

    private CyclicBarrier cyclicBarrier;

    ThirdPartyService(String serviceName,CyclicBarrier cyclicBarrier){
        super(serviceName);
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" completed it's execution");
            cyclicBarrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}




//CyclicBarrier is used to make threads wait for each other.
//It is used when different threads process a part of computation
//and when all threads have completed the execution,
//the result needs to be combined in the parent thread.
//In other words, a CyclicBarrier is used when multiple thread carry
//out different sub tasks and the output of these sub tasks need to be combined
//to form the final output. After completing its execution, threads call await() method
//and wait for other threads to reach the barrier. Once all the threads have reached, the barriers
//then give the way for threads to proceed
public class CyclicBarrierDemo {



    public static void main(String args[]) throws BrokenBarrierException, InterruptedException {
        //First a new instance of a CyclicBarriers is created
        //specifying the number of threads that the barriers should wait upon.
        CyclicBarrier newBarrier = new CyclicBarrier(4);

        //Each and every thread does some computation and after completing it’s execution,calls awaits
        //Once the number of threads that called await() equals numberOfThreads, the barrier
        // then gives a way for the waiting threads.
        ThirdPartyService service1 = new ThirdPartyService("Service1",newBarrier);
        ThirdPartyService service2 = new ThirdPartyService("Service2",newBarrier);
        ThirdPartyService service3 = new ThirdPartyService("Service3",newBarrier);

        ThirdPartyService service4 = new ThirdPartyService("Service4",newBarrier);
        ThirdPartyService service5 = new ThirdPartyService("Service5",newBarrier);
        ThirdPartyService service6 = new ThirdPartyService("Service6",newBarrier);

        service1.start();
        service2.start();
        service3.start();

        newBarrier.await(); //if won't use this, all service can be printed before since main thread can run before services thread also, so use await for main also
        //cyclic barrier differ from CountDown latch in a way that, cyclic barrier, barrier resets
        // to original parties size once reach to 0 and can be used again but for different thread types

        System.out.println("Service calls made and result is computed");

        service4.start();
        service5.start();
        service6.start();

        newBarrier.await();
        System.out.println("Other 3 service called and result is computer");


    }



}
