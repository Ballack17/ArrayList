package lesson3;

import lesson3.HW.MyDeck;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(3);  //recopacity check
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (int i = 0; i <5 ; i++) {
            System.out.println(stack.pop());
        }

//        Expression e = new Expression("(4-6)+[{67+45} * {a / b}]");
//        System.out.println(e.checkBracket());


//        MyQueue<Integer> queue = new MyQueue<>();
//        queue.insert(1);
//        queue.insert(2);
//        queue.insert(3);
//
//        System.out.println(queue);
//
//        for (int i = 0; i < 3 ; i++) {
//            System.out.println(queue.remove());
//        }


        MyDeck<Integer> md = new MyDeck<>();  //MyDeck test

        md.insertLeft(5);
        md.insertLeft(1);
        md.insertRigth(7);
        md.insertRigth(4);
        md.insertRigth(2);


        System.out.println(md);
        System.out.println(md.peekLeft());
        System.out.println(md.peekRigth());
        System.out.println(md.removeLeft());
        System.out.println(md.removeLeft());
        md.insertLeft(1);
        md.insertRigth(7);
        System.out.println(md);

        MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>(Comparator.reverseOrder());
                //comparator check
        mpq.insert(6);
        mpq.insert(26);
        mpq.insert(4);
        mpq.insert(15);
        mpq.insert(4);
        mpq.insert(1);

        System.out.println(mpq);

    }
}
