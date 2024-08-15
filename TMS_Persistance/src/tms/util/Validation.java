package tms.util;

import java.util.regex.Pattern;

import tms.dao.OffenceDAO;
import tms.dao.OwnerDetailsDAO;
import tms.dao.RegDetailsDAO;

import tms.dao.RoleMasterDAO;
import tms.dao.UserMasterDAO;

import tms.dao.VehicleDetailsDAO;

import tms.entities.OffenceEO;
import tms.entities.OwnerDetailsEO;
import tms.entities.RegDetailsEO;

import tms.entities.RoleMasterEO;
import tms.entities.UserMasterEO;

import tms.entities.VehicleDetailsEO;

import tms.factory.OffenceDAOFactory;
import tms.factory.OwnerDetailsDAOFactory;
import tms.factory.RegDetailsDAOFactory;
import tms.factory.RoleMasterDAOFactory;
import tms.factory.UserMasterDAOFactory;
import tms.factory.VehicleDetailsDAOFactory;

public class Validation {
    // Validate name
       public static boolean validateName(String name) {
           return name.matches("[a-zA-Z ]{3,30}");
       }
       
       // Validate email
       public static boolean validateEmail(String email) {
           return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
       }
       
       // Validate password
       public static boolean validatePassword(String password) {
           return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
       }
       
       // Validate mobile number
       public static boolean validateMobileNumber(String mobileNumber) {
           return mobileNumber.matches("\\d{10}");
       }
       
        // Raising the offence
       public static boolean isValidVehNum(String vehNum) {
           RegDetailsDAO regDetailsDAORef = RegDetailsDAOFactory.createRegDetailsDAO();
           RegDetailsEO reg = regDetailsDAORef.findByVehNo(vehNum);
           return reg != null;
       }
       
       public static boolean isValidOffenceId(int offenceId) {
          OffenceDAO offenceDAORef = OffenceDAOFactory.createOffenceDAO();
         OffenceEO offence = offenceDAORef.findByOffenceId(offenceId);
         return offence != null;
       }
       
       public static boolean isValidReporter(String reporter) {
           UserMasterDAO userMasterDAORef = UserMasterDAOFactory.createUserMasterDAO();
           UserMasterEO  user = userMasterDAORef.findByUserName(reporter);
          return user != null;
       }
    public static boolean isValidOffenceId(String offenceId) {
           // Regular expression to match only numbers
           String regex = "\\d+";
           // Check if the input matches the regex
           return Pattern.matches(regex, offenceId);
       }
       
       // Registration
       public static boolean isValidVehId(int vehId) {
           VehicleDetailsDAO vehicleDAORef = VehicleDetailsDAOFactory.createVehicleDetailsDAO();
           VehicleDetailsEO vehicle = vehicleDAORef.findByVehId(vehId);
           return vehicle != null;
       }
       
       public static boolean isValidOwnerId(int ownerId) {
           OwnerDetailsDAO ownerDAORef = OwnerDetailsDAOFactory.createOwnerDAO();
           OwnerDetailsEO owner = ownerDAORef.findByOwner(ownerId);
          return owner!=null;
       }
       
       
       // Offence types
       public static boolean isValidPenalty(String penalty) {
           return penalty.matches("^[0-9]+(?:\\.[0-9]{1,2})?$");
       }
        
        public static boolean isValidOffenceType(String offenceType) {
            return offenceType.matches("^[a-zA-Z ]+$");
        }
        
        public static boolean isValidPanNum(String panNum) {
            OwnerDetailsDAO ownerDAORef = OwnerDetailsDAOFactory.createOwnerDAO();
            OwnerDetailsEO owner = ownerDAORef.findByOwnerId(panNum);
            return owner!=null;
            
        }
        
        public static boolean isUniqueVehicleNum(String vehNum) {
            RegDetailsDAO regDetailsDAORef = RegDetailsDAOFactory.createRegDetailsDAO();
                RegDetailsEO reg = regDetailsDAORef.findByVehNo(vehNum);
                return reg == null;
        }
        
        public static boolean isUniqueUser(String userName) {
            UserMasterDAO userMasterDAORef = UserMasterDAOFactory.createUserMasterDAO();
            UserMasterEO  user = userMasterDAORef.findByUserName(userName);
            return user == null;
        }
        
        public static boolean isUniqueRole(String roleName) {
            RoleMasterDAO roleMasterDAORef = RoleMasterDAOFactory.createRoleMasterDAO();
            RoleMasterEO role = roleMasterDAORef.findByRoleName(roleName);
            return role == null;
        }
        
}
