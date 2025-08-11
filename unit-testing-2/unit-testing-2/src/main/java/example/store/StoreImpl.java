package example.store;

import example.account.AccountManager;
import example.account.Customer;

public class StoreImpl implements Store {
    AccountManager accountManager;
    
    public StoreImpl(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
    
    @Override
    public void buy(Product product, Customer customer) {
        product.setQuantity(product.getQuantity() - 1);
    }
}
