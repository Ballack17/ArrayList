package lesson5.hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int capWeight;
    static int[] sortedBox;
    static BackPack backPack;
    static BackPack bpBest;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        capWeight = in.nextInt(); // вводим предел веса
        int boxQuantity = in.nextInt(); // вводим количество коробок

        backPack = new BackPack(boxQuantity, capWeight);  // рюкзак
        bpBest = new BackPack(boxQuantity, capWeight);    //рюкзак для маневра
        sortedBox = new int[boxQuantity+1];    // для удобства индексы будут идти с 1го

        Box[] box = new Box[boxQuantity];  // генерим коробки рандомные
        for (int i = 0; i < boxQuantity; i++) {
            box[i] = new Box();
            System.out.println(box[i]);
        }

        Sorting(box); // Создаю массив где хранятся индексы коробок по возрастанию

        System.out.println();
        for (int i = 1; i < sortedBox.length; i++) {
            System.out.println(box[sortedBox[i]]);
        }
        System.out.println("\n");  //выводим что получилось


        System.out.println(backPack.fillTheBackPack(box,sortedBox,bpBest,2) + "final");
        backPack.viewBoxes(box,sortedBox); // результат итог
    }

    private static void Sorting(Box[] box) {  // Создаю массив где хранятся индексы коробок по возрастанию

        float maxCap = 1000f;
        float max = 0;
        sortedBox[0] = -1;
        for (int i = 1; i < sortedBox.length; i++) {
            for (int j = 0; j < box.length; j++) {
                if (max <= box[j].getRating() && box[j].getRating() <= maxCap && !box[j].isUsed()){
                    max = box[j].getRating();
                    box[sortedBox[i]].setUsed(false);
                    sortedBox[i] = j;
                    box[j].setUsed(true);
                }
            }
            maxCap = max;
            max = 0;
        }
        for (int i = 0; i < box.length; i++) {
            box[i].setUsed(false);
        }
    }

}

