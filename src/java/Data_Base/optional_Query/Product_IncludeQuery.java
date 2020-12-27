
package Data_Base.optional_Query;

import Data_Base.ConnectionDb;
import Domain.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import optional.Product_Include;
public class Product_IncludeQuery {
    
    private static final String sql_select = "EXECUTE USP_SelectInclude_Product ?"; // que incluye cada producto

    
    
    public List<Product_Include> select(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product_Include product_Include = null;
        List<Product_Include> product_Includes = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            preparedStatement.setInt(1, product.getProductId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String includeName = resultSet.getString("NameInclude"); 
                product_Include = new Product_Include(includeName);
                product_Includes.add(product_Include);
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
        return product_Includes;
    }
    
}
