package org.example;

import java.util.Scanner;

public class PersonLoan {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Scanner object to get input from user
        Integer amount,tenure;
        Double rate,emi,payable;

        System.out.println("Enter the amount:");
        amount = sc.nextInt();
        System.out.println("Enter the interest rate:");
        rate = sc.nextDouble();
        System.out.println("Enter the tenure:");
        tenure = sc.nextInt();

        tenure = tenure*12;  //Years to months
        rate = rate/(12*100);  //Calculate monthly interest
        emi = (amount*rate*Math.pow(1+rate,tenure))/(Math.pow(1+rate,tenure)-1);  //EMI formula
        payable = emi*tenure;

        System.out.println("\nMonthly EMI: "+emi);
        System.out.println("Total Interest: "+(payable-amount));
        System.out.println("Total Repayment: "+payable);

    }
}
