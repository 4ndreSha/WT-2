package MyShop.Model.Mappers;

import MyShop.Model.Configs.Cart.CartItem;
import MyShop.Model.Dao.ProductDao;
import MyShop.Model.Dao.Implementation.JdbcProductDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsRowMapper {
    private ProductDao productDao = JdbcProductDao.getInstance();
    public List<CartItem> mapRows(ResultSet rs) throws SQLException {
        List<CartItem> cartItems = new ArrayList<>();
        while (rs.next()) {
            CartItem item = new CartItem();
            item.setQuantity(rs.getInt("quantity"));
            item.setProduct(productDao.getProduct(rs.getLong("tshirtId")));
            cartItems.add(item);
        }
        return cartItems;
    }
}
