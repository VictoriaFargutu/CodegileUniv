package com.codegile.university.victoria.week1.day2.problem1;

public class HashMapTest {

    private static HashMap<String, String> hashMap = new HashMap<>();

    public static void main(String[] args){
        testHashMapPut();
        testHashMapGet();
        testHashMapCollisions();
    }

    public static void testHashMapPut(){
        hashMap.put("string1", "value1");
    }

    public static void testHashMapGet(){
        String k = "TestPutGet";
        String v = "changedValue";
        hashMap.put(k, v);
        Object valueResult = hashMap.get(k);
        System.out.println("Value result= " + valueResult);

    }

    public static void testHashMapCollisions() {
        /* Initialise hashmap */
        for(int i = 0; i < 5; i++){
            hashMap.put(Integer.toString(i), Integer.toString(i));
        }
        /* Test all values of the get method */
        for(int i = 0; i < 5; i++){
            hashMap.put(Integer.toString(i), Integer.toString(5));
            Object value = hashMap.get(Integer.toString(i));
            System.out.println("value= " + value);
        }
    }


}
