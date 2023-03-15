package org.example;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Operations obj = new Operations();
        boolean mainMenu = true;
        do{
            System.out.println("\n1. Insert Data\n2. Delete Data\n3. Display Data\n4. Exit\nEnter your choice:");
            switch (scanner.nextInt()){
                case 1:
                    obj.insertData();
                    break;
                case 2:
                    obj.deleteData();
                    break;
                case 3:
                    obj.displayData();
                    break;
                case 4:
                    mainMenu = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while (mainMenu);
    }
}
