package example.account;

public class AccountManagerImpl implements AccountManager {
    @Override
    public void deposit(Customer customer, int amount) {
        customer.setBalance(customer.getBalance() + amount);
    }

    @Override
    public String withdraw(Customer customer, int amount) {
        int expectedBalance = customer.getBalance() - amount;
        
        if (expectedBalance < 0) {
            return "insufficient account balance";
        }
        
        customer.setBalance(expectedBalance);
        return "success";
    }
}
