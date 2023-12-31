package MyShop.Model.Mappers;

import MyShop.Model.Configs.User.User;
import MyShop.Model.Configs.User.UserRole;
import MyShop.Model.Configs.User.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRowMapper {
    public Optional<User> mapRows(ResultSet rs) throws SQLException {
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setRole(UserRole.valueOf(rs.getString("role")));
            user.setDiscount(rs.getDouble("discount"));
            user.setStatus(UserStatus.valueOf(rs.getString("status")));
            user.setLogin(rs.getString("login"));
            user.setHashPassword(rs.getString("password"));
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
