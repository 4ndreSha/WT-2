package MyShop.Web.command.Implementation;

import MyShop.Model.Configs.Product.Product;
import MyShop.Model.Dao.ProductDao;
import MyShop.Model.Dao.Implementation.JdbcProductDao;
import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class ProductDetailsCommand implements Command {
    private ProductDao productDao = JdbcProductDao.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        Product product = productDao.getProduct(id);
        request.setAttribute("tshirt", product);
        return JspPageName.PRODUCT_DETAILS_JSP;
    }
}
