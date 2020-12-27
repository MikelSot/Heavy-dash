package QueryClass;

public class SelectUserPayments {

    private int paymentId;
    private int userId;
    private String userName;
    private int invoiceId;
    private int orderDetailId;
    private int orderId;
    private int productId;
    private short quantity;
    private short districtId;
    private String orderDate;
    private String nameProduct;
    private float unitPrice;
    private short stock;
    private float monto;
    private byte states;
    private short categoryId;
    private short supplierId;
    private String sku;
    private String dni;
    private String name;
    private String lastName;
    private byte typeAddress;
    private String shippingDate;
    private String employeeId; // cambiar a String
    private String shippingComanyId;
    

    public SelectUserPayments() {
    }
    
    /**/

    public SelectUserPayments(int userId, String userName, int orderId, String orderDate, byte states, String shippingDate, String shippingComanyId) {
        this.userId = userId;
        this.userName = userName;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.states = states;
        this.shippingDate = shippingDate;
        this.shippingComanyId = shippingComanyId;
    }
    
    

    
    public SelectUserPayments(int paymentId, int userId, String userName, int invoiceId, int orderDetailId, int orderId, int productId, short quantity, short districtId, String orderDate, String nameProduct, float unitPrice, short stock, float monto) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.userName = userName;
        this.invoiceId = invoiceId;
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.districtId = districtId;
        this.orderDate = orderDate;
        this.nameProduct = nameProduct;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.monto = monto;

    }

    public SelectUserPayments(int paymentId, int orderDetailId, int orderId, int productId, short quantity, String nameProduct, float unitPrice, short stock, byte states, short categoryId, short supplierId, String sku) {
        this.paymentId = paymentId;
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.nameProduct = nameProduct;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.states = states;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.sku = sku;
    }

    public SelectUserPayments(int paymentId, int orderId, short districtId, String orderDate, byte states, String dni, String name, String lastName, byte typeAddress, String shippingDate, String employeeId, String shippingComanyId) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.districtId = districtId;
        this.orderDate = orderDate;
        this.states = states;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.typeAddress = typeAddress;
        this.shippingDate = shippingDate;
        this.employeeId = employeeId;
        this.shippingComanyId = shippingComanyId;
    }

    public SelectUserPayments(int paymentId, int userId, String userName, int orderId, int productId, short quantity, String nameProduct, float unitPrice, byte states, short categoryId) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.userName = userName;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.nameProduct = nameProduct;
        this.unitPrice = unitPrice;
        this.states = states;
        this.categoryId = categoryId;
    }

    public SelectUserPayments(int paymentId, int userId, String userName, int orderDetailId, int orderId, int productId, short quantity, String nameProduct, float unitPrice, short stock, byte states, short categoryId) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.userName = userName;
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.nameProduct = nameProduct;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.states = states;
        this.categoryId = categoryId;
    }

    public SelectUserPayments(int paymentId, int userId, String userName, int invoiceId, int orderDetailId, int orderId, int productId, short quantity, String nameProduct, float unitPrice, short stock) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.userName = userName;
        this.invoiceId = invoiceId;
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.nameProduct = nameProduct;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public short getQuantity() {
        return quantity;
    }

    public short getDistrictId() {
        return districtId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public short getStock() {
        return stock;
    }

    public float getMonto() {
        return monto;
    }

    public byte getStates() {
        return states;
    }

    public short getCategoryId() {
        return categoryId;
    }

    public short getSupplierId() {
        return supplierId;
    }

    public String getSku() {
        return sku;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public byte getTypeAddress() {
        return typeAddress;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getShippingComanyId() {
        return shippingComanyId;
    }

    
    
    
    
    
    @Override
    public String toString() {
        return "SelectUserPayments{" + "paymentId=" + paymentId + ", userId=" + userId + ", userName=" + userName + ", invoiceId=" + invoiceId + ", orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", districtId=" + districtId + ", orderDate=" + orderDate + ", nameProduct=" + nameProduct + ", unitPrice=" + unitPrice + ", stock=" + stock + ", monto=" + monto + ", states=" + states + ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", sku=" + sku + ", dni=" + dni + ", name=" + name + ", lastName=" + lastName + ", typeAddress=" + typeAddress + ", shippingDate=" + shippingDate + ", employeeId=" + employeeId + ", shippingComanyId=" + shippingComanyId + '}';
    }

   

}
