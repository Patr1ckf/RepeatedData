import java.util.NoSuchElementException;
import java.util.Scanner;

public class InOutHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String read(String prompt){
        System.out.println(prompt);
        try{
            return scanner.nextLine();
        }
        catch(NoSuchElementException exception){
            System.out.println("Invalid input!");
            scanner.nextLine();
            return null;
        }
    }

    public static void display(String output){
        System.out.println(output);
    }
}
