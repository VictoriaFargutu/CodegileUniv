package com.codegile.university.victoria.week1.day5.problem3;

import java.util.Random;

public class Parking implements Runnable {

    public Parking(){}

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(9000) + 1000);

            System.out.println(Thread.currentThread().getName() + " wants to park;");
            System.out.println("Parked cars: " + (ParkingService.CAR_PARKS - ParkingService.semaphore.availablePermits()) +"/" + ParkingService.CAR_PARKS);
            System.out.println("Waiting: " + ParkingService.semaphore.getQueueLength());


            ParkingService.semaphore.acquire();
            long enterTime = System.currentTimeMillis();

            Thread.sleep(new Random().nextInt(9000) + 1000);

            long exitTime = System.currentTimeMillis();
            ParkingService.semaphore.release();

            System.out.println(Thread.currentThread().getName() + " has parked for" + (enterTime - exitTime)/1000 + " seconds");
            System.out.println(Thread.currentThread().getName() + " exits the parking lot. ");
            System.out.println("Parked cars: " + (ParkingService.CAR_PARKS - ParkingService.semaphore.availablePermits()) +"/" + ParkingService.CAR_PARKS);
            System.out.println("Waiting: " + ParkingService.semaphore.getQueueLength());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
