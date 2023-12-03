package MyShop.Model.Dao;

import MyShop.Model.Dao.Sort.SortOrder;
import MyShop.Model.Dao.Sort.SortType;
import MyShop.Model.Configs.Product.Product;

import java.util.List;

public interface ProductDao {
    Product getProduct(Long id);

    List<Product> findProducts(String search, SortType type, SortOrder order);

    void save(Product product);

    void delete(Long id);
}
