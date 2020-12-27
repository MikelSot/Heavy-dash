package Data_Base;

import Domain.Category;
import Domain.Payment;
import Domain.User;
import QueryClass.SelectUserOrders;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_Users";

    private static final String sql_select_by_id = "EXECUTE USP_SelectUser_by_Id ?";

    private static final String sql_insert = "EXECUTE USP_insertUsers ?, ?, ?, ?, ?, ?";

    private static final String sql_update = "EXECUTE USP_updateUsers ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_delete = "EXECUTE USP_DeleteUser_by_Id ?";

    private static final String sql_select_InactiveUser = "SELECT * FROM VW_Select_InactiveUser";

    private static final String sql_select_userId = "EXECUTE USP_SelectUserID";

    private static final String sql_selectUser_role = "EXECUTE USP_SelectUser_Role ?";//

    private static final String sql_selectUser_orders = "EXECUTE USP_SelectUser_Orders ?";

    private static final String sql_selectUser_paymnet = "EXECUTE USP_SelectUser_Payment ?";

    private static final String sql_selectUser_orderDetails = "EXECUTE USP_SelectUser_OrderDetails ?";

    public List<User> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        List<User> users = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("UserID");
                String userName = resultSet.getString("UserName");
                String nickName = resultSet.getString("NickName");
                String email = resultSet.getString("Email");
                String userPassword = resultSet.getString("UserPassword");
                byte active = resultSet.getByte("Active");
                short roleId = resultSet.getShort("RoleID");

                user = new User(userId, userName, nickName, email, userPassword, active, roleId);
                users.add(user);
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            if (resultSet != null && resultSet.isClosed() == false) {
                ConnectionDb.close(resultSet);
            }
            resultSet = null;
            if (preparedStatement != null && preparedStatement.isClosed() == false) {
                ConnectionDb.close(preparedStatement);
            }
            preparedStatement = null;
            if (connection != null && connection.isClosed() == false) {
                ConnectionDb.close(connection);
            }
            connection = null;
        }
        return users;
    }

    public User selectUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id);
            preparedStatement.setInt(1, user.getUserId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("UserID");
                String userName = resultSet.getString("UserName");
                String nickName = resultSet.getString("NickName");
                String email = resultSet.getString("Email");
                String userPassword = resultSet.getString("UserPassword");
                byte active = resultSet.getByte("Active");
                short roleId = resultSet.getShort("RoleID");

                user = new User(userId, userName, nickName, email, userPassword, active, roleId);
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            if (resultSet != null && resultSet.isClosed() == false) {
                ConnectionDb.close(resultSet);
            }
            resultSet = null;
            if (preparedStatement != null && preparedStatement.isClosed() == false) {
                ConnectionDb.close(preparedStatement);
            }
            preparedStatement = null;
            if (connection != null && connection.isClosed() == false) {
                ConnectionDb.close(connection);
            }
            connection = null;
        }
        return user;
    }

    public int insert(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getNickName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.setByte(5, user.getActive());
            preparedStatement.setShort(6, user.getRoleId());

            row = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            if (preparedStatement != null && preparedStatement.isClosed() == false) {
                ConnectionDb.close(preparedStatement);
            }
            preparedStatement = null;
            if (connection != null && connection.isClosed() == false) {
                ConnectionDb.close(connection);
            }
            connection = null;
        }
        return row;
    }

    public int update(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_update);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getNickName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.setByte(5, user.getActive());
            preparedStatement.setShort(6, user.getRoleId());
            preparedStatement.setInt(7, user.getUserId());
            row = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            if (preparedStatement != null && preparedStatement.isClosed() == false) {
                ConnectionDb.close(preparedStatement);
            }
            preparedStatement = null;
            if (connection != null && connection.isClosed() == false) {
                ConnectionDb.close(connection);
            }
            connection = null;
        }
        return row;
    }

    public int delete(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_delete);
            preparedStatement.setInt(1, user.getUserId());
            row = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            if (preparedStatement != null && preparedStatement.isClosed() == false) {
                ConnectionDb.close(preparedStatement);
            }
            preparedStatement = null;
            if (connection != null && connection.isClosed() == false) {
                ConnectionDb.close(connection);
            }
            connection = null;
        }
        return row;
    }

    public List<User> selectInactiveUser() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        List<User> users = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_InactiveUser);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("UserID");
                String userName = resultSet.getString("UserName");
                String email = resultSet.getString("Email");
                byte active = resultSet.getByte("Active");
                short roleId = resultSet.getShort("RoleID");
                user = new User(userId, userName, email, active, roleId);
                users.add(user);
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            if (resultSet != null && resultSet.isClosed() == false) {
                ConnectionDb.close(resultSet);
            }
            resultSet = null;
            if (preparedStatement != null && preparedStatement.isClosed() == false) {
                ConnectionDb.close(preparedStatement);
            }
            preparedStatement = null;
            if (connection != null && connection.isClosed() == false) {
                ConnectionDb.close(connection);
            }
            connection = null;
        }
        return users;
    }

    public List<User> selectUserId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        List<User> users = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("UserID");
                user = new User(userId);
                users.add(user);
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            if (resultSet != null && resultSet.isClosed() == false) {
                ConnectionDb.close(resultSet);
            }
            resultSet = null;
            if (preparedStatement != null && preparedStatement.isClosed() == false) {
                ConnectionDb.close(preparedStatement);
            }
            preparedStatement = null;
            if (connection != null && connection.isClosed() == false) {
                ConnectionDb.close(connection);
            }
            connection = null;
        }
        return users;
    }

    public String selectUserRole(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String role = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectUser_role);
            preparedStatement.setInt(1, user.getUserId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                role = resultSet.getString("RoleName");
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return role;
    }

    public List<SelectUserOrders> selectUserOrders(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserOrders selectUserOrders = null;
        List<SelectUserOrders> selectUserOrderses = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectUser_orders);
            preparedStatement.setInt(1, user.getUserId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderID");
                byte states = resultSet.getByte("States");
                String orderDate = resultSet.getString("OrderDate");
                String shippingDate = resultSet.getString("ShippedDate");
                String orderAdderss = resultSet.getString("OrderAddress");
                String dni = resultSet.getString("Dni");
                String lastName = resultSet.getString("LastName");
                String typeAddress = resultSet.getString("AddressName");
                String district = resultSet.getString("District");
                short districtId = resultSet.getShort("DistrictID");
                String employeeId = resultSet.getString("EmployeeID");
                String shippingComanyId = resultSet.getString("ShippingCompanyID");
                selectUserOrders = new SelectUserOrders(orderId, states, orderDate, shippingDate, orderAdderss, dni, lastName, typeAddress, districtId, district, employeeId, shippingComanyId);
                selectUserOrderses.add(selectUserOrders);
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return selectUserOrderses;
    }

    public List<Payment> selectUserPayment(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Payment payment = null;
        List<Payment> payments = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectUser_paymnet);
            preparedStatement.setInt(1, user.getUserId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int paymentId = resultSet.getInt("PaymentID");
                String paymentDate = resultSet.getString("PaymentDate");
                int userId = resultSet.getInt("UserID");
                int orderDetailID = resultSet.getInt("OrderDetailID");
                String invoiceId = resultSet.getString("InvoiceID");
                payment = new Payment(paymentId, paymentDate, userId, orderDetailID, invoiceId);
                payments.add(payment);
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return payments;
    }
    
    public List<SelectUserOrders> selectUserOrderDetails(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserOrders selectUserOrders = null;
        List<SelectUserOrders> selectUserOrderses = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectUser_orderDetails);
            preparedStatement.setInt(1, user.getUserId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderDetailId = resultSet.getInt("OrderDetailID");
                int orderId = resultSet.getInt("OrderID");
                int productId = resultSet.getInt("ProductID");
                String product = resultSet.getString("NameProduct");
                short quantity = resultSet.getShort("Quantity");
                selectUserOrders = new SelectUserOrders(orderId, orderDetailId, product, productId, quantity);
                selectUserOrderses.add(selectUserOrders);
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return selectUserOrderses;
    }

}
