package Data_Base;

import Domain.*;
import QueryClass.SelectUserPayments;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_Payment";

    private static final String sql_select_by_id = "EXECUTE USP_SelectPayment_by_Id ?";

    private static final String sql_insert = "EXECUTE USP_insertPayment ?, ?, ?, ?";

    private static final String sql_update = "EXECUTE USP_updatePayment ?, ?, ?, ?, ?";

    private static final String sql_delete = "EXECUTE USP_DeletePayment_by_Id ?";

    private static final String sql_selectPayment_userById = "EXECUTE USP_SelectPayment_UserById ?, ?";

    private static final String sql_selectUser_payments = "EXECUTE USP_SelectUserPayments ?, ?";

    private static final String sql_selectOrderDetailsProducto_paymentId = "EXECUTE USP_SelectOrderDetailProduct_paymentId ?,?";

    private static final String sql_selectOrder_payments = "EXECUTE USP_SelectOrder_paymentId ?,?";

    private static final String sql_selectProduct_payments = "EXECUTE USP_SelectProduct_payments ?";

    private static final String sql_selectInvoices_payments = "EXECUTE USP_SelectInvoices_payments ?";

    public List<Payment> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Payment payment = null;
        List<Payment> payments = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
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

        return payments;
    }

    public Payment selectPayment(Payment payment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id);
            preparedStatement.setInt(1, payment.getPaymentId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentId = resultSet.getInt("PaymentID");
                String paymentDate = resultSet.getString("PaymentDate");
                int userId = resultSet.getInt("UserID");
                int orderDetailID = resultSet.getInt("OrderDetailID");
                String invoiceId = resultSet.getString("InvoiceID");
                payment = new Payment(paymentId, paymentDate, userId, orderDetailID, invoiceId);
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
        return payment;
    }

    public int insert(Payment payment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert);

            preparedStatement.setString(1, payment.getPaymentDate());
            preparedStatement.setInt(2, payment.getUserId());
            preparedStatement.setInt(3, payment.getOrderDetailId());
            preparedStatement.setString(4, payment.getInvoiceId());

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

    public int update(Payment payment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_update);

            preparedStatement.setString(1, payment.getPaymentDate());
            preparedStatement.setInt(2, payment.getUserId());
            preparedStatement.setInt(3, payment.getOrderDetailId());
            preparedStatement.setString(4, payment.getInvoiceId());;
            preparedStatement.setInt(5, payment.getPaymentId());

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

    public int delete(Payment payment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_delete);
            preparedStatement.setInt(1, payment.getPaymentId());
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

    public User selectPaymentUserById(User user, Payment payment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectPayment_userById);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setInt(2, payment.getPaymentId());
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

    public List<SelectUserPayments> selectUserpayments(User user, Payment payment) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserPayments selectUserPayments = null;
        List<SelectUserPayments> selectUserPaymentses = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectUser_payments);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setInt(2, payment.getPaymentId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentId = resultSet.getInt("PaymentID");
                int userId = resultSet.getInt("UserID");
                String userName = resultSet.getString("UserName");
                int invoiceId = resultSet.getInt("InvoiceID");
                int orderId = resultSet.getInt("OrderID");
                String orderDate = resultSet.getString("OrderDate");
                int orderDetailID = resultSet.getInt("OrderDetailID");
                short quantity = resultSet.getShort("Quantity");
                int productId = resultSet.getInt("ProductID");
                String nameProduct = resultSet.getString("NameProduct");
                float unitPrice = resultSet.getFloat("UnitPrice");
                short stock = resultSet.getShort("Stock");
                float monto = resultSet.getFloat("Monto");
                selectUserPayments = new SelectUserPayments(paymentId, userId, userName, invoiceId, orderDetailID, orderId, productId, quantity, stock, orderDate, nameProduct, unitPrice, stock, monto);
                selectUserPaymentses.add(selectUserPayments);
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
        return selectUserPaymentses;
    }

    public SelectUserPayments selectOrderDetailsProductoPaymentId(Payment payment, OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserPayments selectUserPayments = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectOrderDetailsProducto_paymentId);
            preparedStatement.setInt(1, payment.getPaymentId());
            preparedStatement.setInt(2, orderDetail.getOrderDetailId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentId = resultSet.getInt("PaymentID");
                int orderId = resultSet.getInt("OrderID");
                int orderDetailID = resultSet.getInt("OrderDetailID");
                short quantity = resultSet.getShort("Quantity");
                int productId = resultSet.getInt("ProductID");
                String nameProduct = resultSet.getString("NameProduct");
                float unitPrice = resultSet.getFloat("UnitPrice");
                short stock = resultSet.getShort("Stock");
                byte states = resultSet.getByte("States");
                short supplierId = resultSet.getShort("SupplierID");
                short categoryId = resultSet.getShort("CategoryID");
                String sku = resultSet.getString("SKU");
                selectUserPayments = new SelectUserPayments(paymentId, orderDetailID, orderId, productId, quantity, nameProduct, unitPrice, stock, states, categoryId, supplierId, sku);
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
        return selectUserPayments;
    }

    public SelectUserPayments selectOrderPaymentId(Payment payment, OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserPayments selectUserPayments = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectOrder_payments);
            preparedStatement.setInt(1, payment.getPaymentId());
            preparedStatement.setInt(2, orderDetail.getOrderDetailId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentId = resultSet.getInt("PaymentID");
                int orderId = resultSet.getInt("OrderID");
                byte states = resultSet.getByte("States");
                String orderDate = resultSet.getString("OrderDate");
                String shippingDate = resultSet.getString("ShippedDate");
                String dni = resultSet.getString("Dni");
                String name = resultSet.getString("names");
                String lastName = resultSet.getString("LastName");
                byte typeAddress = resultSet.getByte("TypeAddressID");
                short districtId = resultSet.getShort("DistrictID");
                String employeeId = resultSet.getString("EmployeeID");
                String shippingComanyId = resultSet.getString("ShippingCompanyID");
                selectUserPayments = new SelectUserPayments(paymentId, orderId, districtId, orderDate, states, dni, name, lastName, typeAddress, shippingDate, employeeId, shippingComanyId);
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
        return selectUserPayments;
    }

    public List<SelectUserPayments> selectProductPayments(OrderDetail orderDetail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserPayments selectUserPayments = null;
        List<SelectUserPayments> selectUserPaymentses = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectProduct_payments);
            preparedStatement.setInt(1, orderDetail.getOrderDetailId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentId = resultSet.getInt("PaymentID");
                int userId = resultSet.getInt("UserID");
                String userName = resultSet.getString("UserName");
                int orderId = resultSet.getInt("OrderID");
                int orderDetailID = resultSet.getInt("OrderDetailID");
                short quantity = resultSet.getShort("Quantity");
                int productId = resultSet.getInt("ProductID");
                short categoryId = resultSet.getShort("CategoryID");
                String nameProduct = resultSet.getString("NameProduct");
                float unitPrice = resultSet.getFloat("UnitPrice");
                short stock = 0;
                selectUserPayments = new SelectUserPayments(paymentId, userId, userName, orderDetailID, orderId, productId, quantity, nameProduct, unitPrice, quantity, (byte) stock, categoryId);
                selectUserPaymentses.add(selectUserPayments);
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
        return selectUserPaymentses;
    }

    public List<SelectUserPayments> selectInvoicesPayments(Invoice invoice) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserPayments selectUserPayments = null;
        List<SelectUserPayments> selectUserPaymentses = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectInvoices_payments);
            preparedStatement.setInt(1, invoice.getInvoiceId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentId = resultSet.getInt("PaymentID");
                int invoiceId = resultSet.getInt("InvoiceID");
                int userId = resultSet.getInt("UserID");
                String userName = resultSet.getString("UserName");
                int orderDetailID = resultSet.getInt("OrderDetailID");
                short quantity = resultSet.getShort("Quantity");
                int orderId = resultSet.getInt("OrderID");
                int productId = resultSet.getInt("ProductID");
                String nameProduct = resultSet.getString("NameProduct");
                float unitPrice = resultSet.getFloat("UnitPrice");
                short stock = resultSet.getShort("Stock");
                selectUserPayments = new SelectUserPayments(paymentId, userId, userName, invoiceId, orderDetailID, orderId, productId, quantity, nameProduct, unitPrice, stock);
                selectUserPaymentses.add(selectUserPayments);
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
        return selectUserPaymentses;
    }

}
