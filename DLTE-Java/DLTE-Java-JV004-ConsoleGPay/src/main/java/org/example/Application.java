package org.example;

import java.util.Scanner;

class Gpay{
    Scanner sc = new Scanner(System.in);

    private String accno;
    private  Integer balance;
    private Integer upi;
    private String name;

    //Constructor
    public Gpay(String accno, Integer balance, Integer upi, String name) {
        this.accno = accno;
        this.balance = balance;
        this.upi = upi;
        this.name = name;
    }
    //Fund Transfer Method
    public void fundTransfer(String recep, Integer amount){
        if(amount>this.balance){
            System.out.println("Insufficient balance...");
            return;
        }
        System.out.println("Enter the UPI pin: ");
        if(this.upi==sc.nextInt()){
            System.out.println(amount+" transferred to "+recep);
        }
        else {
            System.out.println("Invalid UPI pin");
        }
    }
    //Method Overloading
    public void recharge(Long number, Integer amount){
        if(amount>this.balance){
            System.out.println("Insufficient balance...");
            return;
        }
        System.out.println("Enter the UPI pin: ");
        if(this.upi==sc.nextInt()){
            System.out.println(number+" successfully recharged with "+amount);
        }
        else {
            System.out.println("Invalid UPI pin");
        }
    }

    public void recharge(String vehicle, Integer amount){
        if(amount>this.balance){
            System.out.println("Insufficient balance...");
            return;
        }
        System.out.println("Enter the UPI pin: ");
        if(this.upi==sc.nextInt()){
            System.out.println("FASTag for "+vehicle+" successfully recharged with "+amount);
        }
        else {
            System.out.println("Invalid UPI pin");
        }
    }
}

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer amount;
        Gpay user = new Gpay("123456789",5000,4321,"Gourav");
        System.out.println("1. Fund Transfer\n2. Mobile Recharge\n3. FASTag Recharge\nEnter your choice:");
        switch (sc.nextInt()){
            case 1: sc.nextLine();
                    System.out.println("Enter the name:");
                    String recep = sc.nextLine();
                    System.out.println("Enter the amount:");
                    amount = sc.nextInt();
                    user.fundTransfer(recep,amount);
                    break;
            case 2: System.out.println("Enter the mobile number:");
                    Long number = sc.nextLong();
                    System.out.println("Enter the amount:");
                    amount = sc.nextInt();
                    user.recharge(number,amount);
                    break;
            case 3: System.out.println("Enter the vehicle number:");
                    sc.nextLine();
                    String vehicle = sc.nextLine();
                    System.out.println("Enter the amount:");
                    amount = sc.nextInt();
                    user.recharge(vehicle,amount);
                    break;
            default: System.out.println("Invalid Choice");
        }
    }
}

