package web;

import Data_Base.*;
import Domain.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        try {
            HttpSession session = request.getSession();
            List<Employee> employees = new EmployeeQuery().select();
            List<Order> orders = new OrderQuery().select();
            List<User> users = new UserQuery().select();
            List<Supplier> suppliers = new SupplierQuery().select();
            List<Product> products = new ProductQuery().select();
            List<OrderSupplier> orderSuppliers = new OrderSupplierQuery().select();
            List<Payment> payments =  new PaymentQuery().select();
            session.setAttribute("totalFactura", payments.size());
            session.setAttribute("totalOrdersupplier", orderSuppliers.size());
            session.setAttribute("toatlProducts", products.size());
            session.setAttribute("totalSupplier", suppliers.size());
            session.setAttribute("toatlUsers", users.size());
            session.setAttribute("totalOrders", orders.size());
            session.setAttribute("totalEmployees", employees.size());
            response.sendRedirect("principal.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
