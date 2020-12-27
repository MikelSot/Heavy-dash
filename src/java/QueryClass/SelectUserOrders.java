
package QueryClass;


public class SelectUserOrders {
    
    private int orderId;
    private byte states;
    private String orderDate;
    private String shippingDate;
    private String orderAdderss;
    private String dni;
    private String lastName;
    private String typeAddress;
    private short districtId;
    private String district;
    private String employeeId; // cambiar a String
    private String shippingComanyId; // ambiar a String
    private int orderDetailId;
    private String product;
    private int productId;
    private short quantity;
    private String email;    
    private String position;
    private String boss;  // jefe
    private String companyName;
    private String contactName;
    private byte active;

    
    /**/
    public SelectUserOrders(int orderId, byte states, String lastName, String employeeId, String email, String position, String boss) {
        this.orderId = orderId;
        this.states = states;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.email = email;
        this.position = position;
        this.boss = boss;
    }

    /**/

    public SelectUserOrders(int orderId, byte states, String shippingComanyId, String email, String companyName, String contactName, byte active) {
        this.orderId = orderId;
        this.states = states;
        this.shippingComanyId = shippingComanyId;
        this.email = email;
        this.companyName = companyName;
        this.contactName = contactName;
        this.active = active;
    }
            
    
    
    public SelectUserOrders(int orderId, int orderDetailId, String product, int productId, short quantity) {
        this.orderId = orderId;
        this.orderDetailId = orderDetailId;
        this.product = product;
        this.productId = productId;
        this.quantity = quantity;
    }
    
    public SelectUserOrders() {
    }

    public SelectUserOrders(int orderId, byte states, String orderDate, String shippingDate, String orderAdderss, String dni, String lastName, String typeAddress, short districtId, String district, String employeeId, String shippingComanyId) {
        this.orderId = orderId;
        this.states = states;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.orderAdderss = orderAdderss;
        this.dni = dni;
        this.lastName = lastName;
        this.typeAddress = typeAddress;
        this.districtId = districtId;
        this.district = district;
        this.employeeId = employeeId;
        this.shippingComanyId = shippingComanyId;
    }

  

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getBoss() {
        return boss;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public byte getActive() {
        return active;
    }
    
    

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public String getProduct() {
        return product;
    }

    public int getProductId() {
        return productId;
    }

    public short getQuantity() {
        return quantity;
    }

    
    public int getOrderId() {
        return orderId;
    }

    public byte getStates() {
        return states;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public String getOrderAdderss() {
        return orderAdderss;
    }

    public String getDni() {
        return dni;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTypeAddress() {
        return typeAddress;
    }

    public short getDistrictId() {
        return districtId;
    }

    public String getDistrict() {
        return district;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getShippingComanyId() {
        return shippingComanyId;
    }

    @Override
    public String toString() {
        return "SelectUserOrders{" + "orderId=" + orderId + ", states=" + states + ", orderDate=" + orderDate + ", shippingDate=" + shippingDate + ", orderAdderss=" + orderAdderss + ", dni=" + dni + ", lastName=" + lastName + ", typeAddress=" + typeAddress + ", districtId=" + districtId + ", district=" + district + ", employeeId=" + employeeId + ", shippingComanyId=" + shippingComanyId + ", orderDetailId=" + orderDetailId + ", product=" + product + ", productId=" + productId + ", quantity=" + quantity + '}';
    }
    
    
    
    
}
