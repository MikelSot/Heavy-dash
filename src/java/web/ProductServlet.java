package web;

import Data_Base.*;
import Data_Base.optional_Query.DistrictQuery;
import Domain.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import optional.District;
import optional.Includes;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {

                case "edit": {
                    try {
                        this.editProduct(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "delete": {
                    try {
                        this.deleteProduct(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                        this.insertProducto(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "update": {
                    try {
                        this.updateProduct(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void actionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            List<Product> products = new ProductQuery().select();
            List<OrderSupplier> orderSuppliers = new OrderSupplierQuery().select();
            List<Order> orders = new OrderQuery().select();
            List<Supplier> suppliersId = new SupplierQuery().selectSupplierId();
            List<Category> categorysId = new CategoryQuery().selectCategoryId();

            session.setAttribute("categoriesId", categorysId);
            session.setAttribute("suppliersId", suppliersId);
            session.setAttribute("totalStock", this.totalStock(products));
            session.setAttribute("totalOrders", orders.size());
            session.setAttribute("toatlOrderSupplier", orderSuppliers.size());
            session.setAttribute("totalProducts", products.size());
            session.setAttribute("products", products);
            response.sendRedirect("product.jsp");
            System.out.println("products --> " + products);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        short categoryId = Short.parseShort(request.getParameter("categoryId"));
        Product product = new ProductQuery().selectProduct(new Product(productId));
        List<Includes> includeses = new ProductQuery().selectIncludeProduct(new Product(2));
        List<Category> categoryss = new ProductQuery().selectProductByCategory(new Product(productId, categoryId));
        List<Order> ordersByProduct = new ProductQuery().selectQuantityOrderByProduct(new Product(productId));
        List<District> districtsProvice = new DistrictQuery().selectDistrictProvince();

        request.setAttribute("districtProvince", districtsProvice);
        request.setAttribute("totalQuantityEemanded", this.totalQuantityDemanded(ordersByProduct));
        request.setAttribute("ordersByProduct", ordersByProduct);
        request.setAttribute("totalOrdersByProduct", ordersByProduct.size());
        request.setAttribute("categoryProduct", categoryss);
        request.setAttribute("include", includeses);
        request.setAttribute("totalInclude", includeses.size());
        request.setAttribute("product", product);
        String editProductJSP = "/WEB-INF/pagesInfo/productUtils/editProduct.jsp";
        request.getRequestDispatcher(editProductJSP).forward(request, response);
    }

    private void insertProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String nameProduct = request.getParameter("nameProduct");
        String sku = request.getParameter("sku");
        String measure = request.getParameter("measure");
        String ifMeasure = null;
        if (measure.isEmpty() || measure == null) {
            ifMeasure = null;
        } else {
            ifMeasure = measure;
        }
        byte states = Byte.parseByte(request.getParameter("states"));
        float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
        short stock = Short.parseShort(request.getParameter("stock"));
        short supplierId = Short.parseShort(request.getParameter("supplierId"));
        short categoryId = Short.parseShort(request.getParameter("categoryId"));

        Product product = new Product(nameProduct, sku, ifMeasure, states, unitPrice, stock, supplierId, categoryId);
        int rowAffected = new ProductQuery().insert(product);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro ingresar un registro de producto, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Producto->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("insert product -->" + rowAffected);

        this.actionDefault(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("productId"));
        String nameProduct = request.getParameter("nameProduct");
        String sku = request.getParameter("sku");
        String measure = request.getParameter("measure");
        String ifMeasure = null;
        if (measure.isEmpty() || measure == null) {
            ifMeasure = null;
        } else {
            ifMeasure = measure;
        }
        byte states = Byte.parseByte(request.getParameter("states"));
        float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
        short stock = Short.parseShort(request.getParameter("stock"));
        short supplierId = Short.parseShort(request.getParameter("supplierId"));
        short categoryId = Short.parseShort(request.getParameter("categoryId"));

        Product product = new Product(productId, nameProduct, sku, ifMeasure, states, unitPrice, stock, supplierId, categoryId);
        int rowAffected = new ProductQuery().update(product);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se actualizo un registro de producto, filas afectadas->" + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Producto->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("update product -->" + rowAffected);

        this.actionDefault(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = new Product(productId);
        int rowAffected = new ProductQuery().delete(product);
        String message = "";
        String icon = "";
        String button = "";

        if (rowAffected == 1) {
            message = "Se logro eliminar un registro de producto, filas afectadas " + rowAffected;
            button = "success";
            icon = "check";
        } else {
            message = "Ocurrió un problema, Tabla Producto ->" + rowAffected;
            button = "danger";
            icon = "times";
        }
        session.setAttribute("icon", icon);
        session.setAttribute("button", button);
        session.setAttribute("success", message);
        System.out.println("delete product  -->" + rowAffected);
        this.actionDefault(request, response);
    }

    private int totalStock(List<Product> products) {
        int stock = 0;
        for (Product product : products) {
            stock += product.getStock();
        }
        return stock;
    }

    private int totalQuantityDemanded(List<Order> orders) {
        int quantity = 0;
        for (Order order : orders) {
            quantity += order.getQuantity();
        }
        return quantity;
    }

}
