
package Domain;


public class OrderSupplier {
    
    private int orderSupplierId;
    private String orderName;
    private double unitPrice;
    private short quantity;
    private String orderDescription;
    private byte states;
    private String orderDate;
    private String shippedDate;
    private String shippingCompany;
    private double priceShipping;
    private short supplierId;
    
    
    public OrderSupplier(){
        
    }

    public OrderSupplier(int orderSupplierId, String orderName, double unitPrice, short quantity, String orderDescription, byte states, String orderDate, String shippedDate, String shippingCompany, double priceShipping, short supplierId) {
        this.orderSupplierId = orderSupplierId;
        this.orderName = orderName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.orderDescription = orderDescription;
        this.states = states;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.shippingCompany = shippingCompany;
        this.priceShipping = priceShipping;
        this.supplierId = supplierId;
    }

    public OrderSupplier(String orderName, double unitPrice, short quantity, String orderDescription, byte states, String orderDate, String shippedDate, String shippingCompany, double priceShipping, short supplierId) {
        this.orderName = orderName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.orderDescription = orderDescription;
        this.states = states;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.shippingCompany = shippingCompany;
        this.priceShipping = priceShipping;
        this.supplierId = supplierId;
    }

    public OrderSupplier(int orderSupplierId) {
        this.orderSupplierId = orderSupplierId;
    }

    public int getOrderSupplierId() {
        return orderSupplierId;
    }

    public void setOrderSupplierId(int orderSupplierId) {
        this.orderSupplierId = orderSupplierId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
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

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public double getPriceShipping() {
        return priceShipping;
    }

    public void setPriceShipping(double priceShipping) {
        this.priceShipping = priceShipping;
    }

    public short getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(short supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "OrderSupplier{" + "orderSupplierId=" + orderSupplierId + ", orderName=" + orderName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", orderDescription=" + orderDescription + ", states=" + states + ", orderDate=" + orderDate + ", shippedDate=" + shippedDate + ", shippingCompany=" + shippingCompany + ", priceShipping=" + priceShipping + ", supplierId=" + supplierId + '}';
    }

  
    
    
    
}
