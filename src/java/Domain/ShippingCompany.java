package Domain;


public class ShippingCompany {
    
    private short shippingCompanyId;
    private String companyName;
    private String contactName;
    private byte active;
    private String companyAddres;
    private String postalCode;
    private String email;

    public ShippingCompany() {
    }

    public ShippingCompany(short shippingCompanyId, String companyName, String contactName, byte active, String companyAddres, String postalCode, String email) {
        this.shippingCompanyId = shippingCompanyId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.active = active;
        this.companyAddres = companyAddres;
        this.postalCode = postalCode;
        this.email = email;
    }

    public ShippingCompany(String companyName, String contactName, byte active, String companyAddres, String postalCode, String email) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.active = active;
        this.companyAddres = companyAddres;
        this.postalCode = postalCode;
        this.email = email;
    }

    public ShippingCompany(short shippingCompanyId) {
        this.shippingCompanyId = shippingCompanyId;
    }

    public short getShippingCompanyId() {
        return shippingCompanyId;
    }

    public void setShippingCompanyId(short shippingCompanyId) {
        this.shippingCompanyId = shippingCompanyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public String getCompanyAddres() {
        return companyAddres;
    }

    public void setCompanyAddres(String companyAddres) {
        this.companyAddres = companyAddres;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ShippingCompany{" + "shippingCompanyId=" + shippingCompanyId + ", companyName=" + companyName + ", contactName=" + contactName + ", active=" + active + ", companyAddres=" + companyAddres + ", postalCode=" + postalCode + ", email=" + email + '}';
    }
    
    
    
    
    
    
}
