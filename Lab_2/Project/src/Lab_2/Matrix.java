package Lab_2;
public class Matrix
{
    private int[][] matrix;
    public Matrix(int[][] array)
    {
        matrix = array;
    }
    public void multiplyLine(int line)
    {
        for (int i = 0; i < 5; i++)
            matrix[i][line] *= matrix[i][0];
    }
    public void printMatrix()
    {
        System.out.print("Ваша матрица:\n");
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
                System.out.print(matrix[j][i] + " ");
            System.out.print('\n');
        }
    }
    public static void printModified(int[][] array, int line)
    {
        System.out.print("Ваша матрица:\n");
        for (int i = 0; i < 5; i++)
        {
            if (i == line)
                for (int j = 0; j < 5; j++)
                    array[j][i] *= array[j][0];
            for (int j = 0; j < 5; j++)
                System.out.print(array[j][i] + " ");
            System.out.print('\n');
        }
    }
}
