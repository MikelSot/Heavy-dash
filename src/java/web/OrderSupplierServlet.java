package web;

import Data_Base.OrderSupplierQuery;
import Data_Base.SupplierQuery;
import Domain.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/OrderSupplierServlet")
public class OrderSupplierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "edit": {
                    try {
                        this.editOrderSupplier(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deleteOrderSupplier(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                        this.insertOrderSupplier(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updateOrderSupplier(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            List<OrderSupplier> orderSuppliers = new OrderSupplierQuery().select();
            List<Supplier> suppliersId = new SupplierQuery().selectSupplierId();

            session.setAttribute("totalQuantity", this.totalQuantity(orderSuppliers));
            session.setAttribute("suppliersId", suppliersId);
            session.setAttribute("totalOrderSupplier", orderSuppliers.size());
            session.setAttribute("orderSuppliers", orderSuppliers);
            response.sendRedirect("orderSupplier.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(OrderSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void editOrderSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int orderSupplierId = Integer.parseInt(request.getParameter("orderSupplierId"));
        OrderSupplier orderSupplier = new OrderSupplierQuery().selectOrderSupplier(new OrderSupplier(orderSupplierId));
        request.setAttribute("orderSupplier", orderSupplier);
        String editOrderSupplierJSP = "/WEB-INF/pagesInfo/supplierUtils/orderSupplierUtils/editOrderSupplier.jsp";
        request.getRequestDispatcher(editOrderSupplierJSP).forward(request, response);
    }

    private void insertOrderSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        String orderName = request.getParameter("orderName");
        double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
        short quantity = Short.parseShort(request.getParameter("quantity"));
        String orderDescription = request.getParameter("orderDescription");
        byte states = Byte.parseByte(request.getParameter("states"));
        String orderDate = request.getParameter("orderDate");
        String shippedDate = request.getParameter("shippedDate");
        String shippingCompany = request.getParameter("shippingCompany");
        if (shippingCompany == null || shippingCompany.isEmpty()) {
            shippingCompany = null;
        }
        double priceShipping = Double.parseDouble(request.getParameter("priceShipping"));
        short supplierId = Short.parseShort(request.getParameter("supplierId"));
        OrderSupplier orderSupplier = new OrderSupplier(orderName, unitPrice, quantity, orderDescription, states, orderDate, shippedDate, shippingCompany, priceShipping, supplierId);
        int rowAffected = new OrderSupplierQuery().insert(orderSupplier);
        String message = "";
        String icon = "";
        String button = "";
        if (rowAffected == 1) {
            message = "Se logro ingresar un registro de pedido proveedor, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Pedido Proveedor ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("insert OrderSupplier  -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void updateOrderSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        int orderSupplierId = Integer.parseInt(request.getParameter("orderSupplierId"));
        String orderName = request.getParameter("orderName");
        double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
        short quantity = Short.parseShort(request.getParameter("quantity"));
        String orderDescription = request.getParameter("orderDescription");
        byte states = Byte.parseByte(request.getParameter("states"));
        String orderDate = request.getParameter("orderDate");
        String shippedDate = request.getParameter("shippedDate");
        String shippingCompany = request.getParameter("shippingCompany");
        if (shippingCompany == null || shippingCompany.isEmpty()) {
            shippingCompany = null;
        }
        double priceShipping = Double.parseDouble(request.getParameter("priceShipping"));
        short supplierId = Short.parseShort(request.getParameter("supplierId"));
        OrderSupplier orderSupplier = new OrderSupplier(orderSupplierId, orderName, unitPrice, quantity, orderDescription, states, orderDate, shippedDate, shippingCompany, priceShipping, supplierId);
        int rowAffected = new OrderSupplierQuery().Update(orderSupplier);
        String message = "";
        String icon = "";
        String button = "";
        if (rowAffected == 1) {
            message = "Se actualizo un registro de pedido proveedor, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Pedido Proveedor ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("update OrderSupplier  -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void deleteOrderSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        int orderSupplierId = Integer.parseInt(request.getParameter("orderSupplierId"));
        OrderSupplier orderSupplier = new OrderSupplier(orderSupplierId);
        int rowAffected = new OrderSupplierQuery().delete(orderSupplier);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro eliminar un registro de pedido proveedor, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Pedido Proveedor ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete OrderSupplier  -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private int totalQuantity(List<OrderSupplier> orderSuppliers) {
        int totalQuantity = 0;
        for (OrderSupplier orderSupplier : orderSuppliers) {
            totalQuantity += orderSupplier.getQuantity();
        }
        return totalQuantity;
    }

}
