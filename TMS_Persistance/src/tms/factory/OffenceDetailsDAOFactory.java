package tms.factory;


import tms.dao.OffenceDetailsDAO;
import tms.dao.impl.OffenceDetailsDAOImpl;

public class OffenceDetailsDAOFactory {
    private static final OffenceDetailsDAO offenceDetailsDaoRef = new OffenceDetailsDAOImpl();
    public static OffenceDetailsDAO createOffenceDetailsDAO() {
        return offenceDetailsDaoRef;
    }
}
