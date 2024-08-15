package tms.entities;

public class UserMasterEO {
    private String username;
    private String password;
    private RoleMasterEO role;

    public UserMasterEO(){}

    public UserMasterEO(String username, String password, RoleMasterEO role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(RoleMasterEO role) {
        this.role = role;
    }

    public RoleMasterEO getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User Master [username='" + username + "', password='" + password + "', roleName='" + (role != null ? role.getRoleName() : "") + "']";
    }
}
