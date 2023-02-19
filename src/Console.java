import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);
    public static double readNumber(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max) {
        /* This method is used to get user inputs */
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();

            if (value >= min && value <= max)
                break;

            System.out.println("Enter a number between " + (int) min + " and " + (int) max);
        }

        return value;
    }
}
