
package Domain;




public class Payment {
    
    private int paymentId;
    private String paymentDate;
    private int userId;
    private int orderDetailId;
    private String invoiceId; // ponerle String

    public Payment() {
    }

    public Payment(int paymentId, String paymentDate, int userId, int orderDetailId, String invoiceId) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.userId = userId;
        this.orderDetailId = orderDetailId;
        this.invoiceId = invoiceId;
    }

    public Payment(String paymentDate, int userId, int orderDetailId, String invoiceId) {
        this.paymentDate = paymentDate;
        this.userId = userId;
        this.orderDetailId = orderDetailId;
        this.invoiceId = invoiceId;
    }

    public Payment(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", userId=" + userId + ", orderDetailId=" + orderDetailId + ", invoiceId=" + invoiceId + '}';
    }

   
   
    
}
