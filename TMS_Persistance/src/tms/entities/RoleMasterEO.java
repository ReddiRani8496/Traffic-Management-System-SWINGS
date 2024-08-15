package tms.entities;

public class RoleMasterEO {
    private String roleName;
    private String roleDesc;
    
    public RoleMasterEO(){}

    public RoleMasterEO(String roleName, String roleDesc) {
        super();
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleDesc() {
        return roleDesc;
    }


    @Override
    public String toString() {
        return "Role Master [ " + "roleName=" + roleName +  ", roleDescription=" + roleDesc + " ]";
    }
}
