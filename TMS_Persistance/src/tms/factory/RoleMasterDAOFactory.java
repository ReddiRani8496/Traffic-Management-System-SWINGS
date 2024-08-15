package tms.factory;

import tms.dao.RoleMasterDAO;
import tms.dao.impl.RoleMasterDAOImpl;

public class RoleMasterDAOFactory {
    private static final RoleMasterDAO roleMasterDaoRef = new RoleMasterDAOImpl();
    public static RoleMasterDAO createRoleMasterDAO() {
        return roleMasterDaoRef;
    }
}
