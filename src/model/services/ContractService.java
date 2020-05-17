package model.services;

import java.util.Calendar;
import java.util.Date;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    private Date addMonths(Date date, int n) {
        // Para fazer operações com datas, eu preciso usar o calendar
        Calendar cal = Calendar.getInstance(); // Instanciar o calendário
        cal.setTime(date); // carreguei a data no Calendar
        cal.add(Calendar.MONTH, n); // somando n ao mes do calendário
        return cal.getTime(); // retorna a nova data
    }
}
