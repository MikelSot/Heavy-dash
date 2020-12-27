
package Domain;


public class Order {
    
    private int orderId;
    private byte states;
    private String orderDate;
    private String shippingDate;
    private String orderAdderss;
    private String lot;
    private String reference;
    private String dni;
    private String name;
    private String lastName;
    private byte typeAddress;
    private short districtId;
    private String employeeId; // cambiar a String
    private String shippingComanyId; // ambiar a String
    private int userId;
    private short quantity; // para saber la cantidad de pedidos por productos(solo eso)

    public Order() {
    }

    public Order(int orderId, byte states, String orderDate, String shippingDate, String orderAdderss, String lot, String reference, String dni, String name, String lastName, byte typeAddress, short districtId, String employeeId, String shippingComanyId, int userId) {
        this.orderId = orderId;
        this.states = states;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.orderAdderss = orderAdderss;
        this.lot = lot;
        this.reference = reference;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.typeAddress = typeAddress;
        this.districtId = districtId;
        this.employeeId = employeeId;
        this.shippingComanyId = shippingComanyId;
        this.userId = userId;
    }

    public Order(byte states, String orderDate, String shippingDate, String orderAdderss, String lot, String reference, String dni, String name, String lastName, byte typeAddress, short districtId, String employeeId, String shippingComanyId, int userId) {
        this.states = states;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.orderAdderss = orderAdderss;
        this.lot = lot;
        this.reference = reference;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.typeAddress = typeAddress;
        this.districtId = districtId;
        this.employeeId = employeeId;
        this.shippingComanyId = shippingComanyId;
        this.userId = userId;
    }

    public Order(int orderId) {
        this.orderId = orderId;
    }

    // consultar cantidad de pedidos por producto 
    public Order(int orderId, byte states, String orderDate, short districtId, String employeeId, String shippingComanyId, int userId, short quantity) {
        this.orderId = orderId;
        this.states = states;
        this.orderDate = orderDate;
        this.districtId = districtId;
        this.employeeId = employeeId;
        this.shippingComanyId = shippingComanyId;
        this.userId = userId;
        this.quantity = quantity;
    }
    
    /**/

    public Order(int orderId, byte states, String orderDate, String shippingDate, int userId) {
        this.orderId = orderId;
        this.states = states;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.userId = userId;
    }
    
    
    
    
    public int getOrderId() {
        return orderId;
    }
    
    // setter y getter de quantity
    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {    
        this.quantity = quantity;
    }
    ////
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public byte getStates() {
        return states;
    }

    public void setStates(byte states) {
        this.states = states;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getOrderAdderss() {
        return orderAdderss;
    }

    public void setOrderAdderss(String orderAdderss) {
        this.orderAdderss = orderAdderss;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getTypeAddress() {
        return typeAddress;
    }

    public void setTypeAddress(byte typeAddress) {
        this.typeAddress = typeAddress;
    }

    public short getDistrictId() {
        return districtId;
    }

    public void setDistrictId(short districtId) {
        this.districtId = districtId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getShippingComanyId() {
        return shippingComanyId;
    }

    public void setShippingComanyId(String shippingComanyId) {
        this.shippingComanyId = shippingComanyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", states=" + states + ", orderDate=" + orderDate + ", shippingDate=" + shippingDate + ", orderAdderss=" + orderAdderss + ", lot=" + lot + ", reference=" + reference + ", dni=" + dni + ", name=" + name + ", lastName=" + lastName + ", typeAddress=" + typeAddress + ", districtId=" + districtId + ", employeeId=" + employeeId + ", shippingComanyId=" + shippingComanyId + ", userId=" + userId + '}';
    }

    
    
}
