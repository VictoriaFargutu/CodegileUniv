package com.codegile.university.victoria.week1.day5.problem2;

public class PrintingThread extends Thread {
    public PrintingThread(Thread thread, String name){
        super(new ThreadHello(thread), name);
    }
}
