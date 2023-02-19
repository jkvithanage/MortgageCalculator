public class MortgageCalculator {
    public static final byte MONTHS_IN_YEAR = 12;
    public static final byte PERCENT = 100;
    private final double principal;
    private final float annualInterest;
    private final byte period;

    public MortgageCalculator(double principal, float annualInterest, byte period) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.period = period;
    }

    private byte getNumberOfPayments() {
        return (byte) (this.period * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterest() {
        return this.annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    public double calculateMortgage() {
        return principal * getMonthlyInterest() * Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        return principal * (Math.pow((1 + getMonthlyInterest()), getNumberOfPayments()) - Math.pow((1 + getMonthlyInterest()), numberOfPaymentsMade)) / (Math.pow((1 + getMonthlyInterest()), getNumberOfPayments()) - 1);
    }

    public double[] getRemainingBalance() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= getNumberOfPayments(); month++) balances[month - 1] = calculateBalance(month);
        return balances;
    }
}
