package MyShop.Web.command.Implementation;

import MyShop.Model.Dao.OrderDao;
import MyShop.Model.Dao.Implementation.JdbcOrderDao;
import MyShop.Model.Configs.Order.Order;
import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;

public class OrderOverviewCommand implements Command {
    private OrderDao orderDao = JdbcOrderDao.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String secureId = request.getParameter("secureId");
        Order order;
        try {
            order = orderDao.getOrderBySecureId(secureId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("order", order);
        return JspPageName.ORDER_OVERVIEW_JSP;
    }
}
