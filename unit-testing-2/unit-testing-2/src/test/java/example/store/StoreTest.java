package example.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import example.account.AccountManager;
import example.account.Customer;

public class StoreTest {
    
    @Test
    void testBuyProduct() {
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(4);
        Customer customer = new Customer();
        
        store.buy(product, customer);
        
        Assertions.assertEquals(3, product.getQuantity());
    }
}
