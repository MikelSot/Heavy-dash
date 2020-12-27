
package optional;


public class Province {
   
    private short provinceId;
    private String province;

    public Province() {
    }

    public Province(short provinceId, String province) {
        this.provinceId = provinceId;
        this.province = province;

    }



    public Province(short provinceId) {
        this.provinceId = provinceId;
    }

    public short getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(short provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Province{" + "provinceId=" + provinceId + ", province=" + province + '}';
    }



    
    
    
}
