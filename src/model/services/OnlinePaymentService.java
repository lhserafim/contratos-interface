package model.services;

public interface OnlinePaymentService {
    // Determinar o contrato
    // Vantagem de se usar interface, baixo acoplamento
    double interest(double amount, int months);
    double paymentFee(double amount);
}
