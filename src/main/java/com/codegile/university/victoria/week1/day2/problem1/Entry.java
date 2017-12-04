package com.codegile.university.victoria.week1.day2.problem1;

public class Entry<K, V> {
   private K key;
    private V value;
    private Entry<K, V> next;
    private int hash;

    public Entry(K key, V value, Entry<K, V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey(){
        return this.key;
    }

    public void setKey(K key){
        this.key = key;
    }

    public V getValue(){
        return this.value;
    }

    public void setValue(V value){
        this.value = value;
    }

    public Entry<K, V> getNext(){
        return this.next;
    }

    public void setNext(Entry<K, V> next){
        this.next = next;
    }

    public int getHash(){
        return this.hash;
    }

    public void setHash(int hash){
        this.hash = hash;
    }

   }

