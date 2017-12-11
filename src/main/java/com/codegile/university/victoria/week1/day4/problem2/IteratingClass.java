//Extindeți clasa ArrayList (generic) pentru a pune la dispoziție trei metode care returnează câte un iterator pentru elementele din listă:
//unul să itereze normal, al doilea să itereze din două în două elemente,
//iar al treilea să itereze primul -> ultimul -> al doilea -> penultimul -> al treilea etc.
//până când toate elementele au fost iterate o singură dată.

package com.codegile.university.victoria.week1.day4.problem2;

import java.util.*;

public class IteratingClass {
   private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args){
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        //iterateOverTwoElements();
        iterateDifferently();

    }

    public static void iterateOverElements(){
        IteratorClass<ArrayList, String> iteratorClass = new IteratorClass(list);
        while(iteratorClass.hasNext()){
            System.out.println(iteratorClass.next());
        }
    }

    public static void iterateOverTwoElements(){
        IteratorOverTwo<ArrayList, String> iteratorOverTwo = new IteratorOverTwo<>(list);
        while(iteratorOverTwo.hasNext()){
            System.out.println(iteratorOverTwo.next());
        }
    }

    public static void iterateDifferently(){
        DifferentIterator<ArrayList, String> differentIterator = new DifferentIterator<>(list);
        while(differentIterator.hasNext()){
            System.out.println(differentIterator.next());
        }
    }
}
