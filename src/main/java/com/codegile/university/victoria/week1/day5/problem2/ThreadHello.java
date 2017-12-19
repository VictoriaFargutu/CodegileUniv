package com.codegile.university.victoria.week1.day5.problem2;

public class ThreadHello implements Runnable {
    private Thread nextThread;
    private int index = 2;

    public ThreadHello(Thread nextThread){
        this.nextThread = nextThread;
    }

    @Override
    public void run() {
        if(index < 50 && nextThread != null) {
            this.nextThread.start();
            index++;
            try {
                nextThread.join();
                System.out.println("Hello from " + Thread.currentThread().getName() + "!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Hello from " + Thread.currentThread().getName() + "!");
        }
    }
}
