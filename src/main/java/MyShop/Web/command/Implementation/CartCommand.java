package MyShop.Web.command.Implementation;

import MyShop.Model.Services.CartService;
import MyShop.Model.Services.Implementation.HttpSessionCartService;
import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class CartCommand implements Command {
    private CartService cartService = HttpSessionCartService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("cart", cartService.getCart(request));
        return JspPageName.CART_JSP;
    }
}
