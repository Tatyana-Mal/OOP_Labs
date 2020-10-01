package Lab_2;
import java.util.Scanner;
public class Main
{
    static Scanner input;
    static Matrix mObject;
    public static void main(String[] args)
    {
        input = new Scanner(System.in);
        matrixTask();
        calculateTask();
        wordsTask();
    }
    static void matrixTask()
    {
        mObject = Matrix.buildMatrix();
        mObject.multiplyLine();
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