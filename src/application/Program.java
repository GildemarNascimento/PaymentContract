package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractServices;
import services.PaypalService;

public class Program {
	public static void main(String []Args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();
		System.out.print("Enter number installments: ");
		int months = sc.nextInt();
		Contract contract = new Contract(number, date, totalValue);
		ContractServices cs = new ContractServices(new PaypalService());
		cs.processContract(contract, months);
		
		System.out.println("Installments: ");
		
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		sc.close();
	}
}
