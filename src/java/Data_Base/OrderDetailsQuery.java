package Data_Base;

import Domain.*;
import QueryClass.SelectUserOrders;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDetailsQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_OrderDetail";

    private static final String sql_select_by_id = "EXECUTE USP_SelectOrderDetail_by_Id ?";

    private static final String sql_insert = "EXECUTE USP_insertOrderDetails ?, ?, ?";

    private static final String sql_update = "EXECUTE USP_updateOrderDetails ?, ?, ?, ?";

    private static final String sql_delete = "EXECUTE USP_DeleteOrderDetail_by_Id ?";

    private static final String sql_select_orderDetailsId = "EXECUTE USP_SelectOrderDetailsId";

    private static final String sql_select_orderDetails_orders = "SELECT * FROM VW_SelectOrderDetails_Orders";

    private static final String sql_select_orderDetails_product = "SELECT * FROM VW_SelectOrderDetails_Product";

    private static final String sql_select_orderDetailsId_orders = "EXECUTE USP_SelectOrderDetails_Orders ?";
    
    private static final String sql_select_orderDetailsId_product = "EXECUTE USP_SelectOrderDetails_Products ?";
    
    private static final String sql_select_orderDetailsId_user = "EXECUTE USP_SelectOrderDetails_UserId ?";

    public List<OrderDetail> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OrderDetail orderDetail = null;
        List<OrderDetail> orderDetails = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderDetailID = resultSet.getInt("OrderDetailID");
                int orderId = resultSet.getInt("OrderID");
                int productId = resultSet.getInt("ProductID");
                short quantity = resultSet.getShort("Quantity");

                orderDetail = new OrderDetail(orderDetailID, orderId, productId, quantity);
                orderDetails.add(orderDetail);
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

        return orderDetails;
    }

    public OrderDetail selectOrderDetail(OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id);
            preparedStatement.setInt(1, orderDetail.getOrderDetailId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderDetailID = resultSet.getInt("OrderDetailID");
                int orderId = resultSet.getInt("OrderID");
                int productId = resultSet.getInt("ProductID");
                short quantity = resultSet.getShort("Quantity");
                orderDetail = new OrderDetail(orderDetailID, orderId, productId, quantity);
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
        return orderDetail;
    }

    public int insert(OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert);
            preparedStatement.setInt(1, orderDetail.getOrderId());
            preparedStatement.setInt(2, orderDetail.getProductId());
            preparedStatement.setShort(3, orderDetail.getQuantity());
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

    public int update(OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setInt(1, orderDetail.getOrderId());
            preparedStatement.setInt(2, orderDetail.getProductId());
            preparedStatement.setShort(3, orderDetail.getQuantity());
            preparedStatement.setInt(4, orderDetail.getOrderDetailId());
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

    public int delete(OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_delete);
            preparedStatement.setInt(1, orderDetail.getOrderDetailId());
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

    public List<OrderDetail> selectOrderDetailsId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OrderDetail orderDetail = null;
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_orderDetailsId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderDetailID = resultSet.getInt("OrderDetailID");
                orderDetail = new OrderDetail(orderDetailID);
                orderDetails.add(orderDetail);
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
        return orderDetails;
    }

    public List<Order> selectOrderDetailsOrders() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Order order = null;
        List<Order> orders = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_orderDetails_orders);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderID");
                byte states = resultSet.getByte("States");
                String orderDate = resultSet.getString("OrderDate");
                String shippingDate = resultSet.getString("ShippedDate");
                int userId = resultSet.getInt("UserID");
                order = new Order(orderId, states, orderDate, shippingDate, userId);
                orders.add(order);
            }
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return orders;
    }

    public List<Product> selectOrderDetailsProduct() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_orderDetails_product);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                String nameProduct = resultSet.getString("NameProduct");
                byte states = resultSet.getByte("States");
                float unitPrice = resultSet.getFloat("UnitPrice");
                short stock = resultSet.getShort("Stock");
                short supplierId = resultSet.getShort("SupplierID");
                short categoryId = resultSet.getShort("CategoryID");
                product = new Product(productId, nameProduct, states, unitPrice, stock, supplierId, categoryId);
                products.add(product);
            }

        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }

        return products;
    }
    
    public User selectOrderDetailIdUserId(OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        User user = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_orderDetailsId_user);
            preparedStatement.setInt(1, orderDetail.getOrderDetailId());
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
                ConnectionDb.close(resultSet);
                ConnectionDb.close(preparedStatement);
                ConnectionDb.close(connection);
        }
        return user;
    }
    
    public SelectUserOrders selectOrderDetailIdOrders(OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserOrders selectUserOrders = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_orderDetailsId_orders);
            preparedStatement.setInt(1, orderDetail.getOrderDetailId());
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
            }
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return selectUserOrders;
    }
    
    public Product selectOrderDetailIdProduct(OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_orderDetailsId_product);
            preparedStatement.setInt(1, orderDetail.getOrderDetailId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                String nameProduct = resultSet.getString("NameProduct");
                byte states = resultSet.getByte("States");
                float unitPrice = resultSet.getFloat("UnitPrice");
                short stock = resultSet.getShort("Stock");
                short supplierId = resultSet.getShort("SupplierID");
                short categoryId = resultSet.getShort("CategoryID");
                product = new Product(productId, nameProduct, states, unitPrice, stock, supplierId, categoryId);
            }

        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }

        return product;
    }
}
