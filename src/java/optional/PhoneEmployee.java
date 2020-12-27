
package optional;


public class PhoneEmployee {
    private short phoneEmployeeID;
    private String phonesEmployee ;
    private int employeeID;

    public PhoneEmployee() {
    }

    public PhoneEmployee(short phoneEmployeeID) {
        this.phoneEmployeeID = phoneEmployeeID;
    }

    public PhoneEmployee(String phonesEmployee) {
        this.phonesEmployee = phonesEmployee;
    }

    public PhoneEmployee(String phonesEmployee, int employeeID) {
        this.phonesEmployee = phonesEmployee;
        this.employeeID = employeeID;
    }

    public short getPhoneEmployeeID() {
        return phoneEmployeeID;
    }

    public void setPhoneEmployeeID(short phoneEmployeeID) {
        this.phoneEmployeeID = phoneEmployeeID;
    }

    public String getPhonesEmployee() {
        return phonesEmployee;
    }

    public void setPhonesEmployee(String phonesEmployee) {
        this.phonesEmployee = phonesEmployee;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "PhoneEmployee{" + "phoneEmployeeID=" + phoneEmployeeID + ", phonesEmployee=" + phonesEmployee + ", employeeID=" + employeeID + '}';
    }

    
     
    
    
    
    
}
