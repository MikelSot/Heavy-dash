package web;

import Data_Base.*;
import Data_Base.optional_Query.*;
import Domain.*;
import QueryClass.SelectUserOrders;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import optional.District;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "edit": {
                    try {
                        this.editOrder(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deleteOrder(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                default:
                    this.actionDefault(request, response);

            }
        } else {
            this.actionDefault(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "insert": {
                    try {
                        this.inserOrder(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updateOrder(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                default:
                    this.actionDefault(request, response);
            }
        } else {
            this.actionDefault(request, response);
        }

    }

    private void actionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            HttpSession session = request.getSession();
            List<Order> orders = new OrderQuery().select();
            List<User> userIds = new UserQuery().selectUserId();
            List<Employee> employeesId = new EmployeeQuery().selectEmployeeId();
            List<ShippingCompany> shippingCompanysId = new ShippingCompanyQuery().selectShippingCompanyId();
            List<TypeAddress> typeAddresses = new TypeAddressQuery().select();
            List<District> districtsProvice = new DistrictQuery().selectDistrictProvince();
            List<SelectUserOrders> vwOrderShippings = new OrderQuery().selectvwOrderShipping();
            List<SelectUserOrders> vwOrderEmployees = new OrderQuery().selectvwOrderEmployee();
                        
            session.setAttribute("vwOrderShippings", vwOrderShippings);
            session.setAttribute("totalvwOrderShippings", vwOrderShippings.size());
            session.setAttribute("vwOrderEmployees", vwOrderEmployees);
            session.setAttribute("totalvwOrderEmployees", vwOrderEmployees.size());
            session.setAttribute("districtProvince", districtsProvice);
            session.setAttribute("typeAddresses", typeAddresses);
            session.setAttribute("totalTypeAddresses", typeAddresses.size());
            session.setAttribute("userIds", userIds);
            session.setAttribute("employeesId", employeesId);
            session.setAttribute("shippingCompanysId", shippingCompanysId);
            session.setAttribute("totalOrders", orders.size());
            session.setAttribute("orders", orders);
            response.sendRedirect("orders.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        byte typeAddress = Byte.parseByte(request.getParameter("typeAddress"));
        short districtId = Short.parseShort(request.getParameter("districtId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        Order order = new OrderQuery().selectOrder(new Order(orderId));
        User selectOrdersUser = new OrderQuery().selectOrdersUserId(new User(userId), new Order(orderId));
        District selectOrdersDistrict = new OrderQuery().selectOrdersDistricId(new District(districtId), new Order(orderId));
        TypeAddress selectOrdersTypeAddress = new OrderQuery().selectOrdersTypeAddressID(new TypeAddress(typeAddress), new Order(orderId));
        String modalMessage = "";

        String shipping = "";
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        short shippingCompanyId = Short.parseShort(request.getParameter("shippingComanyId"));
        if (employeeId != 0) {
            Employee selectOrdersEmployee = new OrderQuery().selectOrdersEmployeeID(new Employee(employeeId), new Order(orderId));
            modalMessage = "#viewSelectOrdersEmployee";
            shipping = "Empleado";
            request.setAttribute("selectOrdersEmployee", selectOrdersEmployee);
        }
        if (shippingCompanyId != 0) {
            ShippingCompany selectOrdersShippingCompany = new OrderQuery().selectOrdersShippingCompanyID(new ShippingCompany(shippingCompanyId), new Order(orderId));
            modalMessage = "#viewSelectOrdersShippingCompany";
            shipping = "Empresa";
            request.setAttribute("selectOrdersShippingCompany", selectOrdersShippingCompany);
        }

        request.setAttribute("shipping", shipping);
        request.setAttribute("modalMessage", modalMessage);
        request.setAttribute("selectOrdersUser", selectOrdersUser);
        request.setAttribute("selectOrdersDistrict", selectOrdersDistrict);
        request.setAttribute("selectOrdersTypeAddress", selectOrdersTypeAddress);
        request.setAttribute("order", order);
        String editOrderJSP = "/WEB-INF/pagesInfo/orderUtils/editOrder.jsp";
        request.getRequestDispatcher(editOrderJSP).forward(request, response);
    }

    private void inserOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        byte states = Byte.parseByte(request.getParameter("states"));
        String orderDate = request.getParameter("orderDate");
        String shippingDate = request.getParameter("shippingDate");
        String orderAdderss = request.getParameter("orderAdderss");
        String lot = request.getParameter("lot");
        String reference = request.getParameter("reference");
        String dni = request.getParameter("dni");
        String name = request.getParameter("name");
        String lastNa0me = request.getParameter("lastName");
        byte typeAddress = Byte.parseByte(request.getParameter("typeAddress"));
        short districtId = Short.parseShort(request.getParameter("districtId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String employeeId = request.getParameter("employeeId");
        String shippingComanyId = request.getParameter("shippingComanyId");
        int rowAffected = 0;

        if (employeeId == null || employeeId.isEmpty()) {
            employeeId = null;
            Order order = new Order(states, orderDate, shippingDate, orderAdderss, lot, reference, dni, name, lastNa0me, typeAddress, districtId, employeeId, shippingComanyId, userId);
            rowAffected = new OrderQuery().insert(order);
        }

        if (shippingComanyId == null || shippingComanyId.isEmpty()) {
            shippingComanyId = null;
            Order order = new Order(states, orderDate, shippingDate, orderAdderss, lot, reference, dni, name, lastNa0me, typeAddress, districtId, employeeId, shippingComanyId, userId);
            rowAffected = new OrderQuery().insert(order);
        }
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro ingresar un registro de pedido, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Pedido ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("insert Order -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        byte states = Byte.parseByte(request.getParameter("states"));
        String orderDate = request.getParameter("orderDate");
        String shippingDate = request.getParameter("shippingDate");
        String orderAdderss = request.getParameter("orderAdderss");
        String lot = request.getParameter("lot");
        String reference = request.getParameter("reference");
        String dni = request.getParameter("dni");
        String name = request.getParameter("name");
        String lastNa0me = request.getParameter("lastName");
        byte typeAddress = Byte.parseByte(request.getParameter("typeAddress"));
        short districtId = Short.parseShort(request.getParameter("districtId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String employeeId = request.getParameter("employeeId");
        String shippingComanyId = request.getParameter("shippingComanyId");
        int rowAffected = 0;

        if (employeeId == null || employeeId.isEmpty()) {
            employeeId = null;
            Order order = new Order(orderId, states, orderDate, shippingDate, orderAdderss, lot, reference, dni, name, lastNa0me, typeAddress, districtId, employeeId, shippingComanyId, userId);
            rowAffected = new OrderQuery().update(order);
        }

        if (shippingComanyId == null || shippingComanyId.isEmpty()) {
            shippingComanyId = null;
            Order order = new Order(orderId, states, orderDate, shippingDate, orderAdderss, lot, reference, dni, name, lastNa0me, typeAddress, districtId, employeeId, shippingComanyId, userId);
            rowAffected = new OrderQuery().update(order);
        }
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se actualizo un registro de pedido, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Pedido ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("update Order -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = new Order(orderId);
        int rowAffected = new OrderQuery().delete(order);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro eliminar un registro de pedido, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Pedido ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete Order  -->" + rowAffected);
        this.actionDefault(request, response);
    }

}
