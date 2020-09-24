package Lab_2;
public class Calculator
{
    private double a;
    private double b;
    private String operation;
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
    public void setOperation(String operator)
    {
        operation = operator;
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
