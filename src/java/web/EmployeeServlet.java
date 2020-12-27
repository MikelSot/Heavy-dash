package web;

import Data_Base.*;
import Data_Base.optional_Query.*;
import Domain.Employee;
import QueryClass.SelectChippingEmployee;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import optional.*;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {

                case "edit": {
                    try {
                        this.editEmployees(request, response);
                    } catch (SQLException e) {
                        ConnectionDb.processEception(e);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deleteEmployees(request, response);
                    } catch (SQLException e) {
                        ConnectionDb.processEception(e);
                    }
                }

                break;

                default: // si esque ingresan valores noadminitos
                    this.accionDefault(request, response);

            }

        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            List<Employee> employees = new EmployeeQuery().select();
            List<District> districtsProvice = new DistrictQuery().selectDistrictProvince();
            List<SelectChippingEmployee> selectChippingEmployees = new EmployeeQuery().selectShippingEmployee();
            List<String> stringGerente = new EmployeeQuery().selectGerente();
            List<Employee> employeesId = new EmployeeQuery().selectEmployeeId();

            session.setAttribute("employeesId", employeesId);
            session.setAttribute("employees", employees);
            session.setAttribute("totalEmployees", employees.size());
            session.setAttribute("salaryTotal", this.calculateSalaryTotal(employees));
            session.setAttribute("districtProvince", districtsProvice);
            session.setAttribute("totalDistrics", districtsProvice.size());
            session.setAttribute("stringGerente", stringGerente);
            session.setAttribute("selectChippingEmployees", selectChippingEmployees);
            session.setAttribute("totalselectChippingEmployees", selectChippingEmployees.size());
            response.sendRedirect("employees.jsp");

            System.out.println("empleados  --> " + employees);

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private double calculateSalaryTotal(List<Employee> employees) {
        double salaryTotal = 0;
        for (Employee employee : employees) {
            salaryTotal += employee.getSalary();
        }
        return salaryTotal;
    }

    private void editEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        short shippingEmployeeId = Short.parseShort(request.getParameter("employeeId"));
        short districtID = Short.parseShort(request.getParameter("districtID"));
        int employeeIdBoss = Integer.parseInt(request.getParameter("bossID"));

        Employee employee = new EmployeeQuery().selectEmployee(new Employee(employeeId));
        District district = new District(districtID);
        List<Employee_workDay> employee_workDays = new Employee_WorkDayQuery().selectWorkDay(employee);
        List<PhoneEmployee> phoneEmployees = new Employee_WorkDayQuery().selectPhoneEmployee(employee);
        String ageEmployee = new Employee_WorkDayQuery().selectBirthDateeEmployee(employee);
        String districEmployee = new Employee_WorkDayQuery().selectDistrictEmployee(employee);
        String provinceEmployee = new Employee_WorkDayQuery().selectProvinceEmployee(district);
        List<Employee> employees = new EmployeeQuery().select();
        List<District> districtsProvice = new DistrictQuery().selectDistrictProvince();

        List<String> bossEmployee = new EmployeeQuery().selectBoss(new Employee(employeeIdBoss));
        List<SelectChippingEmployee> selectChippingEmployeeID = new EmployeeQuery().selectShippingEmployeeID(new SelectChippingEmployee(shippingEmployeeId));

        request.setAttribute("employee", employee);
        request.setAttribute("phoneEmployees", phoneEmployees);
        request.setAttribute("employee_workDay", employee_workDays);
        request.setAttribute("ageEmployee", ageEmployee);
        request.setAttribute("districEmployee", districEmployee);
        request.setAttribute("provinceEmployee", provinceEmployee);
        request.setAttribute("totalEmployees", employees);
        request.setAttribute("districtProvince", districtsProvice);
        request.setAttribute("totalDistrics", districtsProvice.size());
        request.setAttribute("bossEmployee", bossEmployee);
        request.setAttribute("selectChippingEmployeeID", selectChippingEmployeeID);
        request.setAttribute("totalSelectChippingEmployeeID", selectChippingEmployeeID.size());
        String editEmployeeJSP = "/WEB-INF/pagesInfo/employeesInfo/editEmployee.jsp";
        request.getRequestDispatcher(editEmployeeJSP).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // paratro de accion
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {

                case "insert": {
                    try {
                        this.insertEmployees(request, response);
                    } catch (SQLException e) {
                        ConnectionDb.processEception(e);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updateEmployees(request, response);
                    } catch (SQLException e) {
                        ConnectionDb.processEception(e);
                    }
                }
                break;

                case "insertPhone": {
                    try {
                        this.insertPhoneEmployees(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "insertWorkDay": {
                    try {
                        this.insertWorkDayEmployees(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                default: // si esque ingresan valores no adminitos
                    this.accionDefault(request, response);
            }

        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dni = request.getParameter("dni");
        String birthDate = request.getParameter("birthDate");
        String email = request.getParameter("email");
        double salary = 0;
        String salaryString = request.getParameter("salary");

        if (salaryString != null && !"".equals(salaryString)) {
            salary = Double.parseDouble(salaryString);
        }
        String employeeAddress = request.getParameter("employeeAddress");
        String postalCode = request.getParameter("postalCode");
        String employeeHours = request.getParameter("employeeHours");
        String turn = request.getParameter("turn");
        String educationLevel = request.getParameter("educationLevel");
        String profession = request.getParameter("profession");
        String position = request.getParameter("position");
        String sex = request.getParameter("sex");
        String states = request.getParameter("states");
        String boss = request.getParameter("boss");

        if (boss == null || boss.isEmpty()) {
            boss = null;
        }
        int districtID = 0;
        String districtIDString = request.getParameter("districtID");

        if (districtIDString != null && !"".equals(districtIDString)) {
            districtID = Integer.parseInt(districtIDString);
        }
        Employee employee = new Employee(firstName, lastName, dni, birthDate, email, salary, employeeAddress, postalCode, employeeHours, turn, educationLevel, profession, position, sex, states, boss, districtID);
        int rowAffected = new EmployeeQuery().insert(employee);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro ingresar un registro de empleado, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Empleado ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("insert empleados-->" + rowAffected);
        this.accionDefault(request, response);
    }

    private void updateEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dni = request.getParameter("dni");
        String birthDate = request.getParameter("birthDate");
        String email = request.getParameter("email");
        double salary = 0;
        String salaryString = request.getParameter("salary");

        if (salaryString != null && !"".equals(salaryString)) {
            salary = Double.parseDouble(salaryString);
        }

        String employeeAddress = request.getParameter("employeeAddress");
        String postalCode = request.getParameter("postalCode");
        String employeeHours = request.getParameter("employeeHours");
        String turn = request.getParameter("turn");
        String educationLevel = request.getParameter("educationLevel");
        String profession = request.getParameter("profession");
        String position = request.getParameter("position");
        String sex = request.getParameter("sex");
        String states = request.getParameter("states");
        String boss = request.getParameter("boss");

        if (boss == null || boss.isEmpty()) {
            boss = null;
        }

        int districtID = 0;
        String districtIDString = request.getParameter("districtID");

        if (districtIDString != null && !"".equals(districtIDString)) {
            districtID = Integer.parseInt(districtIDString);
        }
        Employee employee = new Employee(employeeId, firstName, lastName, dni, birthDate, email, salary, employeeAddress, postalCode, employeeHours, turn, educationLevel, profession, position, sex, states, boss, districtID);
        int rowAffected = new EmployeeQuery().Update(employee);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se actualizo un registro de empleado, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Empleado ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("update empleados--> " + rowAffected);
        this.accionDefault(request, response);
    }

    private void deleteEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = new Employee(employeeId);
        int rowAffected = new EmployeeQuery().delete(employee);
        String message = "";
        String icon = "";
        String button = "";
        if (rowAffected == 1) {
            message = "Se logro eliminar un registro de empleado, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Empleado ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete empleados --> " + rowAffected);
        this.accionDefault(request, response);
    }

    private void insertPhoneEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String phonesEmployeeOne = request.getParameter("phonesEmployeeOne");
        String phonesEmployeeTwo = request.getParameter("phonesEmployeeOne");
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        int rowAffectedTwo = 0;
        PhoneEmployee phoneEmployee = new PhoneEmployee(phonesEmployeeOne, employeeID);
        int rowAffected = new Employee_WorkDayQuery().inserPhoneEmployee(phoneEmployee);
        if (phonesEmployeeTwo != null && !phonesEmployeeTwo.isEmpty()) {
            PhoneEmployee phoneEmployee1 = new PhoneEmployee(phonesEmployeeTwo, employeeID);
            rowAffectedTwo = new Employee_WorkDayQuery().inserPhoneEmployee(phoneEmployee1);

        }
        System.out.println("filas insertadas telefono --> " + rowAffected + rowAffectedTwo);
        // redireccionamos
        this.accionDefault(request, response);
    }

    private void insertWorkDayEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        short employeeID = Short.parseShort(request.getParameter("employeeID"));
        String workDayID = request.getParameter("workDayID");
        byte workDayByte = 0;
        String workDayID2 = request.getParameter("workDayID2");
        byte workDayByte2 = 0;
        String workDayID3 = request.getParameter("workDayID3");
        byte workDayByte3 = 0;

        int rowAffectedTwo = 0;
        int rowAffectedThree = 0;
        int rowAffected = 0;

        if (workDayID != null && !workDayID.isEmpty()) {
            workDayByte = Byte.parseByte(workDayID);
            Employee_workDay employee_workDay = new Employee_workDay(employeeID, workDayByte);
            rowAffected = new Employee_WorkDayQuery().insertWorkdayEmployee(employee_workDay);
        }

        if (workDayID2 != null && !workDayID2.isEmpty()) {
            workDayByte2 = Byte.parseByte(workDayID2);
            Employee_workDay employee_workDay = new Employee_workDay(employeeID, workDayByte2);
            rowAffectedTwo = new Employee_WorkDayQuery().insertWorkdayEmployee(employee_workDay);
        }

        if (workDayID3 != null && !workDayID3.isEmpty()) {
            workDayByte3 = Byte.parseByte(workDayID3);
            Employee_workDay employee_workDay = new Employee_workDay(employeeID, workDayByte3);
            rowAffectedThree = new Employee_WorkDayQuery().insertWorkdayEmployee(employee_workDay);
        }

        System.out.println("dilas insertadas de work day --> " + (rowAffected + rowAffectedTwo + rowAffectedThree));
        // redireccionamos
        this.accionDefault(request, response);
    }

}
