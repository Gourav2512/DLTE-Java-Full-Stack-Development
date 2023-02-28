package org.example;

import lombok.Data;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsWithFile  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Creating a new file
        File file = new File("transacc.txt");
        Transaction t1 = new Transaction(124,"2023-03-12","Debit",23450.0,"UPI");
        Transaction t2 = new Transaction(154,"2023-02-16","Credit",16200.0,"NEFT");
        Transaction t3 = new Transaction(122,"2023-03-01","Credit",32400.0,"UPI");
        Transaction t4 = new Transaction(287,"2023-03-25","Debit",27800.0,"RTGS");
        Transaction t5 = new Transaction(324,"2023-02-20","Debit",23450.0,"UPI");

        FileOutputStream fos=new FileOutputStream(file);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        //Adding objects to the list
        List<Transaction> list = Stream.of(t1,t2,t3,t4,t5).collect(Collectors.toList());
        System.out.println("Before Sorting:");
        list.forEach(v -> System.out.println(v));
        //Writing list to the file
        oos.writeObject(list);
        oos.close();
        fos.close();

        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);
        //Reading the data from the file
        List<Transaction> readList=(List<Transaction>) ois.readObject();
        ois.close();
        fis.close();

        //Sorting the list by date
        Collections.sort(readList, new SortByDate());
        System.out.println("\nAfter Sorting (By Date):");
        readList.forEach(v -> System.out.println(v));
    }
}

@Data
class Transaction implements Serializable{
    private Integer id;
    private String date;
    private  String type;
    private Double amount;
    private String mode;

    public Transaction(Integer id, String date, String type, Double amount, String mode) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.mode = mode;
    }

    public String getDate() {
        return date;
    }
}

class SortByDate implements Comparator<Transaction>{

    public int compare(Transaction o1, Transaction o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}
