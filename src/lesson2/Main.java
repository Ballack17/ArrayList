package lesson2;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        /*
        * Testing of autoexpanse
         */
        MyArrayList<Integer> mal = new MyArrayList<>(10);
        Random rand = new Random();
        System.out.println(mal.getCapacity());
        System.out.println(mal.size());
        for (int i = 0; i <11 ; i++) {
            mal.add(rand.nextInt(100));
        }
        mal.add(55);
        System.out.println(mal.size());
        System.out.println(mal);
        mal.add(66);
        mal.add(66);mal.add(66);mal.add(66);mal.add(66);mal.add(66);mal.add(66);mal.add(99);
        System.out.println(mal.size());
        System.out.println(mal.getCapacity());
        mal.add(10,105);
        System.out.println(mal);

        /*
        * Time testing + Sorted methods with comparator
         */
        long beginTime = System.nanoTime();
//      mal.bubbleSort();                                     //40   seconds
        mal.selectionSort(Comparator.reverseOrder());         //20   seconds
//      mal.insertionSort(Comparator.reverseOrder());         //12.5 seconds
//      mal.bubbleSort(Comparator.reverseOrder());
        long deltaTime = System.nanoTime() - beginTime;
        System.out.println(deltaTime * 1e-9f);
        System.out.println(mal);

        /*
        * Testing of autoExpans on SortedList
         */
        MySortedArrayList<Integer> msal = new MySortedArrayList<>();
        Random rand1 = new Random();
        System.out.println(msal.getCapacity());
        System.out.println(msal.size());
        for (int i = 0; i <10 ; i++) {
            msal.add(rand1.nextInt(100));
        }
        System.out.println(msal);
        msal.add(50);
        System.out.println(msal.getCapacity());
        System.out.println(msal.size());
        System.out.println(msal);


//        MyArrayList<String> myArrayList = new MyArrayList<>();
//        myArrayList.add("aaa");
//        myArrayList.add("BBB");
//        myArrayList.add("bbbbbbb");
//        myArrayList.add("ccc");
//        myArrayList.add("AAAAA");
//        myArrayList.add("xxx");
//        myArrayList.add("YYYyy");

//        System.out.println(myArrayList);
//        myArrayList.bubbleSort(Comparator.naturalOrder());
//        myArrayList.bubbleSort(Comparator.comparingInt(String::length));
//        myArrayList.bubbleSort(Comparator.comparingInt(String::length).reversed());
//        myArrayList.bubbleSort(Comparator.comparingInt(String::length).thenComparing(String::compareToIgnoreCase));
 //       System.out.println(myArrayList);
    }

}
