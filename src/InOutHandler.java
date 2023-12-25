import java.util.Scanner;

public class InOutHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String read(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static void display(String output){
        System.out.println(output);
    }
}
