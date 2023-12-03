package MyShop.Web.command.Implementation;

import MyShop.Model.Configs.Cart.Cart;
import MyShop.Model.Services.CartService;
import MyShop.Model.Services.Implementation.HttpSessionCartService;
import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class MinicartCommand implements Command {
    private CartService cartService = HttpSessionCartService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Cart cart = cartService.getCart(request);
        request.setAttribute("cart", cart);
        return JspPageName.MINI_CART_JSP;
    }
}
