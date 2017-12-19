//Simulați folosind Threaduri o parcare în care intră și ies niște mașini.
// Parcarea poate ține un număr maxim de 5 mașini parcate la orice moment,
// iar mașinile care vor să intre atunci când parcarea e plină vor aștepta
// la coadă până când un loc este eliberat. La un interval aleator între 1 și 10
// secunde o altă mașină va veni să parcheze, iar mașinile vor sta parcate pentru
// un timp aleator între 1 și 10 secunde, după care vor elibera locul. După fiecare
// acțiune se va afișa stadiul curent al parcării, cu numărul mașinilor parcate,
// numărul locurilor libere și numărul de mașini care așteaptă la coadă. (vă amintiți
// că am dat exemplul acesta luni dacă ați fost - ce clasă credeți că poate fi folosită
// pentru o soluție optimă? Dacă nu bănuiți răspunsul la întrebare vă rog să mă întrebați ca să o discutăm).
package com.codegile.university.victoria.week1.day5.problem3;

import java.util.concurrent.Semaphore;

public class ParkingService {
    public static int CAR_PARKS = 5;
    public static Semaphore semaphore = new Semaphore(CAR_PARKS);
    public static void main(String[] args) {
        int i = 1;
        Thread thread1 = new Thread(new Parking(), "Car" + i++);
        Thread thread2 = new Thread(new Parking(), "Car" + i++);
        Thread thread3 = new Thread(new Parking(), "Car" + i++);
        Thread thread4 = new Thread(new Parking(), "Car" + i++);
        Thread thread5 = new Thread(new Parking(), "Car" + i++);
        Thread thread6 = new Thread(new Parking(), "Car" + i++);
        Thread thread7 = new Thread(new Parking(), "Car" + i++);
        Thread thread8 = new Thread(new Parking(), "Car" + i++);
        Thread thread9 = new Thread(new Parking(), "Car" + i++);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();

//        while(i < 15){
//            i++;
//            Thread thread = new Thread(parking.getInstance(), "Car" + i);
//                thread.start();
//        }
    }
}
