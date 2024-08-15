package tms.business;

import java.util.List;

import tms.entities.OffenceDetailsEO;
import tms.entities.OwnerDetailsEO;
import tms.entities.VehicleDetailsEO;

public interface ClerkOperations {
    
    public Integer raiseOffence(OffenceDetailsEO offenceDetailsRef);
    
    public Integer clearOffence(OffenceDetailsEO offenceDetailsRef);
    
    public List<OffenceDetailsEO> fetchAllOffencesCommited(String vehNo);
    
    public List<OffenceDetailsEO> fetchAllOffences();
}
