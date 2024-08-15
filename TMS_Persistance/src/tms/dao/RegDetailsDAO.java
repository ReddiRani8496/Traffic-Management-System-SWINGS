package tms.dao;

import java.util.ArrayList;

import tms.entities.RegDetailsEO;

public interface RegDetailsDAO {
    public Integer add(RegDetailsEO regDetailsRef);
    
    public Integer update(RegDetailsEO regDetailsRef);
    
    public Integer delete(String vehNo);
    
    public RegDetailsEO findByVehNo(String vehNo);
    
    public ArrayList<RegDetailsEO> findAllRegDetails();
}
