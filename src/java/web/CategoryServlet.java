package web;

import Data_Base.*;
import Domain.Category;
import Domain.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "edit": {
                    try {
                        this.editCategory(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deleteCategory(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                        this.insertCategory(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updateCategory(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            List<Category> categorys = new CategoryQuery().select();
            List<Category> categorysPrincipal = new CategoryQuery().selectCategoryPrincipal();
            List<Category> categorysSubcategory = new CategoryQuery().selectCategorySubcategory();
            List<Category> categorysThirLevel = new CategoryQuery().selectCategoryThirdLevel();
            List<Category> categorysId = new CategoryQuery().selectCategoryId();

            session.setAttribute("categorysId", categorysId);
            session.setAttribute("catgorySubcategory", categorysSubcategory);
            session.setAttribute("totalCatgorySubcategory", categorysSubcategory.size());
            session.setAttribute("categoryPrincipal", categorysPrincipal);
            session.setAttribute("totalCategoryPrincipal", categorysPrincipal.size());
            session.setAttribute("catgoryThirdLevel", categorysThirLevel);
            session.setAttribute("totalCatgoryThirdLevel", categorysThirLevel.size());
            session.setAttribute("categories", categorys);
            session.setAttribute("totalCategories", categorys.size());
            response.sendRedirect("category.jsp");

            System.out.println("categorias --> " + categorys);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        short categoryId = Short.parseShort(request.getParameter("categoryId"));
        List<Product> products = new CategoryQuery().selectProductByCategory(new Category(categoryId));
        Category category = new CategoryQuery().selectCategory(new Category(categoryId));

        request.setAttribute("products", products);
        request.setAttribute("totalProducts", products.size());
        request.setAttribute("category", category);
        String editCategoryJSP = "/WEB-INF/pagesInfo/categoryUtils/editCategory.jsp";
        request.getRequestDispatcher(editCategoryJSP).forward(request, response);
    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        String categoryName = request.getParameter("categoryName");
        String descriptionCategory = request.getParameter("description");
        String description = null;
        if (descriptionCategory.isEmpty() || descriptionCategory == null) {
            description = null;
        } else {
            description = descriptionCategory;
        }
        byte states = Byte.parseByte(request.getParameter("states"));
        short subCategory = Short.parseShort(request.getParameter("subCategory"));
        Category category = new Category(categoryName, description, states, subCategory);
        int rowAffected = new CategoryQuery().insert(category);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro ingresar un registro de categoria, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Categoria ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("insert category  -->" + rowAffected);
        this.actionDefault(request, response);

    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        short categoryId = Short.parseShort(request.getParameter("categoryId"));
        String categoryName = request.getParameter("categoryName");
        String descriptionCategory = request.getParameter("description");
        String description = null;
        if (descriptionCategory.isEmpty() || descriptionCategory == null) {
            description = null;
        } else {
            description = descriptionCategory;
        }
        byte states = Byte.parseByte(request.getParameter("states"));
        short subCategory = Short.parseShort(request.getParameter("subCategory"));
        Category category = new Category(categoryId, categoryName, description, states, subCategory);
        int rowAffected = new CategoryQuery().update(category);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1 || rowAffected == 0) {
            message = "Se actualizo un registro de Categoria, filas afectadas 1";
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Categoria ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("update category  -->" + rowAffected);
        this.actionDefault(request, response);

    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        short categoryId = Short.parseShort(request.getParameter("categoryId"));
        Category category = new Category(categoryId);
        int rowAffected = new CategoryQuery().delete(category);

        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro eliminar un registro de categoria, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Categoria ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete catgory  -->" + rowAffected);

        this.actionDefault(request, response);
    }
}
