package web;

import Data_Base.*;
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

@WebServlet("/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "edit": {
                    try {
                        this.editOrderDetail(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deleteOrderDetail(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                        this.insertOrderDetail(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updateOrderDetail(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            List<OrderDetail> orderDetails = new OrderDetailsQuery().select();
            List<Product> productsId = new ProductQuery().selectProductId();
            List<Order> ordersId = new OrderQuery().selectOrderId();
            List<Order> selectOrderDetailsOrders = new OrderDetailsQuery().selectOrderDetailsOrders();
            List<Product> selectOrderDetailsProduct = new OrderDetailsQuery().selectOrderDetailsProduct();

            session.setAttribute("selectOrderDetailsOrders", selectOrderDetailsOrders);
            session.setAttribute("totalSelectOrderDetailsOrders", selectOrderDetailsOrders.size());
            session.setAttribute("selectOrderDetailsProduct", selectOrderDetailsProduct);
            session.setAttribute("totalSelectOrderDetailsProduct", selectOrderDetailsProduct.size());
            session.setAttribute("productsId", productsId);
            session.setAttribute("ordersId", ordersId);
            session.setAttribute("totalQunatity", this.totalQuantity(orderDetails));
            session.setAttribute("totalOrderDetails", orderDetails.size());
            session.setAttribute("orderDetails", orderDetails);
            response.sendRedirect("orderDetails.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editOrderDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {

        int orderDetailId = Integer.parseInt(request.getParameter("orderDetailId"));
        OrderDetail orderDetail = new OrderDetailsQuery().selectOrderDetail(new OrderDetail(orderDetailId));
        User selectOrderDetailIdUserId = new OrderDetailsQuery().selectOrderDetailIdUserId(new OrderDetail(orderDetailId));
        SelectUserOrders selectOrderDetailIdOrders = new OrderDetailsQuery().selectOrderDetailIdOrders(new OrderDetail(orderDetailId));
        Product selectOrderDetailIdProduct = new OrderDetailsQuery().selectOrderDetailIdProduct(new OrderDetail(orderDetailId));
        
        request.setAttribute("selectOrderDetailIdUserId", selectOrderDetailIdUserId);
        request.setAttribute("selectOrderDetailIdOrders", selectOrderDetailIdOrders);
        request.setAttribute("selectOrderDetailIdProduct", selectOrderDetailIdProduct);
        request.setAttribute("orderDetail", orderDetail);
        String editOrderDetails = "/WEB-INF/pagesInfo/orderUtils/orderDetails/editOrderDetails.jsp";
        request.getRequestDispatcher(editOrderDetails).forward(request, response);;
    }

    private void insertOrderDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        HttpSession session = request.getSession();
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        short quantity = Short.parseShort(request.getParameter("quantity"));

        OrderDetail orderDetail = new OrderDetail(orderId, productId, quantity);
        int rowAffected = new OrderDetailsQuery().insert(orderDetail);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro ingresar un registro detalle pedido, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Detalle Pedido ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("insert OrderDetails  -->" + rowAffected);
        this.actionDefault(request, response);

    }

    private void updateOrderDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        HttpSession session = request.getSession();
        int orderDetailId = Integer.parseInt(request.getParameter("orderDetailId"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        short quantity = Short.parseShort(request.getParameter("quantity"));

        OrderDetail orderDetail = new OrderDetail(orderDetailId, orderId, productId, quantity);
        int rowAffected = new OrderDetailsQuery().update(orderDetail);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se actualizo un registro detalle pedido, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Detalle Pedido ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("update OrderDetails  -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void deleteOrderDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        HttpSession session = request.getSession();
        int orderDetailId = Integer.parseInt(request.getParameter("orderDetailId"));
        OrderDetail orderDetail = new OrderDetail(orderDetailId);
        int rowAffected = new OrderDetailsQuery().delete(orderDetail);

        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro eliminar un registro detalle pedido, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Detalle Pedido ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete OrderDetails  -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private short totalQuantity(List<OrderDetail> orderDetails) {
        short totalQuantity = 0;
        for (OrderDetail orderDetail : orderDetails) {
            totalQuantity += orderDetail.getQuantity();
        }
        return totalQuantity;
    }

}
