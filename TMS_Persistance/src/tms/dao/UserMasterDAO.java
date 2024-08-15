package tms.dao;

import java.util.ArrayList;

import tms.entities.UserMasterEO;

public interface UserMasterDAO {
    public boolean login(UserMasterEO userMasterRef);
    
    public Integer add(UserMasterEO userMasterRef);
    
    public Integer update(UserMasterEO userMasterRef);
    
    public Integer delete(String userName);
    
    public UserMasterEO findByUserName(String userName);
    
    public ArrayList<UserMasterEO> findAllUsers();
}
