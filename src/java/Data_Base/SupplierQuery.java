package Data_Base;

import Domain.Category;
import Domain.Supplier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupplierQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_Supplier";

    private static final String sql_select_by_id = "EXECUTE USP_SelectSupplier_by_Id ?";

    private static final String sql_insert = "EXECUTE USP_insertSupplier ?, ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_update = "EXECUTE USP_updateSupplier ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_delete = "EXECUTE USP_DeleteSupplier_by_Id ?";
    
    private static final String sql_select_supplierId = "EXECUTE USP_SelectSupplierId";

    public List<Supplier> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Supplier supplier = null;
        List<Supplier> suppliers = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short supplierId = resultSet.getShort("SupplierID");
                String nameCompany = resultSet.getString("NameCompany");
                String contanctName = resultSet.getString("ContactName");
                byte states = resultSet.getByte("States");
                String supplierAddress = resultSet.getString("SupplierAddress");
                String postalCode = resultSet.getString("PostalCode");
                String city = resultSet.getString("City");
                String country = resultSet.getString("Country");
                String email = resultSet.getString("Email");
                String typeGoods = resultSet.getString("TypeGoods");

                supplier = new Supplier(supplierId, nameCompany, contanctName, states, supplierAddress, postalCode, city, country, email, typeGoods);
                suppliers.add(supplier);

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
        return suppliers;
    }
    
    public Supplier selectSupplier(Supplier supplier) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id);
            preparedStatement.setShort(1, supplier.getSupplierId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short supplierId = resultSet.getShort("SupplierID");
                String nameCompany = resultSet.getString("NameCompany");
                String contanctName = resultSet.getString("ContactName");
                byte states = resultSet.getByte("States");
                String supplierAddress = resultSet.getString("SupplierAddress");
                String postalCode = resultSet.getString("PostalCode");
                String city = resultSet.getString("City");
                String country = resultSet.getString("Country");
                String email = resultSet.getString("Email");
                String typeGoods = resultSet.getString("TypeGoods");

                supplier = new Supplier(supplierId, nameCompany, contanctName, states, supplierAddress, postalCode, city, country, email, typeGoods);
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
        return supplier;
    }
     
    public int insert(Supplier supplier) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert);
            
            preparedStatement.setString(1, supplier.getNameCompany());
            preparedStatement.setString(2,supplier.getContanctName());
            preparedStatement.setByte(3, supplier.getStates());
            preparedStatement.setString(4,supplier.getSupplierAddress());
            preparedStatement.setString(5, supplier.getPostalCode());
            preparedStatement.setString(6, supplier.getCity());
            preparedStatement.setString(7, supplier.getCountry());
            preparedStatement.setString(8, supplier.getEmail());
            preparedStatement.setString(9, supplier.getTypeGoods());
            
            row = preparedStatement.executeUpdate();            
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        }finally{
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
    
    
    public int update(Supplier supplier) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_update);
            
            preparedStatement.setString(1, supplier.getNameCompany());
            preparedStatement.setString(2,supplier.getContanctName());
            preparedStatement.setByte(3, supplier.getStates());
            preparedStatement.setString(4,supplier.getSupplierAddress());
            preparedStatement.setString(5, supplier.getPostalCode());
            preparedStatement.setString(6, supplier.getCity());
            preparedStatement.setString(7, supplier.getCountry());
            preparedStatement.setString(8, supplier.getEmail());
            preparedStatement.setString(9, supplier.getTypeGoods());
            preparedStatement.setShort(10, supplier.getSupplierId());
            
            row = preparedStatement.executeUpdate();           
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        }finally{
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
    
    
    public int delete(Supplier supplier) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;        
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_delete);          
            preparedStatement.setShort(1, supplier.getSupplierId());            
            row = preparedStatement.executeUpdate();           
        } catch (SQLException ex) {
            ConnectionDb.processEception(ex);
        }finally{
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
    
    public List<Supplier> selectSupplierId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Supplier supplier = null;
        List<Supplier> suppliers = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_supplierId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short supplierId = resultSet.getShort("SupplierID");
                supplier = new Supplier(supplierId);
                suppliers.add(supplier);
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
        return suppliers;
    }
    
}
