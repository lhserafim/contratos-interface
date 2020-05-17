package model.services;

public class PaypalService implements OnlinePaymentService{ // implementa a interface
    /*
    Quota #1:
    200 + 1% * 1 = 202 -> 1% tx juros / 1 mês
    202 + 2% = 206.04  -> 2% tx paypal
    */
    private static final double FEE_PERCENTAGE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    //
    @Override
    public double paymentFee(double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public double interest(double amount, int months) {
        return amount * MONTHLY_INTEREST * months;
    }

}
