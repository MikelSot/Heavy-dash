
package Domain;


public class Product {
    
    
    private int productId;
    private String nameProduct;
    private String sku;
    private String measure;
    private byte states;
    private float unitPrice;
    private short stock;
    private short supplierId;
    private short categoryId;
    
    
    public Product(){
        
    }

    public Product(int productId, String nameProduct, String sku, String measure, byte states, float unitPrice, short stock, short supplierId, short categoryId) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.sku = sku;
        this.measure = measure;
        this.states = states;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
    }

    public Product(String nameProduct, String sku, String measure, byte states, float unitPrice, short stock, short supplierId, short categoryId) {
        this.nameProduct = nameProduct;
        this.sku = sku;
        this.measure = measure;
        this.states = states;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
    }

    public Product(int productId, String nameProduct, String sku, byte states, float unitPrice, short stock, short supplierId) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.sku = sku;
        this.states = states;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.supplierId = supplierId;
    }
        
    public Product(int productId) {
        this.productId = productId;
    }

    public Product(int productId, short categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }

    /**/
    public Product(int productId, String nameProduct, byte states, float unitPrice, short stock, short supplierId, short categoryId) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.states = states;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
    }
    
    
    

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public byte getStates() {
        return states;
    }

    public void setStates(byte states) {
        this.states = states;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public short getStock() {
        return stock;
    }

    public void setStock(short stock) {
        this.stock = stock;
    }

    public short getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(short supplierId) {
        this.supplierId = supplierId;
    }

    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", nameProduct=" + nameProduct + ", sku=" + sku + ", measure=" + measure + ", states=" + states + ", unitPrice=" + unitPrice + ", stock=" + stock + ", supplierId=" + supplierId + ", categoryId=" + categoryId + '}';
    }

    
    
}
