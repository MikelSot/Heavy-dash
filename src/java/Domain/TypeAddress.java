
package Domain;

import java.io.Serializable;


public class TypeAddress{
    
   private byte typeAddressId;
   private String addressName;

    public TypeAddress() {
    }

    public TypeAddress(byte typeAddressId, String addressName) {
        this.typeAddressId = typeAddressId;
        this.addressName = addressName;
    }

    public TypeAddress(byte typeAddressId) {
        this.typeAddressId = typeAddressId;
    }

    public TypeAddress(String addressName) {
        this.addressName = addressName;
    }

    public byte getTypeAddressId() {
        return typeAddressId;
    }

    public void setTypeAddressId(byte typeAddressId) {
        this.typeAddressId = typeAddressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public String toString() {
        return "TypeAddress{" + "typeAddressId=" + typeAddressId + ", addressName=" + addressName + '}';
    }
   
   
   
    
}
