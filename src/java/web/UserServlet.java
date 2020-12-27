package web;

import Data_Base.*;
import Data_Base.optional_Query.RoleQuery;
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
import optional.Role;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "edit": {
                    try {
                        this.editUser(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deleteUser(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                        this.insertUser(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updateUser(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            List<User> users = new UserQuery().select();
            List<User> inactiveUsers = new UserQuery().selectInactiveUser();
            List<Role> roles = new RoleQuery().select();

            session.setAttribute("roles", roles);
            session.setAttribute("totalRoles", roles.size());
            session.setAttribute("totalInactiveUsers", inactiveUsers.size());
            session.setAttribute("inactiveUsers", inactiveUsers);
            session.setAttribute("totalUsers", users.size());
            session.setAttribute("users", users);
            response.sendRedirect("users.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = new UserQuery().selectUser(new User(userId));
        String role = new UserQuery().selectUserRole(new User(userId));
        List<SelectUserOrders> selectUserOrders = new UserQuery().selectUserOrders(new User(userId));
        List<Payment> selectUserPayment = new UserQuery().selectUserPayment(new User(userId));
        List<SelectUserOrders> selectUserOrderDetails = new UserQuery().selectUserOrderDetails(new User(userId));

        request.setAttribute("role", role);
        request.setAttribute("selectUserOrders", selectUserOrders);
        request.setAttribute("totalSelectUserOrders", selectUserOrders.size());
        request.setAttribute("selectUserPayment", selectUserPayment);
        request.setAttribute("totalSelectUserPayment", selectUserPayment.size());
        request.setAttribute("selectUserOrderDetails", selectUserOrderDetails);
        request.setAttribute("totalSelectUserOrderDetails", selectUserOrderDetails.size());
        request.setAttribute("user", user);
        String editUserJSP = "/WEB-INF/pagesInfo/userUtils/editUser.jsp";
        request.getRequestDispatcher(editUserJSP).forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        String nickName = request.getParameter("nickName");
        if (nickName == null || nickName.isEmpty()) {
            nickName = null;
        }
        String email = request.getParameter("email");
        String userPassword = request.getParameter("userPassword");
        byte active = Byte.parseByte(request.getParameter("active"));
        short roleId = Short.parseShort(request.getParameter("roleId"));
        User user = new User(userName, nickName, email, userPassword, active, roleId);
        int rowAffected = new UserQuery().insert(user);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro ingresar un registro de usuario, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Usuario ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("insert User  -->" + rowAffected);
        this.actionDefault(request, response);

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String nickName = request.getParameter("nickName");
        if (nickName == null || nickName.isEmpty()) {
            nickName = null;
        }
        String email = request.getParameter("email");
        String userPassword = request.getParameter("userPassword");
        byte active = Byte.parseByte(request.getParameter("active"));
        short roleId = Short.parseShort(request.getParameter("roleId"));
        User user = new User(userId, userName, nickName, email, userPassword, active, roleId);
        int rowAffected = new UserQuery().update(user);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se actualizo un registro de usuario, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Usuario ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("update User -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = new User(userId);
        int rowAffected = new UserQuery().delete(user);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1 || rowAffected == 0) {
            message = "Se logro eliminar un registro de usuario, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Usuario ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete User  -->" + rowAffected);
        this.actionDefault(request, response);
    }
}
