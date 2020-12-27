package Data_Base.optional_Query;

import Data_Base.ConnectionDb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import optional.District;
import optional.Province;

public class DistrictQuery {

    private static final String sql_select_provice = "SELECT ProvinceID, Province FROM Province";

    private static final String sql_select_by_id_province = "SELECT ProvinceID, Province FROM Province WHERE ProvinceID = ?";

    private static final String sql_select_district = "SELECT DistrictID, District, ProvinceID FROM District";

    private static final String sql_select_by_id_district = "SELECT DistrictID, District, ProvinceID FROM District WHERE DistrictID = ?";

    private static final String sql_select_DistrictProvince = "SELECT * FROM VW_Select_DistrictProvince";

    public List<Province> selectProvince() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Province province = null;
        List<Province> provinces = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_provice);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short provinceID = resultSet.getShort("ProvinceID");
                String provinceName = resultSet.getString("Department");
                province = new Province(provinceID, provinceName);
                provinces.add(province);
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
        return provinces;
    }

    public Province selectProvinceById(Province province) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id_province);
            preparedStatement.setShort(1, province.getProvinceId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                short provinceID = resultSet.getShort("ProvinceID");
                String provinceName = resultSet.getString("Department");
                province = new Province(provinceID, provinceName);
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
        return province;
    }

    public List<District> selectDistrict() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        District district = null;
        List<District> districts = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_district);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short districtID = resultSet.getShort("DistrictID");
                String districtName = resultSet.getString("District");
                short provinceId = resultSet.getByte("ProvinceID");
                district = new District(districtID, districtName, provinceId);
                districts.add(district);
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
        return districts;
    }

    public District selectDistrictById(District district) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_id_district);
            preparedStatement.setShort(1, district.getDistrictId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short districtID = resultSet.getShort("DistrictID");
                String districtName = resultSet.getString("District");
                short provinceId = resultSet.getByte("ProvinceID");
                district = new District(districtID, districtName, provinceId);
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
        return district;
    }
    
    
    public List<District> selectDistrictProvince() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        District district = null;
        List<District> districts = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_DistrictProvince);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short districtID = resultSet.getShort("DistrictID");
                String districtName = resultSet.getString("District");
                String province = resultSet.getString("NameProvince");
                
                district = new District(districtID, districtName, province);
                districts.add(district);
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
        return districts;
    }

}
