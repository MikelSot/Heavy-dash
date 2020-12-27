
package QueryClass;


public class SelectChippingEmployee {
    
    private short orderID;
    private short employeeID;
    private String employeeName;
    private String employeeLastName;
    private String productName;
    private short productID;

    public SelectChippingEmployee() {
    }

    public SelectChippingEmployee(short orderID, short employeeID, String employeeName, String employeeLastName, String productName, short productID) {
        this.orderID = orderID;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeLastName = employeeLastName;
        this.productName = productName;
        this.productID = productID;
    }
    

    public SelectChippingEmployee(short employeeID) {
        this.employeeID = employeeID;
    }

    public short getOrderID() {
        return orderID;
    }

    public void setOrderID(short orderID) {
        this.orderID = orderID;
    }

    public short getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(short employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public short getProductID() {
        return productID;
    }

    public void setProductID(short productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "SelectChippingEmployee{" + "orderID=" + orderID + ", employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeLastName=" + employeeLastName + ", productName=" + productName + ", productID=" + productID + '}';
    }
    
    
    
}
