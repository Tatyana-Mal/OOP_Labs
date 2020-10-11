package Lab_2;
import java.io.*;
import java.util.Scanner;
public class Calculator implements Serializable
{
    private double a;
    private double b;
    private String operation;
    private static Scanner input = new Scanner(System.in);
    public Calculator()
    {
        a = 5;
        b = 6;
        operation = "*";
    }
    public Calculator(double operandA, double operandB, String operator)
    {
        a = operandA;
        b = operandB;
        operation = operator;
    }
    public Calculator(double operandA, double operandB)
    {
        a = operandA;
        b = operandB;
    }
    public Calculator(String name)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name + ".clc")))
        {
            Calculator temp = (Calculator)ois.readObject();
            a = temp.getOperandA();
            b = temp.getOperandB();
            operation = temp.getOperation();
        }
        catch(Exception exception)
        {
            System.out.println("Объект с указанным именем не найден. Создаю базовый экземпляр.");
            a = 5;
            b = 6;
            operation = "+";
        }
    }
    public double getOperandA()
    {
        return a;
    }
    public double getOperandB()
    {
        return b;
    }
    public String getOperation()
    {
        return operation;
    }
    public void setOperands(double operandA, double operandB)
    {
        a = operandA;
        b = operandB;
    }
    public void setOperation(String operator)
    {
        operation = operator;
    }
    public void saveAs(String name)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name + ".clc")))
        {
            oos.writeObject(this);
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
    public static Calculator buildCalculator()
    {
        System.out.print("Через пробел введите два рабочих числа: ");
        Calculator calculator = new Calculator(input.nextDouble(), Double.parseDouble(input.nextLine()));
        System.out.print("Введите знак операции: ");
        calculator.setOperation(input.nextLine());
        return calculator;
    }
    public String answer()
    {
        switch (operation)
        {
            case "+":
                return a + " " + operation + " " + b + " = " + (a + b) + '\n';
            case "-":
                return a + " " + operation + " " + b + " = " + (a - b) + '\n';
            case "*":
                return a + " " + operation + " " + b + " = " + (a * b) + '\n';
            case "/":
                return a + " " + operation + " " + b + " = " + (a / b) + '\n';
            default:
                return "Операция недействительна\n";
        }
    }
}
