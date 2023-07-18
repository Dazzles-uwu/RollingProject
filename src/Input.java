import java.util.Scanner;

public class Input {

    public Input() {

    }

    public char acceptCharInput(String message, int index)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println(message);
        return keyboard.nextLine().charAt(index);
    }

    public double acceptDoubleInput(String message)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println(message);
        return Double.parseDouble(keyboard.nextLine());
    }

    public int acceptIntegerInput(String message)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println(message);
        return Integer.parseInt(keyboard.nextLine());
    }

    public String acceptStringInput(String message)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println(message);
        return keyboard.nextLine();
    }
}
