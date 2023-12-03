package MyShop.Model.Services;

import MyShop.Model.Configs.Cart.Cart;
import MyShop.Model.Configs.Order.Order;

import java.sql.SQLException;

public interface OrderService {
    Order getOrder(Cart cart);
    void placeOrder(Order order) throws SQLException;
}
