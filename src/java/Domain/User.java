
package Domain;


public class User {
    
    private int userId;
    private String userName;
    private String nickName;
    private String email;
    private String userPassword;
    private byte active;
    private short roleId;

    public User() {
    }

    public User(int userId, String userName, String nickName, String email, String userPassword, byte active, short roleId) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.userPassword = userPassword;
        this.active = active;
        this.roleId = roleId;
    }

    public User(String userName, String nickName, String email, String userPassword, byte active, short roleId) {
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.userPassword = userPassword;
        this.active = active;
        this.roleId = roleId;
    }

    public User(int userId, String userName, String email, byte active, short roleId) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.active = active;
        this.roleId = roleId;
    }

    public User(int userId, String userName, String nickName, String email, byte active, short roleId) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.active = active;
        this.roleId = roleId;
    }

    
    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public short getRoleId() {
        return roleId;
    }

    public void setRoleId(short roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", email=" + email + ", userPassword=" + userPassword + ", active=" + active + ", roleId=" + roleId + '}';
    }

    
    
    
}
