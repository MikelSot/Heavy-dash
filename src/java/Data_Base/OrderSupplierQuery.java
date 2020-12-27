package Data_Base;

import Domain.OrderSupplier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderSupplierQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_OrderSupplier";

    private static final String sql_select_by_id = "EXECUTE USP_SelectOrderSupplier_by_Id ?";

    private static final String sql_insert = "EXECUTE USP_insertOrderSupplier ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_update = "EXECUTE USP_updateOrderSupplier ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_delete = "EXECUTE USP_DeleteOrderSupplier_by_Id ?";
    
    public List<OrderSupplier> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OrderSupplier orderSupplier = null;
        List<OrderSupplier> orderSuppliers = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderSupplierId = resultSet.getInt("OrderSupplierID");
                String orderName = resultSet.getString("OrderName");
                double unitPrice = resultSet.getDouble("UnitPrice");
                short quantity = resultSet.getShort("Quantity");
                String orderDescription = resultSet.getString("OrderDescription");
                byte states = resultSet.getByte("States");
                String orderDate = resultSet.getString("OrderDate");
                String shippedDate = resultSet.getString("ShippedDate");
                String shippingCompany = resultSet.getString("ShippingCompany");
                double priceShipping = resultSet.getDouble("PriceShipping");
                short supplierId = resultSet.getShort("SupplierID");

                orderSupplier = new OrderSupplier(orderSupplierId, orderName, unitPrice, quantity, orderDescription, states, orderDate, shippedDate, shippingCompany, priceShipping, supplierId);
                orderSuppliers.add(orderSupplier);
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

        return orderSuppliers;
    }

    public OrderSupplier selectOrderSupplier(OrderSupplier orderSupplier) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id);
            preparedStatement.setInt(1, orderSupplier.getOrderSupplierId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderSupplierId = resultSet.getInt("OrderSupplierID");
                String orderName = resultSet.getString("OrderName");
                double unitPrice = resultSet.getDouble("UnitPrice");
                short quantity = resultSet.getShort("Quantity");
                String orderDescription = resultSet.getString("OrderDescription");
                byte states = resultSet.getByte("States");
                String orderDate = resultSet.getString("OrderDate");
                String shippedDate = resultSet.getString("ShippedDate");
                String shippingCompany = resultSet.getString("ShippingCompany");
                double priceShipping = resultSet.getDouble("PriceShipping");
                short supplierId = resultSet.getShort("SupplierID");

                orderSupplier = new OrderSupplier(orderSupplierId, orderName, unitPrice, quantity, orderDescription, states, orderDate, shippedDate, shippingCompany, priceShipping, supplierId);
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

        return orderSupplier;
    }

    public int insert(OrderSupplier orderSupplier) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert);

            preparedStatement.setString(1, orderSupplier.getOrderName());
            preparedStatement.setDouble(2, orderSupplier.getUnitPrice());
            preparedStatement.setShort(3, orderSupplier.getQuantity());
            preparedStatement.setString(4, orderSupplier.getOrderDescription());
            preparedStatement.setByte(5, orderSupplier.getStates());
            preparedStatement.setString(6, orderSupplier.getOrderDate());
            preparedStatement.setString(7, orderSupplier.getShippedDate());
            preparedStatement.setString(8, orderSupplier.getShippingCompany());
            preparedStatement.setDouble(9, orderSupplier.getPriceShipping());
            preparedStatement.setShort(10, orderSupplier.getSupplierId());

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

    public int Update(OrderSupplier orderSupplier) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, orderSupplier.getOrderName());
            preparedStatement.setDouble(2, orderSupplier.getUnitPrice());
            preparedStatement.setShort(3, orderSupplier.getQuantity());
            preparedStatement.setString(4, orderSupplier.getOrderDescription());
            preparedStatement.setByte(5, orderSupplier.getStates());
            preparedStatement.setString(6, orderSupplier.getOrderDate());
            preparedStatement.setString(7, orderSupplier.getShippedDate());
            preparedStatement.setString(8, orderSupplier.getShippingCompany());
            preparedStatement.setDouble(9, orderSupplier.getPriceShipping());
            preparedStatement.setShort(10, orderSupplier.getSupplierId());
            preparedStatement.setInt(11, orderSupplier.getOrderSupplierId());
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

    public int delete(OrderSupplier orderSupplier) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_delete);

            preparedStatement.setInt(1, orderSupplier.getOrderSupplierId());

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

}
