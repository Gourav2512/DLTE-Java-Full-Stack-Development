package org.example;

import java.util.Arrays;
import java.util.Scanner;
//User defined exception
class OutstandingException extends Exception{
    public OutstandingException(String err){
        super(err);
    }
}

public class OutstandingBalance {
    //Method to add bills
    static void addBalance(Integer[] balances,Integer amount,Integer index) throws OutstandingException {
        if (index >= balances.length) {
            throw new OutstandingException("Outstanding balance: Replaced with the minimum bill");
        } else {
            balances[index] = amount;
        }
    }
    //Alternate method to replace with minimum bill
    static void replaceMin(Integer[] balances,Integer amount){
        Integer index = 0;
        Integer min = balances[index];
        for (int i = 1; i < balances.length; i++){
            if (balances[i] <= min){
                min = balances[i];
                index = i;
            }
        }
        balances[index] = amount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer balances[] = new Integer[10];
        Integer amount;
        for (int i=0;i<12;i++){
            System.out.println("Enter the outstanding bill:");
            amount = sc.nextInt();
            try {

                addBalance(balances,amount,i);
                System.out.println(Arrays.toString(balances));

            }
            catch (OutstandingException e){
                System.out.println("Exception occured: " + e);
                replaceMin(balances,amount);
                System.out.println(Arrays.toString(balances));
            }
        }
    }
}
