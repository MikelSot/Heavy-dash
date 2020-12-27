
package optional;


public class Role {
    
    private short roleId;
    private String roleName;
    private byte active;

    public Role() {
    }

    public Role(short roleId, String roleName, byte active) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.active = active;
    }

    public Role(String roleName, byte active) {
        this.roleName = roleName;
        this.active = active;
    }

    public Role(short roleId) {
        this.roleId = roleId;
    }

    public short getRoleId() {
        return roleId;
    }

    public void setRoleId(short roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Role{" + "roleId=" + roleId + ", roleName=" + roleName + ", active=" + active + '}';
    }
    
    
    
    
}
