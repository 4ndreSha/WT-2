package MyShop.Web.command.Implementation;

import MyShop.Model.Configs.Cart.Cart;
import MyShop.Model.Services.CartService;
import MyShop.Model.Services.Implementation.HttpSessionCartService;
import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteCartItemCommand implements Command {
    private CartService cartService = HttpSessionCartService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Long tshirtId = Long.parseLong(request.getParameter("tshirtId"));
        Cart cart = cartService.getCart(request);
        cartService.delete(cart, tshirtId);
        request.setAttribute("deleted", true);
        return JspPageName.CART_JSP;
    }
}
