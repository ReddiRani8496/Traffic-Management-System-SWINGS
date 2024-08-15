package tms.dao;

import java.util.ArrayList;

import tms.entities.RoleMasterEO;

public interface RoleMasterDAO {
    public Integer add(RoleMasterEO roleMasterRef);
    
    public Integer update(RoleMasterEO roleMasterRef);
    
    public Integer delete(String roleName);
    
    public RoleMasterEO findByRoleName(String roleName);
    
    public ArrayList<RoleMasterEO> findAllRoles();
}
