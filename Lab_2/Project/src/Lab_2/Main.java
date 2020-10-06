package Lab_2;
public class Main
{
    private static Matrix mObject;
    private static Calculator cObject;
    private static Words wObject;
    public static void main(String[] args)
    {
        matrixTask();
        calculateTask();
        wordsTask();
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