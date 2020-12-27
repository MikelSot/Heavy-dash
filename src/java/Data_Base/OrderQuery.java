package Data_Base;

import Domain.*;
import QueryClass.SelectUserOrders;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import optional.District;

public class OrderQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_Order";

    private static final String sql_select_by_id = "EXECUTE USP_SelectOrder_by_Id ?";

    private static final String sql_insert = "EXECUTE USP_insertOrders ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_update = "EXECUTE USP_updateOrders ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_delete = "EXECUTE USP_DeleteOrder_by_Id ?";

    private static final String sql_select_ordersId = "EXECUTE USP_SelectOrdersId";

    private static final String sql_select_ordersUserId = "EXECUTE USP_SelectOrder_UserId ?, ?";//

    private static final String sql_select_ordersDistricId = "EXECUTE USP_SelectOrder_DistricId ?, ?";

    private static final String sql_select_ordersTypeAddressID = "EXECUTE USP_SelectOrder_TypeAddressID ?, ?";

    private static final String sql_select_ordersShippingCompanyID = "EXECUTE USP_SelectOrder_ShippingCompanyID ?, ?";

    private static final String sql_select_ordersEmployeeID = "EXECUTE USP_SelectOrder_EmployeeID ?, ?";

    private static final String sql_select_vwOrderShipping = "SELECT * FROM VW_SelectOrderShipping";

    private static final String sql_select_vwOrderEmployee = "SELECT * FROM VW_SelectOrderEmployee";

    public List<Order> select() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Order order = null;
        List<Order> orders = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderID");
                byte states = resultSet.getByte("States");
                String orderDate = resultSet.getString("OrderDate");
                String shippingDate = resultSet.getString("ShippedDate");
                String orderAdderss = resultSet.getString("OrderAddress");
                String lot = resultSet.getString("Lot");
                String reference = resultSet.getString("Reference");
                String dni = resultSet.getString("Dni");
                String name = resultSet.getString("names");
                String lastName = resultSet.getString("LastName");
                byte typeAddress = resultSet.getByte("TypeAddressID");
                short districtId = resultSet.getShort("DistrictID");
                String employeeId = resultSet.getString("EmployeeID");
                String shippingComanyId = resultSet.getString("ShippingCompanyID");
                int userId = resultSet.getInt("UserID");
                order = new Order(orderId, states, orderDate, shippingDate, orderAdderss, lot, reference, dni, name, lastName, typeAddress, districtId, employeeId, shippingComanyId, userId);
                orders.add(order);
            }

        } catch (SQLException e) {
            ConnectionDb.processEception(e);
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
        return orders;
    }

    public Order selectOrder(Order order) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id);
            preparedStatement.setInt(1, order.getOrderId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderID");
                byte states = resultSet.getByte("States");
                String orderDate = resultSet.getString("OrderDate");
                String shippingDate = resultSet.getString("ShippedDate");
                String orderAdderss = resultSet.getString("OrderAddress");
                String lot = resultSet.getString("Lot");
                String reference = resultSet.getString("Reference");
                String dni = resultSet.getString("Dni");
                String name = resultSet.getString("names");
                String lastName = resultSet.getString("LastName");
                byte typeAddress = resultSet.getByte("TypeAddressID");
                short districtId = resultSet.getShort("DistrictID");
                String employeeId = resultSet.getString("EmployeeID");
                String shippingComanyId = resultSet.getString("ShippingCompanyID");
                int userId = resultSet.getInt("UserID");

                order = new Order(orderId, states, orderDate, shippingDate, orderAdderss, lot, reference, dni, name, lastName, typeAddress, districtId, employeeId, shippingComanyId, userId);
            }

        } catch (SQLException e) {
            ConnectionDb.processEception(e);
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
        return order;
    }

    public int insert(Order order) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert);
            preparedStatement.setByte(1, order.getStates());
            preparedStatement.setString(2, order.getOrderDate());
            preparedStatement.setString(3, order.getShippingDate());
            preparedStatement.setString(4, order.getOrderAdderss());
            preparedStatement.setString(5, order.getLot());
            preparedStatement.setString(6, order.getReference());
            preparedStatement.setString(7, order.getDni());
            preparedStatement.setString(8, order.getName());
            preparedStatement.setString(9, order.getLastName());
            preparedStatement.setByte(10, order.getTypeAddress());
            preparedStatement.setShort(11, order.getDistrictId());
            preparedStatement.setString(12, order.getEmployeeId());
            preparedStatement.setString(13, order.getShippingComanyId());
            preparedStatement.setInt(14, order.getUserId());

            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
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

    public int update(Order order) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setByte(1, order.getStates());
            preparedStatement.setString(2, order.getOrderDate());
            preparedStatement.setString(3, order.getShippingDate());
            preparedStatement.setString(4, order.getOrderAdderss());
            preparedStatement.setString(5, order.getLot());
            preparedStatement.setString(6, order.getReference());
            preparedStatement.setString(7, order.getDni());
            preparedStatement.setString(8, order.getName());
            preparedStatement.setString(9, order.getLastName());
            preparedStatement.setByte(10, order.getTypeAddress());
            preparedStatement.setShort(11, order.getDistrictId());
            preparedStatement.setString(12, order.getEmployeeId());
            preparedStatement.setString(13, order.getShippingComanyId());
            preparedStatement.setInt(14, order.getUserId());
            preparedStatement.setInt(15, order.getOrderId());

            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
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

    public int delete(Order order) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_delete);
            preparedStatement.setInt(1, order.getOrderId());

            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
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

    public List<Order> selectOrderId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Order order = null;
        List<Order> orders = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_ordersId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderID");
                order = new Order(orderId);
                orders.add(order);
            }
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
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
        return orders;
    }

    public User selectOrdersUserId(User user, Order order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_ordersUserId);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setInt(2, order.getOrderId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("UserID");
                String userName = resultSet.getString("UserName");
                String nickName = resultSet.getString("NickName");
                String email = resultSet.getString("Email");
                byte active = resultSet.getByte("Active");
                short roleId = resultSet.getShort("RoleID");
                user = new User(userId, userName, nickName, email, active, roleId);
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

    public District selectOrdersDistricId(District district, Order order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_ordersDistricId);
            preparedStatement.setInt(1, order.getOrderId());
            preparedStatement.setShort(2, district.getDistrictId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String districtName = resultSet.getString("District");
                String province = resultSet.getString("Province");
                district = new District(districtName, province);
            }
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
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
        return district;
    }

    public TypeAddress selectOrdersTypeAddressID(TypeAddress typeAddress, Order order) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_ordersTypeAddressID);
            preparedStatement.setByte(1, typeAddress.getTypeAddressId());
            preparedStatement.setInt(2, order.getOrderId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String addressName = resultSet.getString("AddressName");
                typeAddress = new TypeAddress(addressName);
            }
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
        } finally {
            ConnectionDb.close(connection);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(resultSet);
        }
        return typeAddress;
    }

    public ShippingCompany selectOrdersShippingCompanyID(ShippingCompany shippingCompany, Order order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_ordersShippingCompanyID);
            preparedStatement.setShort(1, shippingCompany.getShippingCompanyId());
            preparedStatement.setInt(2, order.getOrderId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                short shippingCompanyId = resultSet.getShort("ShippingCompanyID");
                String companyName = resultSet.getString("CompanyName");
                String contactName = resultSet.getString("ContactName");
                byte active = resultSet.getByte("Active");
                String companyAddres = resultSet.getString("CompanyAddress");
                String postalCode = resultSet.getString("PostalCode");
                String email = resultSet.getString("Email");
                shippingCompany = new ShippingCompany(shippingCompanyId, companyName, contactName, active, companyAddres, postalCode, email);
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
        return shippingCompany;
    }

    public Employee selectOrdersEmployeeID(Employee employee, Order order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_ordersEmployeeID);
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setInt(2, order.getOrderId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("EmployeeID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String dni = resultSet.getString("Dni");
                String email = resultSet.getString("Email");
                String employeeHours = resultSet.getString("EmployeeHours");
                String turn = resultSet.getString("Turn");
                String position = resultSet.getString("Position");
                String states = resultSet.getString("States");
                String boss = resultSet.getString("Boss");
                String bossLastName = resultSet.getString("BossLastName");
                String district = resultSet.getString("District");
                employee = new Employee(employeeId, firstName, lastName, dni, email, employeeHours, turn, position, states, boss, district, bossLastName);
            }
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
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
        return employee;
    }

    public List<SelectUserOrders> selectvwOrderShipping() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserOrders selectUserOrders = null;
        List<SelectUserOrders> selectUserOrderses = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_vwOrderShipping);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderID");
                byte states = resultSet.getByte("States");
                String shippingCompanyId = resultSet.getString("ShippingCompanyID");
                String companyName = resultSet.getString("CompanyName");
                String contactName = resultSet.getString("ContactName");
                byte active = resultSet.getByte("Active");
                String email = resultSet.getString("Email");                
                selectUserOrders = new SelectUserOrders(orderId, states, shippingCompanyId, email, companyName, contactName, active);
                selectUserOrderses.add(selectUserOrders);
            }
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return selectUserOrderses;
    }
    
    public List<SelectUserOrders> selectvwOrderEmployee() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserOrders selectUserOrders = null;
        List<SelectUserOrders> selectUserOrderses = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_vwOrderEmployee);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderID");
                byte states = resultSet.getByte("States");
                String employeeId = resultSet.getString("EmployeeID");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String position = resultSet.getString("Position");
                String boss = resultSet.getString("Boss");
                selectUserOrders = new SelectUserOrders(orderId, states, lastName, employeeId, email, position, boss);
                selectUserOrderses.add(selectUserOrders);
            }
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return selectUserOrderses;
    }

}
