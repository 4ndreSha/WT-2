package MyShop.Web.command.Implementation;

import MyShop.Model.Dao.ProductDao;
import MyShop.Model.Dao.Implementation.JdbcProductDao;
import MyShop.Model.Dao.Sort.SortOrder;
import MyShop.Model.Dao.Sort.SortType;
import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public class ProductListCommand implements Command {
    private ProductDao productDao = JdbcProductDao.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        String search = Optional.ofNullable(request.getParameter("search")).orElse("");
        String typeParam = request.getParameter("sort");
        String orderParam = request.getParameter("order");
        SortType type = typeParam == null ? null : SortType.valueOf(typeParam);
        SortOrder order = orderParam == null ? null : SortOrder.valueOf(orderParam);
        request.setAttribute("tshirts", productDao.findProducts(search, type, order));
        return JspPageName.PRODUCT_LIST_JSP;
    }
}
