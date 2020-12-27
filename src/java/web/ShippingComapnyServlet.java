package web;

import Data_Base.ShippingCompanyQuery;
import Data_Base.optional_Query.*;
import Domain.ShippingCompany;
import QueryClass.SelectUserPayments;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import optional.*;

@WebServlet("/ShippingCompanyServlet")
public class ShippingComapnyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "edit": {
                    try {
                        this.editShippingCompany(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ShippingComapnyServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deleteShippingCompany(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ShippingComapnyServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                        this.insertShippingCompany(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ShippingComapnyServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updateShippingCompany(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ShippingComapnyServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            List<ShippingCompany> shippingCompanys = new ShippingCompanyQuery().select();
            List<Agency> agencys = new AgencyQuery().select();
            List<District> districtsProvice = new DistrictQuery().selectDistrictProvince();
            List<SelectUserPayments> vwShippingCompanyOrders = new ShippingCompanyQuery().selectvwShippingCompanyOrders();

            session.setAttribute("vwShippingCompanyOrders", vwShippingCompanyOrders);
            session.setAttribute("totalvwShippingCompanyOrders", vwShippingCompanyOrders.size());
            session.setAttribute("districtProvince", districtsProvice);
            session.setAttribute("agencys", agencys);
            session.setAttribute("totalAgencys", agencys.size());
            session.setAttribute("shippingCompanys", shippingCompanys);
            session.setAttribute("totalShippingCompanys", shippingCompanys.size());
            response.sendRedirect("shippingCompany.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(ShippingComapnyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editShippingCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        short shippingCompanyId = Short.parseShort(request.getParameter("shippingCompanyId"));
        ShippingCompany shippingCompany = new ShippingCompanyQuery().selectShippingCompany(new ShippingCompany(shippingCompanyId));
        List<Agency> agencys = new AgencyQuery().selectAgency(new Agency(shippingCompanyId));
        request.setAttribute("agencys", agencys);
        request.setAttribute("totalAgencys", agencys.size());
        request.setAttribute("shippingCompany", shippingCompany);
        String editOrderJSP = "/WEB-INF/pagesInfo/shippingCompanyUtils/editShippingCompany.jsp";
        request.getRequestDispatcher(editOrderJSP).forward(request, response);
    }

    private void insertShippingCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        HttpSession session = request.getSession();
        String companyName = request.getParameter("companyName");
        String contactName = request.getParameter("contactName");
        byte active = Byte.parseByte(request.getParameter("active"));
        String companyAddres = request.getParameter("companyAddres");
        String postalCode = request.getParameter("postalCode");
        String email = request.getParameter("email");

        ShippingCompany shippingCompany = new ShippingCompany(companyName, contactName, active, companyAddres, postalCode, email);
        int rowAffected = new ShippingCompanyQuery().insert(shippingCompany);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro ingresar un registro de empresa envio, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Empresa Envio ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("insert ShippingCompany  -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void updateShippingCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        HttpSession session = request.getSession();
        short shippingCompanyId = Short.parseShort(request.getParameter("shippingCompanyId"));
        String companyName = request.getParameter("companyName");
        String contactName = request.getParameter("contactName");
        byte active = Byte.parseByte(request.getParameter("active"));
        String companyAddres = request.getParameter("companyAddres");
        String postalCode = request.getParameter("postalCode");
        String email = request.getParameter("email");

        ShippingCompany shippingCompany = new ShippingCompany(shippingCompanyId, companyName, contactName, active, companyAddres, postalCode, email);
        int rowAffected = new ShippingCompanyQuery().update(shippingCompany);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se actualizo un registro de empresa envio, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Empresa Envio ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("update ShippingCompany -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void deleteShippingCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        HttpSession session = request.getSession();
        short shippingCompanyId = Short.parseShort(request.getParameter("shippingCompanyId"));
        ShippingCompany shippingCompany = new ShippingCompany(shippingCompanyId);
        int rowAffected = new ShippingCompanyQuery().delete(shippingCompany);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro eliminar un registro de empresa envio, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Empresa Envio ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete ShippingCompany -->" + rowAffected);
        this.actionDefault(request, response);
    }
}
