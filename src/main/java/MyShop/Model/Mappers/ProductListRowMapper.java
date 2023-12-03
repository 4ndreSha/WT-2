package MyShop.Model.Mappers;

import MyShop.Model.Configs.Product.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductListRowMapper {
    public List<Product> mapRows(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        ProductRowMapper productRowMapper = new ProductRowMapper();
        while(rs.next()) {
            Product product = productRowMapper.mapRows(rs);
            products.add(product);
        }
        return products;
    }
}
