package MyShop.Web.command.Implementation;

import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return JspPageName.LOGIN_JSP;
    }
}
