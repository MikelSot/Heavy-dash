
package optional;

public class Employee_workDay {
    
    private String names;
    private short employeeID;
    private byte workDayID;
            
    public Employee_workDay() {
    }
    
    
    public Employee_workDay(String names) {
        this.names = names;
    }

    public Employee_workDay(short employeeID, byte workDayID) {
        this.employeeID = employeeID;
        this.workDayID = workDayID;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public short getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(short employeeID) {
        this.employeeID = employeeID;
    }

    public byte getWorkDayID() {
        return workDayID;
    }

    public void setWorkDayID(byte workDayID) {
        this.workDayID = workDayID;
    }

    @Override
    public String toString() {
        return "Employee_workDay{" + "names=" + names + ", employeeID=" + employeeID + ", workDayID=" + workDayID + '}';
    }

    

    
   
    
    
    
    
    
    
}
