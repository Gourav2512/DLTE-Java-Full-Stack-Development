package bank.project.dao;

import java.util.Optional;

//Interface for bank operations
public interface BankOperations {
    public Customer getByUsername(String username);
    public int updateProfile(Customer customer);
}
