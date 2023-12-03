package MyShop.Web.command.Implementation;

import MyShop.Model.Dao.UserDao;
import MyShop.Model.Dao.Implementation.JdbcUserDao;
import MyShop.Model.Configs.User.UserRole;
import MyShop.Model.Configs.User.UserStatus;
import MyShop.Web.command.Command;
import MyShop.Web.command.CommandHandler;
import MyShop.Web.command.CommandName;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.Optional;

public class UpdateUsersCommand implements Command {
    private UserDao userDao = JdbcUserDao.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        String[] discounts = request.getParameterValues("discount");
        String[] roles = request.getParameterValues("role");
        String[] statuses = request.getParameterValues("status");
        String[] ids = request.getParameterValues("id");
        for (int i = 0; i < discounts.length; i++) {
            UserRole role = UserRole.valueOf(roles[i]);
            UserStatus status = UserStatus.valueOf(statuses[i]);
            Long id = Long.parseLong(ids[i]);
            Double discount = Double.parseDouble(Optional.ofNullable(discounts[i]).orElse("0"));
            try {
                userDao.updateUser(id, discount, role, status);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return CommandHandler.getInstance().getCommandByName(CommandName.USERS).execute(request);
    }
}