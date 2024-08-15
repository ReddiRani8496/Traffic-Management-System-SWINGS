package tms.factory;

import tms.dao.RegDetailsDAO;
import tms.dao.impl.RegDetailsDAOImpl;

public class RegDetailsDAOFactory {
    private static final RegDetailsDAO regDetailsDaoRef = new RegDetailsDAOImpl();

    public static RegDetailsDAO createRegDetailsDAO() {
        return regDetailsDaoRef;
    }

}
