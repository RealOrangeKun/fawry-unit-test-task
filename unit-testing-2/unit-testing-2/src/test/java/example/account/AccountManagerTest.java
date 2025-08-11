package example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {
    
    @Test
    void testWithdrawWithSufficientBalance() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);
        
        String result = am.withdraw(c, 500);
        
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(500, c.getBalance());
    }
    
    @Test
    void testWithdrawWithInsufficientBalance() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        
        String result = am.withdraw(c, 200);
        
        Assertions.assertEquals("insufficient account balance", result);
        Assertions.assertEquals(100, c.getBalance());
    }
    
    @Test
    void testDeposit() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        
        am.deposit(c, 50);
        
        Assertions.assertEquals(150, c.getBalance());
    }
}
