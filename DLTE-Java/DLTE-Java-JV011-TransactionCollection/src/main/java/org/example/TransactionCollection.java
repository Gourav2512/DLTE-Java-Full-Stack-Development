package org.example;

import java.util.Hashtable;
import java.util.LinkedList;

public class TransactionCollection {
    public static void main(String[] args) {

        Transaction  t1 = new Transaction(100,"debit","UPI",12000.0,"28/02/23");
        Transaction  t2 = new Transaction(101,"credit","UPI",8000.0,"03/03/23");
        Transaction  t3 = new Transaction(102,"credit","RTGS",15000.0,"01/03/23");
        Transaction  t4 = new Transaction(103,"debit","NEFT",4000.0,"24/03/23");
        LinkedList<Transaction> trans = new LinkedList<>();
        trans.add(t1);
        trans.add(t2);
        trans.add(t3);
        trans.add(t4);
        switch (choice){
            case 1:
                System.out.println("Enter the name");
        }



    }
}

class Transaction{
    private Integer id;
    private String type;
    private String mode;
    private Double amount;
    private String date;

    public Transaction(Integer id, String type, String mode, Double amount, String date) {
        this.id = id;
        this.type = type;
        this.mode = mode;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", mode='" + mode + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}'+"\n";
    }
}
