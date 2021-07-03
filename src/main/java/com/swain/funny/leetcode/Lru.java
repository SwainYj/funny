package com.swain.funny.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;


public class Lru {
    private int capacity;
    private LRULinkHashMap<Integer, Integer> lruHashMap = new LRULinkHashMap<>();

    private class LRULinkHashMap<k, v> extends LinkedHashMap<k, v> {
        @Override
        protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
            if (size() > capacity) {
                return true;
            } else {
                return false;
            }
        }
    }

    public Lru(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = lruHashMap.get(key);
        if (null == value) {
            return -1;
        }
        lruHashMap.remove(key);
        lruHashMap.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (lruHashMap.containsKey(key)) {
            lruHashMap.remove(key);
        }
        lruHashMap.put(key, value);
    }

//    private static Map<Integer, Integer> lRUCache = new HashMap<>();
//    private static LinkedList<Integer> link = new LinkedList<>();
//    private static Integer capacity = 2;
//
//    public static void main(String[] args) {
//        put(1, 1);
//        put(2, 2);
//        get(1);
//        put(3, 3);
//        get(2);
//        put(4, 4);
//        get(1);
//        get(3);
//        get(4);
//
//        //lRUCache.put(1, 1); // 缓存是 {1=1}
////lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
////lRUCache.get(1);    // 返回 1
////lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
////lRUCache.get(2);    // 返回 -1 (未找到)
////lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
////lRUCache.get(1);    // 返回 -1 (未找到)
////lRUCache.get(3);    // 返回 3
////lRUCache.get(4);    // 返回 4
//    }
//
//    public static void get(int key) {
//        order(key);
//        if (lRUCache.containsKey(key)) {
//            System.out.println("get:" + lRUCache.get(key));
//        } else {
//            System.out.println("get: null");
//        }
//
////        System.out.println("map:" + lRUCache);
////        System.out.println("link:" + link);
//    }
//
//    public static void put(int key, int value) {
//        if (lRUCache.size() >= capacity && !lRUCache.containsKey(key)) {
//            remove();
//        }
//        if (lRUCache.size() >= capacity && !lRUCache.containsKey(key)) {
//            System.out.println("error");
//        }
//        lRUCache.put(key, value);
//        link.add(key);
//        System.out.println(lRUCache);
//    }
//
//    public static void remove() {
//        int key = link.removeFirst();
//        lRUCache.remove(key);
//    }
//
//    public static void order(Integer key) {
//        if (link.contains(key)) {
//            link.remove(key);
//        }
//        link.add(key);
//    }



}
