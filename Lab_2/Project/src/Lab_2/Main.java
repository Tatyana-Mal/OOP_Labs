package Lab_2;
import java.util.Scanner;
public class Main
{
    static Scanner input;
    public static void main(String[] args)
    {
        input = new Scanner(System.in);
        matrixTask();
        calculateTask();
        wordsTask();
    }
    static void matrixTask()
    {
        int[][] matrix = new int[5][5];
        System.out.print("Далее строка за строкой введите матрицу размерностью 5x5:\n");
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                matrix[j][i] = input.nextInt();
        Matrix mObject = new Matrix(matrix);
        System.out.print("Выберите изменяемую строку(2-5):\n");
        mObject.multiplyLine(input.nextInt() - 1);
        mObject.printMatrix();
    }
    static void calculateTask()
    {
        System.out.print("Через пробел введите два рабочих числа: ");
        Calculator calculator = new Calculator(input.nextDouble(), Double.parseDouble(input.nextLine()));
        System.out.print("Введите знак операции: ");
        calculator.setOperation(input.nextLine());
        System.out.print(calculator.answer());
    }
    static void wordsTask()
    {
        System.out.print("Введите обрабатываемые слова через пробел или запятую: ");
        Words words = new Words(input.nextLine());
        words.print();
    }

}