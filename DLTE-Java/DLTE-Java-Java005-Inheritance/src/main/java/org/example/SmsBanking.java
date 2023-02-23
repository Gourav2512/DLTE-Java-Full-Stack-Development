package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SmsBanking {
    public static void main(String[] args) {
        Transaction obj = new Transaction();
        obj.enquiry();
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor

class Kyc{
    private String name;
    private String accno;
    private Integer balance;

}

class Transaction extends Kyc{
    public void enquiry(){
        System.out.print();

    }
    public void recharge(){

    }
    public void booking(){

    }
}
