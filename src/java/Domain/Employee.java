package Domain;


public class Employee {
    
    private int employeeId;
    private String firstName;
    private String lastName;
    private String dni;
    private String birthDate;
    private String email;    
    private double salary;
    private String employeeAddress;
    private String postalCode;
    private String employeeHours;
    private String turn;
    private String educationLevel;      
    private String profession;
    private String position;
    private String sex;
    private String states;
    private String boss;  // jefe
    private int districtID;
    private String district;
    private String bossLastName;
    
    
    
    public Employee(){
        
    }

    public Employee(int employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(int employeeId, String firstName, String lastName, String dni, String birthDate, String email, double salary, String employeeAddress, String postalCode, String employeeHours, String turn, String educationLevel, String profession, String position, String sex, String states, String boss, int districtID) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.birthDate = birthDate;
        this.email = email;
        this.salary = salary;
        this.employeeAddress = employeeAddress;
        this.postalCode = postalCode;
        this.employeeHours = employeeHours;
        this.turn = turn;
        this.educationLevel = educationLevel;
        this.profession = profession;
        this.position = position;
        this.sex = sex;
        this.states = states;
        this.boss = boss;
        this.districtID = districtID;
    }

    public Employee(String firstName, String lastName, String dni, String birthDate, String email, double salary, String employeeAddress, String postalCode, String employeeHours, String turn, String educationLevel, String profession, String position, String sex, String states, String boss, int districtID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.birthDate = birthDate;
        this.email = email;
        this.salary = salary;
        this.employeeAddress = employeeAddress;
        this.postalCode = postalCode;
        this.employeeHours = employeeHours;
        this.turn = turn;
        this.educationLevel = educationLevel;
        this.profession = profession;
        this.position = position;
        this.sex = sex;
        this.states = states;
        this.boss = boss;
        this.districtID = districtID;
    }

    public Employee(int employeeId, String boss) {
        this.employeeId = employeeId;
        this.boss = boss;
    }

    public Employee(int employeeId, String firstName, String lastName, String dni, String email, String employeeHours, String turn, String position, String states, String boss, String district, String bossLastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.employeeHours = employeeHours;
        this.turn = turn;
        this.position = position;
        this.states = states;
        this.boss = boss;
        this.district = district;
        this.bossLastName = bossLastName;
    }

    public String getBossLastName() {
        return bossLastName;
    }

    
    
    public String getDistrict() {
        return district;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmployeeHours() {
        return employeeHours;
    }

    public void setEmployeeHours(String employeeHours) {
        this.employeeHours = employeeHours;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", dni=" + dni + ", birthDate=" + birthDate + ", email=" + email + ", salary=" + salary + ", employeeAddress=" + employeeAddress + ", postalCode=" + postalCode + ", employeeHours=" + employeeHours + ", turn=" + turn + ", educationLevel=" + educationLevel + ", profession=" + profession + ", position=" + position + ", sex=" + sex + ", states=" + states + ", boss=" + boss + ", districtID=" + districtID + ", district=" + district + ", bossLastName=" + bossLastName + '}';
    }

    
    


}