package com.codegile.university.victoria.week1.day4.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class IteratorClass<T extends ArrayList, E> implements Iterator{
    private T list;
    private int currentIndex = 0;

    public IteratorClass(T list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if(list.isEmpty()){
            return false;
        }
        if(currentIndex + 1 < list.size()){
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        if(hasNext()){
            return (E) list.get(currentIndex++);
        }
        return null;
    }
}
