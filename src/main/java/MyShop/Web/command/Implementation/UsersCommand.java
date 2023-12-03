package MyShop.Web.command.Implementation;

import MyShop.Model.Dao.UserDao;
import MyShop.Model.Dao.Implementation.JdbcUserDao;
import MyShop.Model.Configs.User.User;
import MyShop.Web.JspPageName;
import MyShop.Web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.List;

public class UsersCommand implements Command {
    private UserDao userDao = JdbcUserDao.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        List<User> users;
        try {
            users = userDao.getUsers(((User)request.getSession().getAttribute("user")).getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("users", users);
        return JspPageName.USERS_JSP;
    }
}
