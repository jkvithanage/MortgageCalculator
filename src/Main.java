import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Principal ($1K - $1M): ");
        double principal = sc.nextDouble();

        while (principal < 1000 || principal > 1_000_000) {
            System.out.println("Enter a number between 1,000 and 1,000,000");

            System.out.print("Principal ($1K - $1M): ");
            principal = sc.nextDouble();
        }

        System.out.print("Annual Interest Rate: ");
        double annualRate = sc.nextDouble();

        while (annualRate <= 0 || annualRate >= 30) {
            System.out.println("Enter a value greater than 0 and less than or 30");

            System.out.print("Annual Interest Rate: ");
            annualRate = sc.nextDouble();
        }

        System.out.print("Period (Years): ");
        int period = sc.nextInt();

        while (period <= 0 || period > 30) {
            System.out.println("Enter a value between 1 and 30");

            System.out.print("Period (Years): ");
            period = sc.nextInt();
        }

        double monthlyRate = annualRate / 100 / 12;
        int n = period * 12;

        double mortgage = principal * monthlyRate * Math.pow(1 + monthlyRate, n) / (Math.pow(1 + monthlyRate, n) - 1);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.print("Mortgage: " + currency.format(mortgage));
    }
}
