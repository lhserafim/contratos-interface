package model.services;

import model.entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    // Colocar lógica p/ calcular vencimentos e taxas
    public void processContract(entities.Contract contract, int months) {
        double basicQuota = contract.getTotalValue() / months;
        // Fazer for p/ poder trabalhar com parcelas
        for (int i = 1; i <= months; i++) {
            // Achar datas de vencimentos
            Date date = addMonths(contract.getDate(), i);
            double updatedQuota = onlinePaymentService.interest(basicQuota,i);
            double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
            // Instanciar - injeção
            contract.addInstallment(new Installment(date, fullQuota));
        }
    }

    private Date addMonths(Date date, int n) {
        // Para fazer operações com datas, eu preciso usar o calendar
        Calendar cal = Calendar.getInstance(); // Instanciar o calendário
        cal.setTime(date); // carreguei a data no Calendar
        cal.add(Calendar.MONTH, n); // somando n ao mes do calendário
        return cal.getTime(); // retorna a nova data
    }
}
