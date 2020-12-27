package Data_Base;

import Domain.Employee;
import QueryClass.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeQuery {

    private static final String SQL_SELECT = "SELECT * FROM VW_SelectEmployee";

    private static final String SQL_SELECT_BY_ID = "EXECUTE USP_SelectEmployee_by_Id ?";

    private static final String SQL_INSERT = "EXECUTE USP_insertEmployee ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String SQL_UPDATE = "EXECUTE USP_updatetEmployee ?, ?,	?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

    private static final String SQL_DELETE = "EXEC USP_DeleteEmployee_by_Id ?";

    private static final String SQL_SELECT_Gerente = "SELECT * FROM VW_Select_Boss";
    
    private static final String SQL_SELECT_Boss = "EXECUTE USP_SelectEmployeeBoss_by_Id ?";

    private static final String SQL_SELECT_Shipping_Employee = "SELECT * FROM VW_Select_ShippingEmployee";
    
    private static final String SQL_SELECT_Shipping_EmployeeID = "EXECUTE USP_ViewShipping_by_EmployeeId ?";
    
    private static final String SQL_SELECT_EmployeeID = "EXECUTE USP_SelectEmployeeId";

    public List<Employee> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        List<Employee> employees = new ArrayList<>();

        try {

            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int employeeId = resultSet.getInt("EmployeeID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String dni = resultSet.getString("Dni");
                String birthDate = resultSet.getString("BirthDate");
                String email = resultSet.getString("Email");
                double salary = resultSet.getDouble("Salary");
                String employeeAddress = resultSet.getString("EmployeeAddress");
                String postalCode = resultSet.getString("PostalCode");
                String employeeHours = resultSet.getString("EmployeeHours");
                String turn = resultSet.getString("Turn");
                String educationLevel = resultSet.getString("EducationLevel");
                String profession = resultSet.getString("Profession");
                String position = resultSet.getString("Position");
                String sex = resultSet.getString("Sex");
                String states = resultSet.getString("States");
                String boss = resultSet.getString("Boss");
                int districtID = resultSet.getInt("DistrictID");

                employee = new Employee(employeeId, firstName, lastName, dni, birthDate, email, salary, employeeAddress, postalCode, employeeHours, turn, educationLevel, profession, position, sex, states, boss, districtID);
                employees.add(employee);

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

        return employees;
    }
    // seleccionar a un empleado por su id
    public Employee selectEmployee(Employee employee) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, employee.getEmployeeId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int employeeId = resultSet.getInt("EmployeeID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String dni = resultSet.getString("Dni");
                String birthDate = resultSet.getString("BirthDate");
                String email = resultSet.getString("Email");
                double salary = resultSet.getDouble("Salary");
                String employeeAddress = resultSet.getString("EmployeeAddress");
                String postalCode = resultSet.getString("PostalCode");
                String employeeHours = resultSet.getString("EmployeeHours");
                String turn = resultSet.getString("Turn");
                String educationLevel = resultSet.getString("EducationLevel");
                String profession = resultSet.getString("Profession");
                String position = resultSet.getString("Position");
                String sex = resultSet.getString("Sex");
                String states = resultSet.getString("States");
                String boss = resultSet.getString("Boss");
                int districtID = resultSet.getInt("DistrictID");
                employee = new Employee(employeeId, firstName, lastName, dni, birthDate, email, salary, employeeAddress, postalCode, employeeHours, turn, educationLevel, profession, position, sex, states, boss, districtID);
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
        return employee;
    }

    public int insert(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getDni());
            preparedStatement.setString(4, employee.getBirthDate());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setString(8, employee.getPostalCode());
            preparedStatement.setString(9, employee.getEmployeeHours());
            preparedStatement.setString(10, employee.getTurn());
            preparedStatement.setString(11, employee.getEducationLevel());
            preparedStatement.setString(12, employee.getProfession());
            preparedStatement.setString(13, employee.getPosition());
            preparedStatement.setString(14, employee.getSex());
            preparedStatement.setString(15, employee.getStates());
            preparedStatement.setString(16, employee.getBoss());
            preparedStatement.setInt(17, employee.getDistrictID());

            rows = preparedStatement.executeUpdate();
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
        return rows;
    }

    public int Update(Employee employee) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {

            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getDni());
            preparedStatement.setString(4, employee.getBirthDate());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setString(8, employee.getPostalCode());
            preparedStatement.setString(9, employee.getEmployeeHours());
            preparedStatement.setString(10, employee.getTurn());
            preparedStatement.setString(11, employee.getEducationLevel());
            preparedStatement.setString(12, employee.getProfession());
            preparedStatement.setString(13, employee.getPosition());
            preparedStatement.setString(14, employee.getSex());
            preparedStatement.setString(15, employee.getStates());
            preparedStatement.setString(16, employee.getBoss());
            preparedStatement.setInt(17, employee.getDistrictID());
            preparedStatement.setInt(18, employee.getEmployeeId());

            rows = preparedStatement.executeUpdate();

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

        return rows;
    }

    public int delete(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, employee.getEmployeeId());
            rows = preparedStatement.executeUpdate();
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

        return rows;
    }

    public List<String> selectGerente() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> gerenteNames = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_Gerente);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String gerenteName = resultSet.getString("FirstName");
                String gereteLastName = resultSet.getString("LastName");
                gerenteNames.add(gerenteName);
                gerenteNames.add(gereteLastName);
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
        return gerenteNames;
    }

    public List<String> selectBoss(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> selectBoss = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_Boss);
            preparedStatement.setInt(1, employee.getEmployeeId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String bossName = resultSet.getString("FirstName");
                String bossLastName = resultSet.getString("LastName");
                selectBoss.add(bossName);
                selectBoss.add(bossLastName);
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
        return selectBoss;
    }

    public List<SelectChippingEmployee> selectShippingEmployee() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SelectChippingEmployee selectChippingEmployee = null;
        List<SelectChippingEmployee> selectChippingEmployees = new ArrayList<>();

        try {

            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_Shipping_Employee);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short  orderID  = resultSet.getShort("OrderID");
                short  employeeID  = resultSet.getShort("EmployeeID");
                String employeeName = resultSet.getString("FirstName");
                String employeeLastName = resultSet.getString("LastName");
                String productName = resultSet.getString("NameProduct");
                short productID = resultSet.getShort("productID");

                selectChippingEmployee = new SelectChippingEmployee(orderID, employeeID, employeeName, employeeLastName, productName, productID);
                selectChippingEmployees.add(selectChippingEmployee);
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

        return selectChippingEmployees;
    }

    public List<SelectChippingEmployee> selectShippingEmployeeID(SelectChippingEmployee selectChippingEmployee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<SelectChippingEmployee> selectChippingEmployees = new ArrayList<>();

        try {

            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_Shipping_EmployeeID);
            preparedStatement.setShort(1, selectChippingEmployee.getEmployeeID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short  orderID  = resultSet.getShort("OrderID");
                short  employeeID  = resultSet.getShort("EmployeeID");
                String employeeName = resultSet.getString("FirstName");
                String employeeLastName = resultSet.getString("LastName");
                String productName = resultSet.getString("NameProduct");
                short productID = resultSet.getShort("productID");

                selectChippingEmployee = new SelectChippingEmployee(orderID, employeeID, employeeName, employeeLastName, productName, productID);
                selectChippingEmployees.add(selectChippingEmployee);
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

        return selectChippingEmployees;
    }
    
    public List<Employee> selectEmployeeId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        List<Employee> employees = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_EmployeeID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("EmployeeID");
                employee = new Employee(employeeId);
                employees.add(employee);
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
        return employees;
    }
}
