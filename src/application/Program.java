package application;

import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Programa
        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();

        // Instanciar o contrato (sem as parcelas, pq é lista) / Cabeçalho
        entities.Contract contract = new entities.Contract(number,date,totalValue);

        System.out.print("Enter number of installments: ");
        int n = sc.nextInt();

        // Lógica deste instanciamento: / Parcelas
        // O instanciamento é feito pelo serviço ContractService (pois a adição de parcelas está nele)
        // chamo ContractService informando qual é o serviço a ser usado
        ContractService contractService = new ContractService(new PaypalService());

        // Processar o contrato
        contractService.processContract(contract,n);

        // Imprimir na tela
        System.out.println("Installments:");
        for (Installment x : contract.getInstallments()) {
            System.out.println(x);
        }

        sc.close();
    }

}
