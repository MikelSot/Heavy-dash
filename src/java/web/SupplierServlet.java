package web;

import Data_Base.SupplierQuery;
import Domain.Supplier;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "edit": {
                    try {
                        this.editSupplier(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deleteSupplier(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                        this.insertSupplier(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updateSupplier(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            List<Supplier> suppliers = new SupplierQuery().select();
            session.setAttribute("totalSuppliers", suppliers.size());
            session.setAttribute("suppliers", suppliers);
            response.sendRedirect("supplier.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        short supplierId = Short.parseShort(request.getParameter("supplierId"));
        Supplier supplier = new SupplierQuery().selectSupplier(new Supplier(supplierId));
        request.setAttribute("supplier", supplier);
        String editSupplierJSP = "/WEB-INF/pagesInfo/supplierUtils/editSupplier.jsp";
        request.getRequestDispatcher(editSupplierJSP).forward(request, response);
    }

    private void insertSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();        
        String nameCompany = request.getParameter("nameCompany");
        String contanctName = request.getParameter("contanctName");
        byte states = Byte.parseByte(request.getParameter("states"));
        String supplierAddress = request.getParameter("supplierAddress");
        String postalCode = request.getParameter("postalCode");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String typeGoods = request.getParameter("typeGoods");
        Supplier supplier = new Supplier(nameCompany, contanctName, states, supplierAddress, postalCode, city, country, email, typeGoods);
        int rowAffected = new SupplierQuery().insert(supplier);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro ingresar un registro de proveedor, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Proveedor ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);                
        System.out.println("insert Supplier  -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();        
        short supplierId = Short.parseShort(request.getParameter("supplierId"));
        String nameCompany = request.getParameter("nameCompany");
        String contanctName = request.getParameter("contanctName");
        byte states = Byte.parseByte(request.getParameter("states"));
        String supplierAddress = request.getParameter("supplierAddress");
        String postalCode = request.getParameter("postalCode");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String typeGoods = request.getParameter("typeGoods");
        Supplier supplier = new Supplier(supplierId, nameCompany, contanctName, states, supplierAddress, postalCode, city, country, email, typeGoods);
        int rowAffected = new SupplierQuery().update(supplier);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se actualizo un registro de proveedor, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Proveedor ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);        
        System.out.println("update Supplier -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        short supplierId = Short.parseShort(request.getParameter("supplierId"));
        Supplier supplier = new Supplier(supplierId);
        int rowAffected = new SupplierQuery().delete(supplier);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro eliminar un registro de proveedor, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Proveedor ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete Supplier  -->" + rowAffected);
        this.actionDefault(request, response);
    }
}
