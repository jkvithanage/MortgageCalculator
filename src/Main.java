import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Principal: ");
        double principal = Double.parseDouble(sc.nextLine());

        System.out.print("Annual Interest Rate: ");
        double annualRate = Double.parseDouble(sc.nextLine());

        System.out.print("Period (Years): ");
        int period = Integer.parseInt(sc.nextLine());

        double monthlyRate = annualRate / 100 / 12;
        int n = period * 12;

        double mortgage = principal * monthlyRate * Math.pow(1 + monthlyRate, n) / (Math.pow(1 + monthlyRate, n) - 1);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.print("Mortgage: " + currency.format(mortgage));
    }
}
