package com.codegile.university.victoria.week1.day4.problem2;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorOverTwo<T extends ArrayList, E> implements Iterator {
    private T list;
    private int currentIndex = 0;

    public IteratorOverTwo(T list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if(list.isEmpty()){
            return false;
        }
        if(currentIndex + 2 < list.size()){
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        if(hasNext()){
            E e = (E) list.get(currentIndex);
            currentIndex += 2;
            return e;
        }
        return null;
    }
}
