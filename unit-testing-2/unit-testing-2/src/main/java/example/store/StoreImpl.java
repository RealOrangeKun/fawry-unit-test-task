package example.store;

import example.account.AccountManager;
import example.account.Customer;

public class StoreImpl implements Store {
    private static final String SUCCESS = "success";
    private static final String OUT_OF_STOCK_MESSAGE = "Product out of stock";
    private static final String PAYMENT_FAILURE_MESSAGE = "Payment failure: ";
    
    private final AccountManager accountManager;
    
    public StoreImpl(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
    
    @Override
    public void buy(Product product, Customer customer) {
        if (isOutOfStock(product)) {
            throw new RuntimeException(OUT_OF_STOCK_MESSAGE);
        }
        
        String status = accountManager.withdraw(customer, product.getPrice());
        if (!SUCCESS.equals(status)) {
            throw new RuntimeException(PAYMENT_FAILURE_MESSAGE + status);
        }
        
        decreaseProductQuantity(product);
    }
    
    private boolean isOutOfStock(Product product) {
        return product.getQuantity() == 0;
    }
    
    private void decreaseProductQuantity(Product product) {
        product.setQuantity(product.getQuantity() - 1);
    }
}
