package Data_Base.optional_Query;

import Data_Base.ConnectionDb;
import Domain.Invoice;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_Invoice";
    
    private static final String sql_select_invoiceId = "EXECUTE USP_SelectInvoiceId";
    
    private static final String sql_select_invoiceById = "EXECUTE USP_SelectInvoiceById ?";

    public List<Invoice> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Invoice invoice = null;
        List<Invoice> invoices = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int invoiceId = resultSet.getInt("InvoiceID");
                String ruc = resultSet.getString("RUC");
                String direccion = resultSet.getString("Direccion");
                String razon = resultSet.getString("Razon");
                
                invoice = new Invoice(invoiceId, ruc, direccion, razon);
                invoices.add(invoice);
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

        return invoices;
    }
    
    public List<Invoice> selectInvoiceId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Invoice invoice = null;
        List<Invoice> invoices = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_invoiceId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int invoiceId = resultSet.getInt("InvoiceID");               
                invoice = new Invoice(invoiceId);
                invoices.add(invoice);
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
        return invoices;
    }
    
    public Invoice selectInvoiceById(Invoice invoice) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Invoice> invoices = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_invoiceById);
            preparedStatement.setInt(1, invoice.getInvoiceId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int invoiceId = resultSet.getInt("InvoiceID");
                String ruc = resultSet.getString("RUC");
                String direccion = resultSet.getString("Direccion");
                String razon = resultSet.getString("Razon");              
                invoice = new Invoice(invoiceId, ruc, direccion, razon);
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
        return invoice;
    }

}
