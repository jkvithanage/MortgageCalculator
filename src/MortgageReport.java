import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        System.out.println("MORTGAGE");
        System.out.println("--------------");

        double mortgage = calculator.calculateMortgage();
        System.out.println("Monthly payments: " + currency.format(mortgage) + "\n");
    }

    public void printPaymentSchedule() {
        /* Display the payment schedule */
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------------");


        var balances = calculator.getRemainingBalance();
        for (double balance: balances) {
            System.out.println(currency.format(balance));
        }
    }
}
