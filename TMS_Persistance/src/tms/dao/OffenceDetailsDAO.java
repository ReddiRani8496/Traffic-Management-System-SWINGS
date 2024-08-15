package tms.dao;

import java.util.ArrayList;

import tms.entities.OffenceDetailsEO;

public interface OffenceDetailsDAO {
    
    public Integer add(OffenceDetailsEO offenceDetailsEORef);
    
    public Integer update(OffenceDetailsEO offenceDetailsEORef);
    
    public Integer delete(Integer offenceDetailId);
    
    public OffenceDetailsEO findByOffenceDetailId(Integer offenceDetailId);
    
    public ArrayList<OffenceDetailsEO> findAllOffenceDetails();
    
    public ArrayList<OffenceDetailsEO> findAllOffenceDetailsByVehNum(String vehNum);
    
}
