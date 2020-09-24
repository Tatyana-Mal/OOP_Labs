package com.company;
import java.util.Scanner;
public class Main
{
    static Scanner Input;
    static int[][] Matrix = new int[5][5];
    static int Pointer;
    static double a;
    static double b;
    static String Operation;
    static String[] Words;
    public static void main(String[] args)
    {
        Input = new Scanner(System.in);
        MatrixTask();
        CalculateTask();
        WordsTask();
    }
    static void MatrixTask()
    {
        System.out.println("Далее строка за строкой введите матрицу размерностью 5x5:");
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                Matrix[j][i] = Input.nextInt();
        System.out.println("Выберите изменяемую строку(2-5):");
        Pointer = Input.nextInt() - 1;
        System.out.println("Ваша матрица:");
        for (int i = 0; i < 5; i++)
        {
            if (i == Pointer)
                for (int j = 0; j < 5; j++)
                    Matrix[j][i] *= Matrix[j][0];
            for (int j = 0; j < 5; j++)
                System.out.print(Matrix[j][i] + " ");
            System.out.println();
        }
    }
    static void CalculateTask()
    {
        System.out.print("Через пробел введите два рабочих числа: ");
        a = Input.nextDouble();
        b = Double.parseDouble(Input.nextLine());
        System.out.print("Введите знак операции: ");
        Operation = Input.nextLine();
        switch (Operation)
        {
            case "+":
                System.out.println(a + " " + Operation + " " + b + " = " + (a + b));
                break;
            case "-":
                System.out.println(a + " " + Operation + " " + b + " = " + (a - b));
                break;
            case "*":
                System.out.println(a + " " + Operation + " " + b + " = " + (a * b));
                break;
            case "/":
                System.out.println(a + " " + Operation + " " + b + " = " + (a / b));
                break;
            default:
                System.out.println("Операция недействительна");
                break;
        }
    }
    static void WordsTask()
    {
        System.out.print("Введите обрабатываемые слова через пробел или запятую: ");
        Words = Input.nextLine().split("[, ]");
        System.out.print("Все односимвольные слова: ");
        for (int i = 0; i < Words.length; i++)
            if (Words[i].length() == 1)
                System.out.print(Words[i] + " ");
        System.out.println();
    }
}
