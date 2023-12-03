package MyShop.Web.command.Implementation;

import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return JspPageName.REGISTER_JSP;
    }
}
