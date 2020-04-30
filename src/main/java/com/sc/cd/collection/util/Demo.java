package com.sc.cd.collection.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo {
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(111);
        copyOnWriteArrayList.add(2222);
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List linkedList = new LinkedList();
        linkedList.add(0);
        linkedList.add(1);
        System.out.println(linkedList);
        LinkedList list = new LinkedList();
        System.out.println(list.getFirst());
    }
}
