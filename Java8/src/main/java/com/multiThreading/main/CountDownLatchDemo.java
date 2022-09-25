package com.multiThreading.main;

import java.util.concurrent.CountDownLatch;

// A class to represent threads for which
// the main thread waits.
class ThirdPartyCall extends Thread
{
    private int delay;
    private CountDownLatch latch;

    private int value = 0;

    public ThirdPartyCall(int value,int delay, CountDownLatch latch,
                  String name)
    {
        super(name);
        this.delay = delay;
        this.latch = latch;
        this.value = value;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(delay);
            System.out.println("Evaluating"+ Thread.currentThread().getName()+ " result");
            value+=1000;
            latch.countDown();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public int getResult(){
        return value;
    }

}


public class CountDownLatchDemo {


    //CountDownLatch is used to make sure that a task waits for other threads
    // before it starts. To understand its application, let us consider a server
    // where the main task can only start when all the required services have started.
    //
    //Working of CountDownLatch:
    //When we create an object of CountDownLatch, we specify the number of threads it
    //should wait for, all such thread are required to do count down by calling
    //CountDownLatch.countDown() once they are completed or ready to the job.
    //As soon as count reaches zero, the waiting task starts running.
    public static void main(String str[]) throws InterruptedException {
        int result = 0;
        CountDownLatch latch = new CountDownLatch(3);
        ThirdPartyCall thirdPartyCall1 = new ThirdPartyCall(10,1000,latch,"thirdParty1");
        ThirdPartyCall thirdPartyCall2 = new ThirdPartyCall(20,1000,latch,"thirdParty2");
        ThirdPartyCall thirdPartyCall3 = new ThirdPartyCall(30,1000,latch,"thirdParty3");
        thirdPartyCall1.start();
        thirdPartyCall2.start();
        thirdPartyCall3.start();
        latch.await();
        result+=thirdPartyCall1.getResult()+thirdPartyCall2.getResult()+thirdPartyCall3.getResult();

        System.out.println("Result after all third party calls is: "+result);





    }


}
