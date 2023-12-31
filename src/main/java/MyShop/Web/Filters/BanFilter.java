package MyShop.Web.Filters;

import MyShop.Model.Exceptions.BannedUserException;
import MyShop.Model.Configs.User.User;
import MyShop.Model.Configs.User.UserStatus;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Optional;

public class BanFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String command = httpServletRequest.getParameter("command");
        if(Optional.ofNullable((User) httpServletRequest.getSession().getAttribute("user"))
                .orElse(new User()).getStatus() == UserStatus.BANNED && !command.equals("LOGOUT")) {
            throw new BannedUserException();
        }
        chain.doFilter(request, response);
    }
}
