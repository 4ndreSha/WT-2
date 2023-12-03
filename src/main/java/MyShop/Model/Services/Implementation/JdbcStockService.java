package MyShop.Model.Services.Implementation;

import MyShop.Model.Configs.Product.Product;
import MyShop.Model.Configs.Cart.Cart;
import MyShop.Model.Dao.ProductDao;
import MyShop.Model.Dao.Implementation.JdbcProductDao;
import MyShop.Model.Services.StockService;

public class JdbcStockService implements StockService {
    private static class SingletonHandler {
        private static final JdbcStockService INSTANCE = new JdbcStockService();
    }

    public static JdbcStockService getInstance() {
        return SingletonHandler.INSTANCE;
    }

    private ProductDao productDao = JdbcProductDao.getInstance();

    private JdbcStockService() {

    }

    @Override
    public int getAvailableQuantity(Cart cart, Long id) {
        Product product = productDao.getProduct(id);
        int existedQuantity = cart.getItems().stream()
                .filter(item -> item.getProduct().equals(product))
                .map(item -> item.getQuantity())
                .findFirst().orElse(0);
        return product.getStock() - existedQuantity;
    }
}