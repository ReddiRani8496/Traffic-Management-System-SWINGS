package tms.dao;

import java.util.ArrayList;

import tms.entities.OwnerDetailsEO;

public interface OwnerDetailsDAO {
    public Integer add(OwnerDetailsEO ownerDetailsEORef);
    
    public Integer update(OwnerDetailsEO ownerDetailsEORef);
    
    public Integer delete(Integer ownerId);
    
    public OwnerDetailsEO findByOwnerId(String panNum);
    
    public OwnerDetailsEO findByOwner(Integer ownerId);
    
    public ArrayList<OwnerDetailsEO> findAllOwners();
}
