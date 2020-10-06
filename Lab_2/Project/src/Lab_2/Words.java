package Lab_2;
import java.io.*;
import java.util.Scanner;

public class Words implements Serializable
{
    private String line;
    private String[] array;
    private static Scanner input = new Scanner(System.in);
    public Words()
    {
        System.out.print("Введите обрабатываемые слова через пробел или запятую: ");
        line = input.nextLine();
    }
    public Words(String line)
    {
        this.line = line;
    }
    public Words(String name, boolean check)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name + ".ws")))
        {
            Words temp = (Words)ois.readObject();
            line = temp.getLine();
        }
        catch(Exception exception)
        {
            System.out.println("Объект с указанным именем не найден. Создаю базовый экземпляр.");
            line = "o,iho n w,e,voj mqi v,bps gb,n";
        }
    }
    public void saveAs(String name)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name + ".ws")))
        {
            oos.writeObject(this);
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
    public String getLine()
    {
        return line;
    }
    public String[] getArray()
    {
        return array;
    }
    public void doTask()
    {
        int counter = 0;
        String[] buffer = line.split("[, ]");
        for (int i = 0; i < buffer.length; i++)
            if (buffer[i].length() == 1)
            {
                buffer[counter] = buffer[i];
                counter++;
                System.out.println("counter = " + counter);
            }
        array = new String[counter];
        for (int i = 0; i < counter; i++)
            array[i] = buffer[i];
    }
    public void print()
    {
        System.out.print("Все односимвольные слова: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + ' ');
        System.out.println();
    }
}
