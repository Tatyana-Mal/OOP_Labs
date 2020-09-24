package Lab_2;
public class Words
{
    private String[] array;
    public Words(String line)
    {
        int counter = 0;
        String[] buffer = line.split("[, ]");
        for (int i = 0; i < buffer.length; i++)
            if (buffer[i].length() > 0)
            {
                buffer[counter] = buffer[i];
                counter++;
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
