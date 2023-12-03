package MyShop.Model.Services;

import MyShop.Model.Exceptions.OutOfStockException;
import MyShop.Model.Configs.Cart.Cart;
import jakarta.servlet.http.HttpServletRequest;

public interface CartService {
    Cart getCart(HttpServletRequest request);
    void add(Cart cart, Long id, int quantity);
    void update(Cart cart, Long id, int quantity) throws OutOfStockException;
    void delete(Cart cart, Long id);
    void clearCart(HttpServletRequest request);
}
