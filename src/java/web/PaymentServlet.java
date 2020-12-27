package web;

import Data_Base.*;
import Data_Base.optional_Query.*;
import Domain.*;
import QueryClass.SelectUserPayments;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "edit": {
                    try {
                        this.editPayment(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deletePayment(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                        this.insertPayment(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updatePayment(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            List<Payment> payments = new PaymentQuery().select();
            HttpSession session = request.getSession();
            List<Invoice> invoicesId = new InvoiceQuery().selectInvoiceId();
            List<OrderDetail> orderDetailsId = new OrderDetailsQuery().selectOrderDetailsId();
            List<User> usersId = new UserQuery().selectUserId();
            List<Invoice> invoices = new InvoiceQuery().select();

            session.setAttribute("invoices", invoices);
            session.setAttribute("invoicesId", invoicesId);
            session.setAttribute("orderDetailsId", orderDetailsId);
            session.setAttribute("usersId", usersId);
            session.setAttribute("totalInvoicesId", invoicesId.size());
            session.setAttribute("totalPayments", payments.size());
            session.setAttribute("payments", payments);
            response.sendRedirect("payment.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editPayment(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int orderDetailId = Integer.parseInt(request.getParameter("orderDetailId"));
        Payment payment = new PaymentQuery().selectPayment(new Payment(paymentId));
        Invoice invoiceById = new InvoiceQuery().selectInvoiceById(new Invoice(invoiceId));
        User selectPaymentUserByID = new PaymentQuery().selectPaymentUserById(new User(userId), new Payment(paymentId));
        List<SelectUserPayments> selectUserPayments = new PaymentQuery().selectUserpayments(new User(userId), new Payment(paymentId));
        SelectUserPayments selectOrderDetailsProductoPaymentID = new PaymentQuery().selectOrderDetailsProductoPaymentId(new Payment(paymentId), new OrderDetail(orderDetailId));
        SelectUserPayments selectOrderPaymentID = new PaymentQuery().selectOrderPaymentId(new Payment(paymentId), new OrderDetail(orderDetailId));
        List<SelectUserPayments> selectProductPaymentses = new PaymentQuery().selectProductPayments(new OrderDetail(orderDetailId));
        List<SelectUserPayments> selectInvoicesPaymentses = new PaymentQuery().selectInvoicesPayments(new Invoice(invoiceId));
        List<Invoice> invoices = new InvoiceQuery().select();

        request.setAttribute("invoices", invoices);
        request.setAttribute("selectInvoicesPaymentses", selectInvoicesPaymentses);
        request.setAttribute("totalSelectInvoicesPaymentses", selectInvoicesPaymentses.size());
        request.setAttribute("selectProductPaymentses", selectProductPaymentses);
        request.setAttribute("totalSelectProductPaymentses", selectProductPaymentses.size());
        request.setAttribute("selectOrderPaymentID", selectOrderPaymentID);
        request.setAttribute("selectOrderDetailsProductoPaymentID", selectOrderDetailsProductoPaymentID);
        request.setAttribute("selectUserPayments", selectUserPayments);
        request.setAttribute("totalSelectUserPayments", selectUserPayments.size());
        request.setAttribute("selectPaymentUserByID", selectPaymentUserByID);
        request.setAttribute("payment", payment);
        request.setAttribute("invoiceById", invoiceById);
        String editPaymentJSP = "/WEB-INF/pagesInfo/paymentUtils/editPayment.jsp";
        request.getRequestDispatcher(editPaymentJSP).forward(request, response);
    }

    private void insertPayment(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        String paymentDate = request.getParameter("paymentDate");
        int userId = Integer.parseInt(request.getParameter("userId"));
        int orderDetailId = Integer.parseInt(request.getParameter("orderDetailId"));
        String invoiceId = request.getParameter("invoiceId");
        int rowAffected = 0;
        if (invoiceId == null || invoiceId.isEmpty()) {
            invoiceId = null;
            Payment payment = new Payment(paymentDate, userId, orderDetailId, invoiceId);
            rowAffected = new PaymentQuery().insert(payment);
        } else {
            Payment payment = new Payment(paymentDate, userId, orderDetailId, invoiceId);
            rowAffected = new PaymentQuery().insert(payment);
        }
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro ingresar un registro de pago, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Pago ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("insert Payment  -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void updatePayment(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        String paymentDate = request.getParameter("paymentDate");
        int userId = Integer.parseInt(request.getParameter("userId"));
        int orderDetailId = Integer.parseInt(request.getParameter("orderDetailId"));
        String invoiceId = request.getParameter("invoiceId");

        int rowAffected = 0;
        if (invoiceId == null || invoiceId.isEmpty()) {
            invoiceId = null;
            Payment payment = new Payment(paymentId, paymentDate, userId, orderDetailId, invoiceId);
            rowAffected = new PaymentQuery().update(payment);
        } else {
            Payment payment = new Payment(paymentId, paymentDate, userId, orderDetailId, invoiceId);
            rowAffected = new PaymentQuery().update(payment);
        }

        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se actualizo un registro de pago, filas afectadas " + rowAffected + " PaymentId ->" + paymentId;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Pago ->" + rowAffected + " PaymentId ->" + paymentId;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("update Payment -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void deletePayment(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        Payment payment = new Payment(paymentId);
        int rowAffected = new PaymentQuery().delete(payment);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro eliminar un registro de pago, filas afectadas " + rowAffected + " PaymentId ->" + paymentId;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Pago ->" + rowAffected + " PaymentId ->" + paymentId;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete Payment -->" + rowAffected);
        this.actionDefault(request, response);
    }

}
