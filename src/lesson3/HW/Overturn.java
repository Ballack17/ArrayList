package lesson3.HW;

import lesson3.MyStack;

import java.util.Scanner;

public class Overturn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        String a = in.nextLine();
        String[] b = a.split("");
        MyStack ms = new MyStack(b.length);

        for (int i = 0; i < b.length ; i++) {
            ms.push(b[i]);
        }

        while (ms.size()!=0) {
            System.out.print(ms.pop());
        }
    }
}
