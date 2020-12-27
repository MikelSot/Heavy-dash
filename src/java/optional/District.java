
package optional;


public class District {
    
    private short districtId;
    private String district;
    private String province;
    private short provinceId;
    
    
    public District (){
        
    }

    public District(short districtId, String district, short provinceId) {
        this.districtId = districtId;
        this.district = district;
        this.provinceId = provinceId;
    }

    public District(String district, short provinceId) {
        this.district = district;
        this.provinceId = provinceId;
    }

    public District(short districtId) {
        this.districtId = districtId;
    }

    public District(short districtId, String district, String province) {
        this.districtId = districtId;
        this.district = district;
        this.province = province;
    }    

    public District(String district, String province) {
        this.district = district;
        this.province = province;
    }
    
    
    
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
        

    public short getDistrictId() {
        return districtId;
    }

    public void setDistrictId(short districtId) {
        this.districtId = districtId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public short getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(short provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "District{" + "districtId=" + districtId + ", district=" + district + ", province=" + province + ", provinceId=" + provinceId + '}';
    }

   
    
    
    
}
