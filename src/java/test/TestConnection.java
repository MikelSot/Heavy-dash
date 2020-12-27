package test;

import Data_Base.*;
import Domain.*;
import java.sql.Date;
import Data_Base.optional_Query.*;
import QueryClass.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import optional.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException, Exception {
        /*
        List<Employee> employees = new EmployeeQuery().select();

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }

        Employee employee = new EmployeeQuery().selectEmployee(new Employee(4));
        
        System.out.println(employee);


        
        List<User> users = new UserQuery().select();
        
        
        for(User user: users){
            System.out.println(user.toString());
        }
        
 
        User user = new UserQuery().selectUser(new User(4));
        
        System.out.println(user);
        
        ENCRYPTBYPASSPHRASE('password', ?)
     
       
        User sgs = new User("Soto", "Renojo", "soto@renojo",  "soto", (byte)0,(short) 3);
        
        // insertar en la BD , el int es para saber si cuantas filas se han afectado        
        int rowAffected = new UserQuery().insert(sgs);
        
        System.out.println("row -->" + rowAffected);
        List<User> users = new UserQuery().select();
        
        
        for(User user: users){
            System.out.println(user.toString());
        }
        
        List<Product> products = new ProductQuery().select();
        
        System.err.println("/n");
        for(Product product: products){
            System.out.println(product.toString());
        }

  
        Employee employee = new Employee(6);
        List<Employee_workDay> employee_workDays = new Employee_WorkDayQuery().select(employee);

        for (Employee_workDay employee_workDay : employee_workDays) {
            System.out.println(employee_workDay.toString());
        }
    
    
        Product product = new Product(3);
        List<Product_Include> product_Includes = new Product_IncludeQuery().select(product);
    
        for(Product_Include product_include: product_Includes){
            System.out.println(product_include.toString());
        }
    
        
        List<OrderDetail> orderDetails = new OrderDetailsQuery().select();
        
        for(OrderDetail orderDetail: orderDetails){
            System.out.println(orderDetail.toString());
        }
    
        OrderDetail orderDetail = new OrderDetailsQuery().selectOrderDetail(new OrderDetail(1, 1));
        
        System.out.println(orderDetail);

        Employee employee = new Employee(1);
        List<PhoneEmployee> phoneEmployees = new Employee_WorkDayQuery().selectPhoneEmployee(employee);
        
        for(PhoneEmployee phoneEmployee: phoneEmployees){
            System.out.println(phoneEmployee);
        }
        
        System.out.println(phoneEmployees.get(0));
        
        for(PhoneEmployee phoneEmployee: phoneEmployees){
            System.out.println(phoneEmployee.pho);
        }

        int employeeId = Integer.parseInt("1");                   
        Employee employee = new EmployeeQuery().selectEmployee(new Employee(employeeId));
        
        List<Employee_workDay> employee_workDays = new Employee_WorkDayQuery().selectWorkDay(employee);
        List<PhoneEmployee> phoneEmployees = new Employee_WorkDayQuery().selectPhoneEmployee(employee);

        
        for(Employee_workDay employee_workDay: employee_workDays){
            System.out.println(employee_workDay);
        }
        
        for(PhoneEmployee phoneEmployee: phoneEmployees){
            System.out.println(phoneEmployee);
        }



      
        
        
       Employee employee = new Employee(1);
        String districEmployee = new Employee_WorkDayQuery().selectDistrictEmployee(employee);
        District district = new District((short)120);
        String provinceEmployee = new Employee_WorkDayQuery().selectProvinceEmployee(district);   
        System.out.println(provinceEmployee);
        System.out.println(districEmployee);

    
    
        
       List<Product> products = new ProductQuery().select();
        
        for(Product product: products){
            System.out.println(product.toString());
        }


        String comer = "";
        String name = null ;
        if(comer.isEmpty() || comer == null){
             name= null;
        System.out.println("es nulo o vacio" );
        }
        
        System.out.println("->"+name);

        List<Supplier> suppliers = new SupplierQuery().select();
        
        for(Supplier supplier: suppliers){
            System.out.println(supplier);
        }


    List<OrderSupplier> orderSuppliers = new OrderSupplierQuery().select();
    for(OrderSupplier orderSupplier: orderSuppliers){
        System.out.println(orderSupplier);
    }
  
        
        
        List<Order> orders = new OrderQuery().select();
        for(Order order:orders){
            System.out.println(order);
        }
       
        
        
        List<OrderDetail> orderDetails = new OrderDetailsQuery().select();
        
        for(OrderDetail orderDetail: orderDetails){
            System.out.println(orderDetail);
        }


        List<ShippingCompany> shippingCompanys = new ShippingCompanyQuery().select();
        for(ShippingCompany shippingCompany: shippingCompanys){
            System.out.println(shippingCompany);
        }


        
        List<Payment> payments =  new PaymentQuery().select();
    
        for(Payment payment: payments){
            System.out.println(payment);
        }

        
        ShippingCompany shippingCompany = new ShippingCompanyQuery().selectShippingCompany(new ShippingCompany((short)1));
        
        
        System.out.println(shippingCompany);


        Employee_workDay employee_workDay = new Employee_workDay((short)11, (byte)1)  ;
        
        int row = new Employee_WorkDayQuery().insertWorkdayEmployee(employee_workDay);
        
        System.out.println(row);
        
        System.out.println();

        PhoneEmployee employee = new PhoneEmployee("949982694",11);
        
        int row = new Employee_WorkDayQuery().inserPhoneEmployee(employee);
        System.out.println(row);
        
        
        
         List<District> districtdos = new DistrictQuery().selectDistrict();

        for(District district: districtdos){
            System.out.println(district);
        }

        
        List<District> districts = new DistrictQuery().selectDistrictProvince();
        
        for(District district: districts){
            System.out.println(district.toString());
        }
        
        System.out.println();
        System.out.println();
        System.out.println();

        List<SelectChippingEmployee> selectChippingEmployees =  new EmployeeQuery().selectShippingEmployee();
        
        for(SelectChippingEmployee selectChippingEmployee: selectChippingEmployees){
            System.out.println(selectChippingEmployee);
        }
        
        SelectChippingEmployee selectChippingEmployee = new SelectChippingEmployee((short)10);
        List<SelectChippingEmployee> selectChippingEmployees = new EmployeeQuery().selectShippingEmployeeID(selectChippingEmployee);
        for(SelectChippingEmployee selectChippingEmployee1: selectChippingEmployees){
            System.out.println(selectChippingEmployee1);
        }


        List<OrderDetail> orderDetails = new OrderDetailsQuery().select();
        for(OrderDetail orderDetail:orderDetails){
            System.out.println(orderDetail);
        }
    


        List<Payment> payments = new PaymentQuery().select();
        
        for(Payment payment: payments){
            System.out.println(payment);
        }

        List<Invoice> invoices = new InvoiceQuery().select();
        
        for(Invoice invoice: invoices){
            System.out.println(invoice);
        }


        
        
        List<Agency> agencys = new AgencyQuery().select();
        
        for(Agency agency: agencys){
            System.out.println(agency);
        }
        
        
       List<Agency> agencys= new AgencyQuery().selectAgency(new Agency((short)1));
        
        for(Agency agency1: agencys){
            System.out.println(agency1);
        }

       List<Category> categorys = new CategoryQuery().selectCategoryThirdLevel();
       List<Category> categorysPrincipal = new CategoryQuery().selectCategoryPrincipal();
       List<Category> categorysSeubcategory = new CategoryQuery().selectCategorySubcategory();
       
       
      
               
        
        
        List<Product> products = new CategoryQuery().selectProductByCategory(new Category((short)12));
        
        for (Product product : products) {
            System.out.println(product);
        }


        List<Includes> includeses = new ProductQuery().selectIncludeProduct(new Product(2));
        
        for(Includes includes: includeses){
            System.out.println(includes);
        }

        List<Category> categorys = new ProductQuery().selectProductByCategory(new Product(3, (short)12));
        
        for(Category category:categorys){
            System.out.println(category);
        }

        
        List<String> stringsQuantity = new ProductQuery().selectQuantityOrderByProduct(new Product(5));
        
            System.out.println(stringsQuantity.get(0));
         
        List<User> userIds = new UserQuery().selectUserId();
        
        List<Supplier> suppliersId = new SupplierQuery().selectSupplierId();
        List<ShippingCompany> shippingCompanysId = new ShippingCompanyQuery().selectShippingCompanyId();
        List<Product> productsId = new ProductQuery().selectProductId();
        List<Order> ordersId = new OrderQuery().selectOrderId();
        List<OrderDetail> orderDetailsId = new OrderDetailsQuery().selectOrderDetailsId();
        List<Category> categorysId = new CategoryQuery().selectCategoryId();
        List<Employee> employeesId = new EmployeeQuery().selectEmployeeId();
        List<Invoice> invoicesId = new InvoiceQuery().selectInvoiceId();
        
        List<Invoice> invoices = new InvoiceQuery().select();
        
        Invoice invoiceById = new InvoiceQuery().selectInvoiceById(new Invoice(02));
        
        System.out.println(invoiceById);
         

        User user = new PaymentQuery().selectPaymentUserById(new User(2), new Payment(44));
        List<SelectUserPayments> selectUserPayments = new PaymentQuery().selectUserpayments(new User(2), new Payment(44));
        SelectUserPayments selectOrderDetailsProductoPaymentID = new PaymentQuery().selectOrderDetailsProductoPaymentId(new Payment(44), new OrderDetail(75));
        SelectUserPayments selectOrderPaymentID = new PaymentQuery().selectOrderPaymentId(new Payment(44), new OrderDetail(75));
        List<SelectUserPayments> selectProductPaymentses = new PaymentQuery().selectProductPayments(new OrderDetail(75));
        List<SelectUserPayments> selectInvoicesPaymentses = new PaymentQuery().selectInvoicesPayments(new Invoice(1));


        //System.out.println(user);
        System.out.println(selectOrderDetailsProductoPaymentID.getCategoryId());
        
        
        List<TypeAddress> typeAddresses = new TypeAddressQuery().select();
        
        for(TypeAddress typeAddress: typeAddresses){
            System.out.println(typeAddress);
        }
        
        User selectOrdersUser = new OrderQuery().selectOrdersUserId(new User(28), new Order(1));
        District selectOrdersDistrict = new OrderQuery().selectOrdersDistricId(new District((short) 30), new Order(1));
        TypeAddress selectOrdersTypeAddress = new OrderQuery().selectOrdersTypeAddressID(new TypeAddress((byte)1), new Order(1));
        ShippingCompany selectOrdersShippingCompany = new OrderQuery().selectOrdersShippingCompanyID(new ShippingCompany((short)7) , new Order(1));
        Employee selectOrdersEmployee= new OrderQuery().selectOrdersEmployeeID(new Employee(1), new Order(44));
        System.out.println(selectOrdersEmployee);

        String role = new UserQuery().selectUserRole(new User(7));
        List<SelectUserOrders> selectUserOrders = new UserQuery().selectUserOrders(new User(7));
        List<Payment> selectUserPayment = new UserQuery().selectUserPayment(new User(7));
        List<SelectUserOrders> selectUserOrderDetails = new UserQuery().selectUserOrderDetails(new User(7));
       
        List<Role> roles = new RoleQuery().select();
        
        for (Role role: roles){
            System.out.println(role);
        }
         
        List<SelectUserOrders> vwOrderShippings = new OrderQuery().selectvwOrderShipping();
        List<SelectUserOrders> vwOrderEmployees = new OrderQuery().selectvwOrderEmployee();
        
        
        List<SelectUserPayments> vwShippingCompanyOrders = new ShippingCompanyQuery().selectvwShippingCompanyOrders();

        List<Order> selectOrderDetailsOrders = new OrderDetailsQuery().selectOrderDetailsOrders();
        List<Product> selectOrderDetailsProduct = new OrderDetailsQuery().selectOrderDetailsProduct();
        
        for (Product product: selectOrderDetailsProduct) {
            System.out.println(product);
        }
*/
        User selectOrderDetailIdUserId = new OrderDetailsQuery().selectOrderDetailIdUserId(new OrderDetail(18));
        SelectUserOrders selectOrderDetailIdOrders = new OrderDetailsQuery().selectOrderDetailIdOrders(new OrderDetail(18));
        Product selectOrderDetailIdProduct = new OrderDetailsQuery().selectOrderDetailIdProduct(new OrderDetail(18));
        System.out.println(selectOrderDetailIdProduct);
    }

}
