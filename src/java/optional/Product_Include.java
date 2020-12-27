
package optional;


public class Product_Include {
    
    private String includeName;
    public Product_Include() {
    }

    public Product_Include(String includeName) {
        this.includeName = includeName;
    }
    

    public String getIncludeName() {
        return includeName;
    }

    public void setIncludeName(String includeName) {
        this.includeName = includeName;
    }

    @Override
    public String toString() {
        return "Product_Include{" + "includeName=" + includeName + '}';
    }

    
    
    
}
