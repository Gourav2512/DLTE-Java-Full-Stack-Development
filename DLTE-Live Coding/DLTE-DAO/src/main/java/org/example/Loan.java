package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private int id;
    private String borrower;
    private String type;
    private int amount;
    private Date date;
}
