
package Domain;

public class Invoice {
    
    private int invoiceId;
    private String ruc;
    private String direccion; // direccion domicilio fiscal
    private String razon;  // razon social

    public Invoice() {
    }

    public Invoice(int invoiceId, String ruc, String direccion, String razon) {
        this.invoiceId = invoiceId;
        this.ruc = ruc;
        this.direccion = direccion;
        this.razon = razon;
    }

    public Invoice(String ruc, String direccion, String razon) {
        this.ruc = ruc;
        this.direccion = direccion;
        this.razon = razon;
    }

    public Invoice(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    @Override
    public String toString() {
        return "Invoice{"  + invoiceId + "," + ruc + "," + direccion + "," + razon + '}';
    }
    
    
    
}
