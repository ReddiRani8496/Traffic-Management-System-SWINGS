package tms.factory;

import tms.dao.UserMasterDAO;

import tms.dao.impl.UserMasterDAOImpl;

public class UserMasterDAOFactory {
    private static final UserMasterDAO userMasterDaoRef = new UserMasterDAOImpl();
    public static UserMasterDAO createUserMasterDAO() {
        return userMasterDaoRef;
    }
}
