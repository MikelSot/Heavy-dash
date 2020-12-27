package Data_Base.optional_Query;

import Data_Base.ConnectionDb;
import Domain.TypeAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TypeAddressQuery {

    private final String sql_select = "SELECT * FROM VW_Select_TypeAddress";

    public List<TypeAddress> select() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        TypeAddress typeAddress = null;
        List<TypeAddress> typeAddresses = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                byte typeAddressId = resultSet.getByte("TypeAddressID");
                String addressName = resultSet.getString("AddressName");
                typeAddress = new TypeAddress(typeAddressId, addressName);
                typeAddresses.add(typeAddress);
            }
        } catch (SQLException e) {
            ConnectionDb.processEception(e);
        }finally{
            ConnectionDb.close(connection);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(resultSet);
        }

        return typeAddresses;
    }

}
