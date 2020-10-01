package Lab_2;

import java.io.*;
import java.util.Scanner;

public class Matrix implements Serializable
{
    static Scanner input;
    private int[][] matrix;
    private int[][] example = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
    public Matrix()
    {
        matrix = example;
    }
    public Matrix(int[][] array)
    {
        matrix = array;
    }
    public Matrix(String Name)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Name + ".mx")))
        {
            Matrix temp = (Matrix)ois.readObject();
            matrix = temp.matrix;
        }
        catch(Exception exception)
        {
            System.out.println("Объект с указанным именем не найден. Создаю базовый экземпляр.");
            matrix = example;
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
    public void saveAs(String Name)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Name + ".mx")))
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
        input = new Scanner(System.in);
        int[][] mx = new int[5][5];
        System.out.print("Далее строка за строкой введите матрицу размерностью 5x5:\n");
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                mx[i][j] = input.nextInt();
        return new Matrix(mx);
    }
    public static void printModified(int[][] array, int line)
    {
        System.out.print("Ваша матрица:\n");
        for (int i = 0; i < 5; i++)
        {
            if (i == line)
                for (int j = 0; j < 5; j++)
                    array[i][j] *= array[0][j];
            for (int j = 0; j < 5; j++)
                System.out.print(array[i][j] + " ");
            System.out.print('\n');
        }
    }
}
