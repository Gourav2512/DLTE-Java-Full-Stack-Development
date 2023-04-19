package bank.project.dao;

import java.util.Optional;

public interface BankOperations {
    public Customer getByUsername(String username);
    public int updateProfile(Customer customer);
}
