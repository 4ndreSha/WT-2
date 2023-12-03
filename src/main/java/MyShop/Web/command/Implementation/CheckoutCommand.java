package MyShop.Web.command.Implementation;

import MyShop.Model.Configs.Order.Order;
import MyShop.Model.Services.CartService;
import MyShop.Model.Services.OrderService;
import MyShop.Model.Services.Implementation.HttpSessionCartService;
import MyShop.Model.Services.Implementation.JdbcOrderService;
import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class CheckoutCommand implements Command {
    private CartService cartService = HttpSessionCartService.getInstance();
    private OrderService orderService = JdbcOrderService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Order order = orderService.getOrder(cartService.getCart(request));
        request.setAttribute("order", order);
        return JspPageName.CHECKOUT_JSP;
    }
}
