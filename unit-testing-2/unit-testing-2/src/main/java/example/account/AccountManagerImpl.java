package example.account;

public class AccountManagerImpl implements AccountManager {
    private static final String SUCCESS = "success";
    private static final String INSUFFICIENT_BALANCE = "insufficient account balance";
    
    @Override
    public void deposit(Customer customer, int amount) {
        customer.setBalance(customer.getBalance() + amount);
    }

    @Override
    public String withdraw(Customer customer, int amount) {
        int expectedBalance = customer.getBalance() - amount;
        
        if (expectedBalance < 0) {
            return INSUFFICIENT_BALANCE;
        }
        
        customer.setBalance(expectedBalance);
        return SUCCESS;
    }
}
