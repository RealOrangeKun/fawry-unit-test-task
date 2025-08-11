package example.account;

public class AccountManagerImpl implements AccountManager {
    @Override
    public void deposit(Customer customer, int amount) {
        
    }

    @Override
    public String withdraw(Customer customer, int amount) {
        customer.setBalance(customer.getBalance() - amount);
        return "success";
    }
}
