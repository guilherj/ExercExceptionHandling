package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = teclado.nextInt();

		System.out.print("Holder: ");
		teclado.nextLine();
		String holder = teclado.nextLine();

		System.out.print("Initial Balance: ");
		double balance = teclado.nextDouble();

		System.out.print("Withdraw Limit: ");
		double withdrawLimit = teclado.nextDouble();

		Account account = new Account(number, holder, balance, withdrawLimit);
		
		try {
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = teclado.nextDouble();

			account.withdraw(amount);

			System.out.println();
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));

		} catch (DomainException e) {
			
			System.out.println(e.getMessage());
		
		} finally {
			
			System.out.println();
			System.out.print("Enter amount for Deposit: ");
			double amount = teclado.nextDouble();
			
			account.deposit(amount);
			
			System.out.println("New Balance:" + account.getBalance());
			System.out.println();
			
			System.out.println("FIM DO PROGRAMA");
			teclado.close();
		}
	}

}
