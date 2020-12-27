package Data_Base.optional_Query;

import Data_Base.ConnectionDb;
import Domain.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import optional.District;
import optional.Employee_workDay;
import optional.PhoneEmployee;

public class Employee_WorkDayQuery {

    private static final String sql_select_days = "EXECUTE USP_Select_WorkDay ?"; // dias trabajo

    private static final String sql_select_phone = "EXECUTE USP_Select_PhoneEmployee ?"; 

    private static final String sql_select_birthDate = "EXECUTE USP_Select_BirthDateEmployee ?"; //edad

    private static final String sql_select_district = "EXECUTE USP_Select_DistrictEmployee ?"; // en que distrito vive

    private static final String sql_select_province = "EXECUTE USP_Select_ProvinceEmployee ?"; 

    private static final String sql_insert_phone = "INSERT INTO PhoneEmployee (PhoneNumber,EmployeeID)"
            + " VALUES (?,?)";
    
    
    private static final String sql_insert_WorkDay = "INSERT INTO Employee_WorkDay"
            + " VALUES (?,?)";
    

    
        
    public List<Employee_workDay> selectWorkDay(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee_workDay employee_workDay = null;
        List<Employee_workDay> employee_workDays = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_days);
            preparedStatement.setInt(1, employee.getEmployeeId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String names = resultSet.getString("Names");
                employee_workDay = new Employee_workDay(names);
                employee_workDays.add(employee_workDay);
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
        return employee_workDays;
    }

    public List<PhoneEmployee> selectPhoneEmployee(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        PhoneEmployee phoneEmployee = null;
        List<PhoneEmployee> phoneEmployees = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_phone);
            preparedStatement.setInt(1, employee.getEmployeeId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String phonesEmployee = resultSet.getString("PhoneNumber");
                phoneEmployee = new PhoneEmployee(phonesEmployee);
                phoneEmployees.add(phoneEmployee);
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
        return phoneEmployees;
    }

    public String selectBirthDateeEmployee(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String birthDate = "";

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_birthDate);
            preparedStatement.setInt(1, employee.getEmployeeId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                birthDate = resultSet.getString("Age");
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
        return birthDate;
    }

    public String selectDistrictEmployee(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String districtEmployee = "";

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_district);
            preparedStatement.setInt(1, employee.getEmployeeId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                districtEmployee = resultSet.getString("District");
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
        return districtEmployee;
    }

    public String selectProvinceEmployee(District district) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String provinceEmployee = "";

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_province);
            preparedStatement.setShort(1, district.getDistrictId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                provinceEmployee = resultSet.getString("Province");
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
        return provinceEmployee;
    }

    public int inserPhoneEmployee(PhoneEmployee phoneEmployee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert_phone);
            preparedStatement.setString(1, phoneEmployee.getPhonesEmployee());
            preparedStatement.setInt(2, phoneEmployee.getEmployeeID());
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
    
    public int insertWorkdayEmployee(Employee_workDay employee_workDay) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_insert_WorkDay);
            preparedStatement.setShort(1, employee_workDay.getEmployeeID());
            preparedStatement.setByte(2, employee_workDay.getWorkDayID());
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
