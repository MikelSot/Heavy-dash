package Data_Base;

import Domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryQuery {

    private static final String sql_select = "SELECT * FROM VW_SelectCategory";

    private static final String sql_select_by_id = "EXEC USP_ViewCategory_by_Id ?";

    private static final String sql_insert = "EXECUTE USP_insertCategory ?, ?, ? , ?";

    private static final String sql_update = "EXECUTE USP_updateCategory ?, ?, ?, ?, ?";

    private static final String sql_delete = "EXECUTE USP_DeleteCategory_by_Id ?";
    
    private static final String sql_select_categoryPrincipal = "SELECT * FROM VW_Select_CategoryPrincipal";
    
    private static final String sql_select_categorySubcategory = "SELECT * FROM VW_Select_CategorySubcategory";
    
    private static final String sql_select_categoryThirdLevel = "SELECT * FROM VW_Select_CategoryThirdLevel";
    
    private static final String sql_select_product_by_category = "EXECUTE USP_SelectCategory_Product ?";
    
    private static final String sql_select_categoryId = "EXECUTE USP_SelectcategoryId";

    public List<Category> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        List<Category> categorys = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short categoryId = resultSet.getShort("CategoryID");
                String categoryName = resultSet.getString("CategoryName");
                String description = resultSet.getString("CategoryDescription");
                byte states = resultSet.getByte("States");
                short subCategory = resultSet.getShort("Subcategory");

                category = new Category(categoryId, categoryName, description, states, subCategory);
                categorys.add(category);
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

        return categorys;
    }

    public Category selectCategory(Category category) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id);
            preparedStatement.setShort(1, category.getCategoryId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short categoryId = resultSet.getShort("CategoryID");
                String categoryName = resultSet.getString("CategoryName");
                String description = resultSet.getString("CategoryDescription");
                byte states = resultSet.getByte("States");
                short subCategory = resultSet.getShort("Subcategory");

                category = new Category(categoryId, categoryName, description, states, subCategory);
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

        return category;
    }

    public int insert(Category category) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert);

            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setByte(3, category.getStates());
            preparedStatement.setShort(4, category.getSubCategory());

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

    public int update(Category category) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_update);

            preparedStatement.setShort(1, category.getCategoryId());
            preparedStatement.setString(2, category.getCategoryName());
            preparedStatement.setString(3, category.getDescription());
            preparedStatement.setByte(4, category.getStates());
            preparedStatement.setShort(5, category.getSubCategory());

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

    public int delete(Category category) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_delete);
            preparedStatement.setShort(1, category.getCategoryId());
            
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
       
    public List<Category> selectCategoryPrincipal() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        List<Category> categorys = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_categoryPrincipal);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short categoryId = resultSet.getShort("CategoryID");
                String categoryName = resultSet.getString("CategoryName");
                String description = resultSet.getString("CategoryDescription");
                byte states = resultSet.getByte("States");
                category = new Category(categoryId, categoryName, description, states);
                categorys.add(category);
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

        return categorys;
    }
        
    public List<Category> selectCategorySubcategory() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        List<Category> categorys = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_categorySubcategory);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short categoryId = resultSet.getShort("CategoryID");
                String categoryName = resultSet.getString("CategoryName");
                String description = resultSet.getString("CategoryDescription");
                byte states = resultSet.getByte("States");
                short subCategory = resultSet.getShort("Subcategory");
                category = new Category(categoryId, categoryName, description, states, subCategory);
                categorys.add(category);
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

        return categorys;
    }
    
    public List<Category> selectCategoryThirdLevel() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        List<Category> categorys = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_categoryThirdLevel);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short categoryId = resultSet.getShort("CategoryID");
                String categoryName = resultSet.getString("CategoryName");
                String description = resultSet.getString("CategoryDescription");
                byte states = resultSet.getByte("States");
                short subCategory = resultSet.getShort("Subcategory");
                category = new Category(categoryId, categoryName, description, states, subCategory);
                categorys.add(category);
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

        return categorys;
    }
    
    public List<Product> selectProductByCategory(Category category) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product =  null;
        List<Product> products = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_product_by_category);
            preparedStatement.setShort(1, category.getCategoryId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                String nameProduct = resultSet.getString("NameProduct");
                String sku = resultSet.getString("SKU");
                byte states = resultSet.getByte("States");
                float unitPrice = resultSet.getFloat("UnitPrice");
                short stock = resultSet.getShort("Stock");
                short supplierID= resultSet.getShort("SupplierID");
                product = new Product(productId, nameProduct, sku, states, unitPrice, stock, supplierID);
                products.add(product);
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
        return products;
    }
    
    public List<Category> selectCategoryId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        List<Category> categorys = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_categoryId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                short categoryId = resultSet.getShort("CategoryID");
                category = new Category(categoryId);
                categorys.add(category);
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
        return categorys;
    }
    
}
