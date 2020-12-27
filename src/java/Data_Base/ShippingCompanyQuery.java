package Data_Base;

import Domain.Category;
import Domain.ShippingCompany;
import QueryClass.SelectUserPayments;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShippingCompanyQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_ShippingCompany";

    private static final String sql_select_by_id = "EXECUTE USP_SelectShippingCompany_by_Id ?";

    private static final String sql_insert = "EXECUTE USP_insertShippingCompany  ?, ?, ?, ?, ?, ?";

    private static final String sql_update = "EXECUTE USP_updateShippingCompany ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_delete = "EXECUTE USP_DeleteShippingCompany_by_Id ?";

    private static final String sql_select_shippingCompanyId = "EXECUTE USP_SelectShippingCompanyId";

    private static final String sql_select_vwshippingCompany_orders = "SELECT * FROM VW_SelectShippingCompany_Orders";

    public List<ShippingCompany> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ShippingCompany shippingCompany = null;
        List<ShippingCompany> shippingCompanys = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
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
                shippingCompanys.add(shippingCompany);
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
        return shippingCompanys;
    }

    public ShippingCompany selectShippingCompany(ShippingCompany shippingCompany) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id);
            preparedStatement.setShort(1, shippingCompany.getShippingCompanyId());
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

    public int insert(ShippingCompany shippingCompany) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert);

            preparedStatement.setString(1, shippingCompany.getCompanyName());
            preparedStatement.setString(2, shippingCompany.getContactName());
            preparedStatement.setByte(3, shippingCompany.getActive());
            preparedStatement.setString(4, shippingCompany.getCompanyAddres());
            preparedStatement.setString(5, shippingCompany.getPostalCode());
            preparedStatement.setString(6, shippingCompany.getEmail());

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

    public int update(ShippingCompany shippingCompany) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_update);

            preparedStatement.setString(1, shippingCompany.getCompanyName());
            preparedStatement.setString(2, shippingCompany.getContactName());
            preparedStatement.setByte(3, shippingCompany.getActive());
            preparedStatement.setString(4, shippingCompany.getCompanyAddres());
            preparedStatement.setString(5, shippingCompany.getPostalCode());
            preparedStatement.setString(6, shippingCompany.getEmail());
            preparedStatement.setShort(7, shippingCompany.getShippingCompanyId());

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

    public int delete(ShippingCompany shippingCompany) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_delete);
            preparedStatement.setShort(1, shippingCompany.getShippingCompanyId());
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

    public List<ShippingCompany> selectShippingCompanyId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ShippingCompany shippingCompany = null;
        List<ShippingCompany> shippingCompanys = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_shippingCompanyId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                short shippingCompanyId = resultSet.getShort("ShippingCompanyID");
                shippingCompany = new ShippingCompany(shippingCompanyId);
                shippingCompanys.add(shippingCompany);
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
        return shippingCompanys;
    }

    public List<SelectUserPayments> selectvwShippingCompanyOrders() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectUserPayments selectUserPayments = null;
        List<SelectUserPayments> selectUserPaymentses = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_vwshippingCompany_orders);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String shippingComanyId = resultSet.getString("ShippingCompanyID");
                int orderId = resultSet.getInt("OrderID");
                String shippingDate = resultSet.getString("ShippedDate");
                String orderDate = resultSet.getString("OrderDate");
                byte states = resultSet.getByte("States");
                int userId = resultSet.getInt("UserID");
                String userName = resultSet.getString("UserName");
                selectUserPayments = new SelectUserPayments(userId, userName, orderId, orderDate, states, shippingDate, shippingComanyId);
                selectUserPaymentses.add(selectUserPayments);
            }

        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);

        }
        return selectUserPaymentses;
    }
}
