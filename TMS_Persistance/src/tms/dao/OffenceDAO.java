package tms.dao;

import java.util.ArrayList;

import tms.entities.OffenceEO;

public interface OffenceDAO {
    
    public Integer add(OffenceEO offenceEORef);
    
    public Integer update(OffenceEO offenceEORef);
    
    public Integer delete(Integer offenceId);
    
    public OffenceEO findByOffenceId(Integer offenceId);
    
    public ArrayList<OffenceEO> findAllOffence();
}
