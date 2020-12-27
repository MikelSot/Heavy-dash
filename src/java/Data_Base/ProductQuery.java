package Data_Base;

import Domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import optional.Includes;

public class ProductQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_Product";

    private static final String sql_select_by_id = "EXECUTE USP_SelectProduct_by_Id ?";

    private static final String sql_insert = "EXECUTE USP_insertProduct ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_update = "EXECUTE USP_updateProduct ?, ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String sql_delete = "EXECUTE USP_DeleteProduct_by_Id ?";

    private static final String sql_include_by_product = "EXECUTE USP_SelectInclude_Product ?";

    private static final String sql_category_by_product = "EXECUTE USP_SelectProduct_Category ?, ?";

    private static final String sql_quantityOrderByProduct = "EXECUTE USP_SelectQuantity_OrderProduc ?";
    
    private static final String sql_select_productId = "EXECUTE USP_SelectProductId";

    public List<Product> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        List<Product> products = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                String nameProduct = resultSet.getString("NameProduct");
                String sku = resultSet.getString("SKU");
                String measure = resultSet.getString("Measure");
                byte states = resultSet.getByte("States");
                float unitPrice = resultSet.getFloat("UnitPrice");
                short stock = resultSet.getShort("Stock");
                short supplierId = resultSet.getShort("SupplierID");
                short categoryId = resultSet.getShort("CategoryID");

                product = new Product(productId, nameProduct, sku, measure, states, unitPrice, stock, supplierId, categoryId);
                products.add(product);
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

        return products;
    }

    public Product selectProduct(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id);
            preparedStatement.setInt(1, product.getProductId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                String nameProduct = resultSet.getString("NameProduct");
                String sku = resultSet.getString("SKU");
                String measure = resultSet.getString("Measure");
                byte states = resultSet.getByte("States");
                float unitPrice = resultSet.getFloat("UnitPrice");
                short stock = resultSet.getShort("Stock");
                short supplierId = resultSet.getShort("SupplierID");
                short categoryId = resultSet.getShort("CategoryID");

                product = new Product(productId, nameProduct, sku, measure, states, unitPrice, stock, supplierId, categoryId);

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

        return product;
    }

    public int insert(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert);

            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, product.getSku());
            preparedStatement.setString(3, product.getMeasure());
            preparedStatement.setByte(4, product.getStates());
            preparedStatement.setFloat(5, product.getUnitPrice());
            preparedStatement.setShort(6, product.getStock());
            preparedStatement.setShort(7, product.getSupplierId());
            preparedStatement.setShort(8, product.getCategoryId());

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

    public int update(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, product.getSku());
            preparedStatement.setString(3, product.getMeasure());
            preparedStatement.setByte(4, product.getStates());
            preparedStatement.setFloat(5, product.getUnitPrice());
            preparedStatement.setShort(6, product.getStock());
            preparedStatement.setShort(7, product.getSupplierId());
            preparedStatement.setShort(8, product.getCategoryId());
            preparedStatement.setInt(9, product.getProductId());

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

    public int delete(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_delete);
            preparedStatement.setInt(1, product.getProductId());
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

    public List<Includes> selectIncludeProduct(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Includes includes = null;
        List<Includes> includeses = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_include_by_product);
            preparedStatement.setInt(1, product.getProductId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short includeId = resultSet.getShort("IncludeID");
                String nameInclude = resultSet.getString("NameInclude");
                byte active = resultSet.getByte("Active");
                includes = new Includes(includeId, nameInclude, active);
                includeses.add(includes);
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

        return includeses;
    }

    public List<Category> selectProductByCategory(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        List<Category> categorys = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_category_by_product);
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setShort(2, product.getCategoryId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short categoryId = resultSet.getShort("CategoryID");
                String categoryName = resultSet.getString("CategoryName");
                byte states = resultSet.getByte("States");

                category = new Category(categoryId, categoryName, states);
                categorys.add(category);
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
        return categorys;
    }

    public List<Order> selectQuantityOrderByProduct(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Order order = null;
        List<Order> orders = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_quantityOrderByProduct);
            preparedStatement.setInt(1, product.getProductId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderID");
                byte states = resultSet.getByte("States");
                String orderDate = resultSet.getString("OrderDate");
                int userId = resultSet.getInt("UserID");
                short districtId = resultSet.getShort("DistrictID");
                String employeeId = resultSet.getString("EmployeeID"); 
                String shippingComanyId = resultSet.getString("ShippingCompanyID"); 
                short quantity = resultSet.getShort("Quantity");
                
                order= new Order(orderId, states, orderDate, districtId, employeeId, shippingComanyId, userId, quantity);
                orders.add(order);
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
        return orders;
    }
    
    public List<Product> selectProductId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        List<Product> products = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_productId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                product = new Product(productId);
                products.add(product);
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
        return products;
    }

}
