
package Domain;


public class Category {
    
    private short categoryId;
    private String categoryName;
    private String description;
    private byte states;
    private short subCategory;
    
    public Category(){
        
    }

    public Category(short categoryId, String categoryName, String description, byte states, short subCategory) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.states = states;
        this.subCategory = subCategory;
    }

    public Category(String categoryName, String description, byte states, short subCategory) {
        this.categoryName = categoryName;
        this.description = description;
        this.states = states;
        this.subCategory = subCategory;
    }

    public Category(short categoryId) {
        this.categoryId = categoryId;
    }

    public Category(short categoryId, String categoryName, String description, byte states) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.states = states;
    }

    public Category(short categoryId, String categoryName, byte states) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.states = states;
    }                

    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getStates() {
        return states;
    }

    public void setStates(byte states) {
        this.states = states;
    }

    public short getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(short subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description + ", states=" + states + ", subCategory=" + subCategory + '}';
    }
    
    
    
    
    
}
