package com.codegile.university.victoria.week1.day4.problem2;

import java.util.ArrayList;
import java.util.Iterator;

public class DifferentIterator <T extends ArrayList, E> implements Iterator {
    private T list;
    private int currentIndex = 0;
    private int numberOfIterations = 0;
    private int firstIndex = 0;
    private int lastIndex;

    public DifferentIterator(T list){
        this.list = list;
//        this.firstIndex = 1 + list.size()- list.size();
        this.lastIndex = list.size()-1;
    }

    @Override
    public boolean hasNext() {
        if(list.isEmpty()){
            return false;
        }
        if(numberOfIterations < list.size()){
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        if(hasNext()){
            numberOfIterations++;
            if(currentIndex == 0 && numberOfIterations == 1){
                return (E) list.get(0);
            }else if(currentIndex == 0 || currentIndex == firstIndex){
                firstIndex++;
                currentIndex = lastIndex;
                return (E) list.get(lastIndex);
            } else if(currentIndex == lastIndex){
                lastIndex--;
                currentIndex = firstIndex;
                return  (E) list.get(firstIndex);
            }
        }
        return null;
    }
}
