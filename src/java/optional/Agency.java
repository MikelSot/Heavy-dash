
package optional;


public class Agency {
    
    private short agencyId;
    private String agencyAddess;
    private float normalPrice;
    private float expressPrice;
    private byte agencyDay;
    private short districtId;
    private short shippingCompanyId;

    public Agency() {
    }

    public Agency(short agencyId, String agencyAddess, float normalPrice, float expressPrice, byte agencyDay, short districtId, short shippingCompanyId) {
        this.agencyId = agencyId;
        this.agencyAddess = agencyAddess;
        this.normalPrice = normalPrice;
        this.expressPrice = expressPrice;
        this.agencyDay = agencyDay;
        this.districtId = districtId;
        this.shippingCompanyId = shippingCompanyId;
    }

    public Agency(String agencyAddess, float normalPrice, float expressPrice, byte agencyDay, short districtId, short shippingCompanyId) {
        this.agencyAddess = agencyAddess;
        this.normalPrice = normalPrice;
        this.expressPrice = expressPrice;
        this.agencyDay = agencyDay;
        this.districtId = districtId;
        this.shippingCompanyId = shippingCompanyId;
    }

    public Agency(short shippingCompanyId) {
        this.shippingCompanyId = shippingCompanyId;
    }

    

    public short getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(short agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyAddess() {
        return agencyAddess;
    }

    public void setAgencyAddess(String agencyAddess) {
        this.agencyAddess = agencyAddess;
    }

    public float getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(float normalPrice) {
        this.normalPrice = normalPrice;
    }

    public float getExpressPrice() {
        return expressPrice;
    }

    public void setExpressPrice(float expressPrice) {
        this.expressPrice = expressPrice;
    }

    public byte getAgencyDay() {
        return agencyDay;
    }

    public void setAgencyDay(byte agencyDay) {
        this.agencyDay = agencyDay;
    }

    public short getDistrictId() {
        return districtId;
    }

    public void setDistrictId(short districtId) {
        this.districtId = districtId;
    }

    public short getShippingCompanyId() {
        return shippingCompanyId;
    }

    public void setShippingCompanyId(short shippingCompanyId) {
        this.shippingCompanyId = shippingCompanyId;
    }

    @Override
    public String toString() {
        return "Agency{" + "agencyId=" + agencyId + ", agencyAddess=" + agencyAddess + ", normalPrice=" + normalPrice + ", expressPrice=" + expressPrice + ", agencyDay=" + agencyDay + ", districtId=" + districtId + ", shippingCompanyId=" + shippingCompanyId + '}';
    }
    
    
    
}
