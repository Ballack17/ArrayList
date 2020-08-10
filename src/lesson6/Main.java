package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        MyTreeMap<Integer, String> map = new MyTreeMap<>();
//
//        map.put(5,"five");
//        map.put(1,"one");
//        map.put(3,"three");
//        map.put(2,"two");
//
//        System.out.println(map);
//        System.out.println(map.get(2));
//        map.put(2,"ttt");
//        System.out.println(map);
//
//        map.deleteMin();
//        System.out.println(map);

        Random random = new Random();
        int countTree = 100000;
        int balCount = 0;

        for (int i = 0; i < countTree; i++) {
            MyTreeMap1<Integer, Integer> map = new MyTreeMap1<>();
            int x = 0;
            while (map.height() < 6) {
                x = random.nextInt(200) - 100;
                map.put(x, x);
            }
            map.delete(x);
            if (map.isBalance()) {
                balCount++;
            }
        }
        System.out.println("balCount " + balCount + " countTree " + countTree);
        System.out.println("balanced " + (double) balCount / countTree * 100 + " %");
        System.out.println("no balanced " + (double) (countTree - balCount) / countTree * 100 + " %");

    }
}
