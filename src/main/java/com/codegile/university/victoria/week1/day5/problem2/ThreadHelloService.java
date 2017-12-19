package com.codegile.university.victoria.week1.day5.problem2;

import java.util.ArrayList;
import java.util.List;

public class ThreadHelloService {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        Thread thread50 = new PrintingThread(null, "Thread50");
        threads.add(thread50);

        for(int i = 49; i >= 0; i--){
            Thread thread = new PrintingThread(threads.get(threads.size()-1), "Thread"+i);
            threads.add(thread);
            if(i==1){
                thread.start();
            }
        }
    }
}
