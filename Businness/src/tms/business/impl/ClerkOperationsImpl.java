package tms.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tms.business.ClerkOperations;

import tms.dao.OffenceDetailsDAO;
import tms.dao.RegDetailsDAO;

import tms.entities.OffenceDetailsEO;

import tms.factory.OffenceDetailsDAOFactory;
import tms.factory.RegDetailsDAOFactory;

public class ClerkOperationsImpl implements ClerkOperations{
    
    private OffenceDetailsDAO offenceDetailsDaoRef = OffenceDetailsDAOFactory.createOffenceDetailsDAO();
    
    private OffenceDetailsDAO offenceDetailsDAORef = OffenceDetailsDAOFactory.createOffenceDetailsDAO();
    
    public Integer raiseOffence(OffenceDetailsEO offenceDetailsRef) {
        return offenceDetailsDaoRef.add(offenceDetailsRef);
    }

    public Integer clearOffence(OffenceDetailsEO offenceDetailsRef) {
        return offenceDetailsDaoRef.update(offenceDetailsRef);
    }
    
    public List<OffenceDetailsEO> fetchAllOffencesCommited(String vehNo) {
        ArrayList<OffenceDetailsEO> offenceDetails = offenceDetailsDAORef.findAllOffenceDetails();
        
        ArrayList<OffenceDetailsEO> updatedOffenceDet = new ArrayList<OffenceDetailsEO>();
        
        for (OffenceDetailsEO detail : offenceDetails) {
            String vehicleNumber = detail.getRegDetails().getVehNo();
            
            if(vehNo.equals(vehicleNumber))
                    updatedOffenceDet.add(detail);
        }
        
        return updatedOffenceDet;
    }

    public List<OffenceDetailsEO> fetchAllOffences() {
        return offenceDetailsDAORef.findAllOffenceDetails();
    }
}
