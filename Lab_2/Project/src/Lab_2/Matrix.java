package Lab_2;

import java.io.*;
import java.util.Scanner;

public class Matrix implements Serializable
{
    private static Scanner input = new Scanner(System.in);
    private int[][] matrix;
    public Matrix()
    {
        matrix = new int[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                matrix[i][j] = j;
    }
    public Matrix(int[][] array)
    {
        matrix = array;
    }
    public Matrix(String name)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name + ".mx")))
        {
            Matrix temp = (Matrix)ois.readObject();
            matrix = temp.matrix;
        }
        catch(Exception exception)
        {
            System.out.println("Объект с указанным именем не найден. Создаю базовый экземпляр.");
            matrix = new int[5][5];
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++)
                    matrix[i][j] = j;
        }
    }
    public void multiplyLine()
    {
        System.out.print("Выберите изменяемую строку(2-5):\n");
        int line = input.nextInt() - 1;
        for (int i = 0; i < 5; i++)
            matrix[line][i] *= matrix[0][i];
    }
    public void printMatrix()
    {
        System.out.print("Ваша матрица:\n");
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print('\n');
        }
    }
    public void saveAs(String name)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name + ".mx")))
        {
            oos.writeObject(this);
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
    public int[][] getMatrix()
    {
        return matrix;
    }
    public static Matrix buildMatrix()
    {
        int[][] mx = new int[5][5];
        System.out.print("Далее строка за строкой введите матрицу размерностью 5x5:\n");
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                mx[i][j] = input.nextInt();
        return new Matrix(mx);
    }
}
