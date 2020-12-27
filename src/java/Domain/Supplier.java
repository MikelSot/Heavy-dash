
package Domain;


public class Supplier {
    
    private short supplierId;
    private String nameCompany;
    private String contanctName;
    private byte states;
    private String supplierAddress;
    private String postalCode;
    private String city;
    private String country;
    private String email;
    private String typeGoods;

    
    public Supplier(){
        
    }

    public Supplier(short supplierId, String nameCompany, String contanctName, byte states, String supplierAddress, String postalCode, String city, String country, String email, String typeGoods) {
        this.supplierId = supplierId;
        this.nameCompany = nameCompany;
        this.contanctName = contanctName;
        this.states = states;
        this.supplierAddress = supplierAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.typeGoods = typeGoods;
    }

    public Supplier(String nameCompany, String contanctName, byte states, String supplierAddress, String postalCode, String city, String country, String email, String typeGoods) {
        this.nameCompany = nameCompany;
        this.contanctName = contanctName;
        this.states = states;
        this.supplierAddress = supplierAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.typeGoods = typeGoods;
    }

    public Supplier(short supplierId) {
        this.supplierId = supplierId;
    }

    public short getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(short supplierId) {
        this.supplierId = supplierId;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getContanctName() {
        return contanctName;
    }

    public void setContanctName(String contanctName) {
        this.contanctName = contanctName;
    }

    public byte getStates() {
        return states;
    }

    public void setStates(byte states) {
        this.states = states;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeGoods() {
        return typeGoods;
    }

    public void setTypeGoods(String typeGoods) {
        this.typeGoods = typeGoods;
    }

    @Override
    public String toString() {
        return "Supplier{" + "suppplierId=" + supplierId + ", nameCompany=" + nameCompany + ", contanctName=" + contanctName + ", states=" + states + ", supplierAddress=" + supplierAddress + ", postalCode=" + postalCode + ", city=" + city + ", country=" + country + ", email=" + email + ", typeGoods=" + typeGoods + '}';
    }

   
   
    
}
