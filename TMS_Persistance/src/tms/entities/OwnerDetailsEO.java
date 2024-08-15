package tms.entities;

import java.time.LocalDate;

import java.sql.Date;


public class OwnerDetailsEO {
    private int ownerId;
    private String fName;
    private String lName;
    private Date dateOfBirth;
    private String landLineNo;
    private String mobileNo;
    private String gender;
    private String tempAddr;
    private String permAddr;
    private int pincode;
    private String occupation;
    private String panCardId;
    private String addProofName;
    
    public OwnerDetailsEO() {}

    public OwnerDetailsEO(int ownerId, String fName, String lName,
                          Date dateOfBirth, String landLineNo,
                          String mobileNo, String gender, String tempAddr,
                          String permAddr, int pincode, String occupation,
                          String panCardId, String addProofName) {
        super();
        this.ownerId = ownerId;
        this.fName = fName;
        this.lName = lName;
        this.dateOfBirth = dateOfBirth;
        this.landLineNo = landLineNo;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.tempAddr = tempAddr;
        this.permAddr = permAddr;
        this.pincode = pincode;
        this.occupation = occupation;
        this.panCardId = panCardId;
        this.addProofName = addProofName;
    }
    
  

    public OwnerDetailsEO(int ownerId, String landLineNo, String mobileNo,
                          String tempAddr, int pincode, String occupation) {
        this.ownerId = ownerId;
        this.landLineNo = landLineNo;
        this.mobileNo = mobileNo;
        this.tempAddr = tempAddr;
        this.pincode = pincode;
        this.occupation = occupation;
    }


    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLName() {
        return lName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setLandLineNo(String landLineNo) {
        this.landLineNo = landLineNo;
    }

    public String getLandLineNo() {
        return landLineNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setTempAddr(String tempAddr) {
        this.tempAddr = tempAddr;
    }

    public String getTempAddr() {
        return tempAddr;
    }

    public void setPermAddr(String permAddr) {
        this.permAddr = permAddr;
    }

    public String getPermAddr() {
        return permAddr;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getPincode() {
        return pincode;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setPanCardId(String panCardId) {
        this.panCardId = panCardId;
    }

    public String getPanCardId() {
        return panCardId;
    }

    public void setAddProofName(String addProofName) {
        this.addProofName = addProofName;
    }

    public String getAddProofName() {
        return addProofName;
    }


    @Override
    public String toString() {
        return "Owner Details [ " + "ownerId=" + ownerId + ", fname=" + fName +  ", lname=" + lName +
        ", dateOfBirth=" + dateOfBirth +  ", landlineNo=" + landLineNo + ", mobileNo=" + mobileNo +
        ", gender=" + gender +", tempAddr='" + tempAddr +", permAddr=" + permAddr +", pincode=" + pincode +
        ", occupation=" + occupation +", panCardId=" + panCardId +", addProofName=" + addProofName + " ]";
    }
}
