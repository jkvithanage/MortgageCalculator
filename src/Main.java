import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public  static double readNumber(String prompt, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double value;

        while(true) {
            System.out.print(prompt);
            value = sc.nextDouble();

            if(value >= min && value <= max)
                break;

            System.out.println("Enter a number between " + (int)min + " and " + (int)max);
        }

        return value;
    }

    public static String calculateMortgage(double principal, double annualRate, int period) {
        double monthlyRate = annualRate / 100 / 12;
        int numberOfPayments = period * 12;

        double mortgage = principal * monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(mortgage);
    }
    public static void main(String[] args) {
        double principal = readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        double annualRate = readNumber("Annual Interest Rate: ", 1, 30);
        int period = (int)readNumber("Period (Years): ", 1, 30);

        System.out.println("Mortgage: " + calculateMortgage(principal, annualRate, period));
    }
}
