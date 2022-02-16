/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amit.realdb;

import java.util.*;

public class InMemory<K, V>{

    final static int INIT_CAPACITY = 1000;

    ArrayList<LinkedList<HashMap<K, V>>> hashTable = new ArrayList<>();

    public InMemory(){
        createHashTable(this.hashTable);
    }

    private void createHashTable(ArrayList<LinkedList<HashMap<K, V>>> hashTable){

        for(int i = 0; i < InMemory.INIT_CAPACITY; i++){
            LinkedList<HashMap<K,V>> ll = new LinkedList<>();
            hashTable.add(ll);
        }
    }

    public void put(K key, V value){

        int hashCode = Math.abs(key.hashCode());
        int bucket = hashCode % hashTable.size();

        LinkedList<HashMap<K,V>> ll = hashTable.get(bucket);

        HashMap<K,V> keyValue = new HashMap<>();
        keyValue.put(key, value);
        ll.add(keyValue);
    }

    public V get(K key){

        boolean isFound = false;
        V value = null;
        int hashCode = Math.abs(key.hashCode());
        int bucket = hashCode % hashTable.size();

        LinkedList<HashMap<K,V>> ll = hashTable.get(bucket);

        for (HashMap<K, V> keyValue : ll) {
            for(HashMap.Entry<K, V> entry: keyValue.entrySet()){
                if(entry.getKey().equals(key)){
                    value = entry.getValue();
                    isFound = true;
                }
            }
            if (isFound) break;
        }
        return value;
    }

    public void displayHashTable(){

        for (int i=0; i<hashTable.size(); i++){
            LinkedList<HashMap<K,V>> ll = hashTable.get(i);
            Iterator<HashMap<K,V>> it = ll.iterator();

            System.out.println("Bucket is " + i);
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
    }

    public static void main(String args[]){

        InMemory<Integer, Integer> myHashMap = new InMemory<>();

        for(int i=0; i<2000000; i++){
            myHashMap.put(i, i);
        }
//        myHashMap.displayHashTable();

        Object v = myHashMap.get(100);
        System.out.println(v);

    }
}

