package MyShop.Model.Services;

import MyShop.Model.Configs.Cart.Cart;

public interface StockService {
    int getAvailableQuantity(Cart cart, Long id);
}
