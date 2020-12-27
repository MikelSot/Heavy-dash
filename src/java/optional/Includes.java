
package optional;


public class Includes {
    
    private short includeId;
    private String nameInclude;
    private byte active;

    public Includes() {
    }

    public Includes(short includeId, String nameInclude, byte active) {
        this.includeId = includeId;
        this.nameInclude = nameInclude;
        this.active = active;
    }

    public short getIncludeId() {
        return includeId;
    }

    public void setIncludeId(short includeId) {
        this.includeId = includeId;
    }

    public String getNameInclude() {
        return nameInclude;
    }

    public void setNameInclude(String nameInclude) {
        this.nameInclude = nameInclude;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "includes{" + "includeId=" + includeId + ", nameInclude=" + nameInclude + ", active=" + active + '}';
    }
    
    
}
