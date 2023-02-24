package org.example;

import java.util.Arrays;
import java.util.Scanner;

class OutsdandingException extends Exception{
    public OutsdandingException(String err){
        super(err);
    }
}

public class OutstandingBalance {
    static void addBalance(Integer[] balances,Integer amount,Integer index) throws OutsdandingException {
        if (index >= balances.length) {
            throw new OutsdandingException("Outsdanding balance");
        } else {
            balances[index] = amount;
        }
    }
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
        Integer balances[] = new Integer[5];
        Integer amount;
        for (int i=0;i<7;i++){
            amount = sc.nextInt();
            try {

                addBalance(balances,amount,i);
            }
            catch (OutsdandingException e){
                System.out.println("Exception occured: " + e);

                replaceMin(balances,amount);
                System.out.println(Arrays.toString(balances));
            }

    }



    }

}
