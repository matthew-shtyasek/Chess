package ru.yana;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Vvedite operaciyu: ");
        char sym = in.next().charAt(0);
        System.out.print("Vvedite 1 znachenie: ");
        int x = in.nextInt();
        System.out.print("Vvedite 2 znachenie: ");
        int y = in.nextInt();

        in.close();

        double rez;

        switch (sym) {
            case '+':
                rez = x+y;
                break;
            case '-':
                rez = x-y;
                break;
            case '*':
                rez = x*y;
                break;
            case '/':
                rez = (double)x/y;
                break;
            case '%':
                rez = x%y;
                break;
            default:
                System.out.print("Nevernii simvol");
                return;
        }

        System.out.print("Rezul'tat: " + rez);
    }
}
