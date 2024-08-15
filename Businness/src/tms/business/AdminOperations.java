package tms.business;

import java.util.List;

import tms.entities.RoleMasterEO;
import tms.entities.UserMasterEO;

public interface AdminOperations {
    
    // login
    public boolean login(UserMasterEO userEORef);
    
    //Users
    
    public Integer addNewUser(UserMasterEO userEORef);
    
    public Integer updateUser(UserMasterEO userEORef);
    
    public Integer deleteExisitingUser(String userName);
    
    public UserMasterEO findByUserName(String userName);
    
    public List<UserMasterEO> fetchAllUsers();
    
    // Roles
    
    public Integer addNewRole(RoleMasterEO roleEORef);
    
    public Integer updateRole(RoleMasterEO roleEORef);
    
    public Integer deleteRole(String roleName);
    
    public RoleMasterEO findByRoleName(String roleName);
    
    public List<RoleMasterEO> fetchAllRoles();
}
