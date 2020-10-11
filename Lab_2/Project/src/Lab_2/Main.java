package Lab_2;
import java.util.Scanner;
public class Main
{
    private static Matrix mObject;
    private static Calculator cObject;
    private static Words wObject;
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        matrixTask();
        System.out.print("Назовите сохраняемую матрицу: ");
        mObject.saveAs(input.nextLine());
        calculateTask();
        System.out.print("Назовите сохраняемый вычислитель: ");
        cObject.saveAs(input.nextLine());
        wordsTask();
        System.out.print("Назовите сохраняемые слова: ");
        wObject.saveAs(input.nextLine());
        System.out.print("Назовите загружаемую матрицу: ");
        new Matrix(input.nextLine()).printMatrix();
        System.out.print("Назовите загружаемый вычислитель: ");
        System.out.print(new Calculator(input.nextLine()).answer());
        System.out.print("Назовите загружаемые слова: ");
        System.out.print(new Words(input.nextLine(), true).getLine());
    }
    private static void matrixTask()
    {
        mObject = Matrix.buildMatrix();
        mObject.multiplyLine();
        mObject.printMatrix();
    }
    private static void calculateTask()
    {
        cObject = Calculator.buildCalculator();
        System.out.print(cObject.answer());
    }
    private static void wordsTask()
    {
        wObject = new Words();
        wObject.doTask();
        wObject.print();
    }
}