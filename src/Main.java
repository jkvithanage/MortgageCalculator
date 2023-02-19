import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public  static double readNumber(String prompt, double min, double max) {
        /* This method is used to get user inputs */
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

    public static String formatCurrency (double number) {
        /* Formats a number to a currency */
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(number);
    }

    public static String calculateMortgage(double principal, double monthlyRate, int numberOfPayments) {
        /* Calculate mortgage and return as a currency */
        double mortgage = principal * monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        return formatCurrency(mortgage);
    }

    public static void paymentSchedule(double principal, int numberOfPayments, double monthlyRate) {
        /* Display the payment schedule */
        for (int i = 1; i <= numberOfPayments; i++) {
            double installment = principal * (Math.pow((1 + monthlyRate), numberOfPayments) - Math.pow((1 + monthlyRate), i)) / (Math.pow((1 + monthlyRate), numberOfPayments) - 1);
            System.out.println(formatCurrency(installment));
        }
    }

    public static void main(String[] args) {
        double principal = readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        double annualRate = readNumber("Annual Interest Rate: ", 1, 30);
        int period = (int)readNumber("Period (Years): ", 1, 30);

        double monthlyRate = annualRate / 100 / 12;
        int numberOfPayments = period * 12;

        System.out.println("MORTGAGE");
        System.out.println("--------------");
        System.out.println("Monthly payments: " + calculateMortgage(principal, monthlyRate, numberOfPayments) + "\n");

        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------------");
        paymentSchedule(principal, numberOfPayments, monthlyRate);
    }
}
