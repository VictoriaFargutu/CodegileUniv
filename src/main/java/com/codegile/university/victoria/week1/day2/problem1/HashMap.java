package com.codegile.university.victoria.week1.day2.problem1;

public class HashMap<K, V> {
    public static final int HASH_MAP_SIZE = 256;
    Entry<K, V>[] hashMap = new Entry[HASH_MAP_SIZE];

    public HashMap(){
    }

    public void put(K key, V value){
        int hash;
       // int hashMapIndex;
        Entry<K, V> newEntry = new Entry<K, V>(key, value, null);

        if(key == null){
            hash = 0;
            hashMap[hash] = newEntry;
        } else{
            hash = getHashCode(key);

            if(hashMap[hash] == null){
                hashMap[hash] = newEntry;
            } else{
                Entry<K, V> currentEntry = hashMap[hash];
                while(currentEntry.getNext() != null){
                    if(currentEntry.getKey().equals(newEntry.getKey())){
                        currentEntry.setValue(newEntry.getValue());

                        return;
                    }
                    currentEntry = currentEntry.getNext();
                }
                currentEntry.setNext(newEntry);
            }
        }
    }

    public V get(K key){
        int hash = getHashCode(key);
        Entry<K, V> entry = hashMap[hash];
        while(entry != null){
            if(entry.getKey().equals(key)){
                return entry.getValue();
            } else{
                entry = entry.getNext();
            }
        }
        return null;
    }

    public int calculateIndexForHashMap(int hash){
        return hash & (HASH_MAP_SIZE-1);
    }

        public int getHashCode(K key){
        int hash = Math.abs(key.hashCode() % HASH_MAP_SIZE);
        return hash;
   }

}
