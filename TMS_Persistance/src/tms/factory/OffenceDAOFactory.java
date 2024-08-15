package tms.factory;

import tms.dao.OffenceDAO;

import tms.dao.impl.OffenceDAOImpl;

public class OffenceDAOFactory {
    private static final OffenceDAO offenceDaoRef = new OffenceDAOImpl();
    public static OffenceDAO createOffenceDAO() {
        return offenceDaoRef;
    }
    
}
