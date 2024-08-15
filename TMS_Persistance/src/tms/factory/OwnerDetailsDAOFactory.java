package tms.factory;

import tms.dao.OwnerDetailsDAO;
import tms.dao.impl.OwnerDetailsDAOImpl;

public class OwnerDetailsDAOFactory {
    private static final OwnerDetailsDAO ownerDaoRef = new OwnerDetailsDAOImpl();
    public static OwnerDetailsDAO createOwnerDAO() {
        return ownerDaoRef;
    }
}
