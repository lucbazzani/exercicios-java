package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <TaxPayer> taxpayers = new ArrayList<>();
			
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("\nTax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char payer = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if(payer == 'i') {
				System.out.print("Health expenditures: ");
				double hExpenditures = sc.nextDouble();
				taxpayers.add(new Individual(name, anualIncome, hExpenditures));
			}
			else {
				System.out.print("Number of employees: ");
				int numEmployees = sc.nextInt();
				taxpayers.add(new Company(name, anualIncome, numEmployees));
			}
		}
			
		System.out.println("\nTAXES PAID: ");
		double sum = 0.0;
		
		for(TaxPayer payer : taxpayers) {
			System.out.println(payer.getName() + ": $ " + String.format("%.2f", payer.tax()));
			sum += payer.tax();
		}
		
		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", sum));
			
		sc.close();	
	}
}
