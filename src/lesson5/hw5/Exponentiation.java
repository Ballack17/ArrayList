package lesson5.hw5;

import java.io.PrintWriter;
import java.util.Scanner;

public class Exponentiation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long number = in.nextInt();
        int power = in.nextInt();

        long beginTime = System.nanoTime();
        System.out.println(Exponentiation(number, power));
        System.out.println(ExponentiationDiv(number, power));
        long deltaTime = System.nanoTime() - beginTime;
        System.out.println(deltaTime * 1e-9f*1000000000);
        // время обоими способами в целом одинаковое




    }

    public static long Exponentiation(long x, int y) {
        if (y == 0) return 1;
        else if (y == 1)
        return x;
        else {
            return Exponentiation(x, y - 1) * x;
        }
    }
    public static long ExponentiationDiv (long x, int y) {
        if (y == 0) return 1;
        else if (y <= 4)
            return Exponentiation(x,y);
        else {
            return ExponentiationDiv(x, y/2) * ExponentiationDiv(x, y/2 + y%2) ;
        }
    }
}
