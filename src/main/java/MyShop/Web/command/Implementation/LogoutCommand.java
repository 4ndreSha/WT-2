package MyShop.Web.command.Implementation;

import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return JspPageName.LOGIN_JSP;
    }
}
