package Data_Base.optional_Query;

import Data_Base.ConnectionDb;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import optional.Role;

public class RoleQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_Role";

    public List<Role> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = null;
        List<Role> roles = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                short roleId = resultSet.getShort("RoleID");
                String roleName = resultSet.getString("RoleName");
                byte active = resultSet.getByte("Active");
                role = new Role(roleId, roleName, active);
                roles.add(role);
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return roles;
    }

}
