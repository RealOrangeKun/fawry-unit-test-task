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
}
