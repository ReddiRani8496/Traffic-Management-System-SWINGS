package tms.entities;

import java.sql.Timestamp;

public class OffenceDetailsEO {
    private RegDetailsEO regDetails;
    private byte[] image;
    private int offenceDetailId;
    private String offenceStatus;
    private OffenceEO offence;
    private Timestamp time;
    private String place;
    private UserMasterEO user;

    public OffenceDetailsEO() {}

    public OffenceDetailsEO(RegDetailsEO regDetails, byte[] image,
        int offenceDetailId, String offenceStatus, OffenceEO offence,
        Timestamp time, String place, UserMasterEO user) {
        super();
        this.regDetails = regDetails;
        this.image = image;
        this.offenceDetailId = offenceDetailId;
        this.offenceStatus = offenceStatus;
        this.offence = offence;
        this.time = time;
        this.place = place;
        this.user = user;
    }
    
    public OffenceDetailsEO(RegDetailsEO regDetails, byte[] image,
        String offenceStatus, OffenceEO offence,
        Timestamp time, String place, UserMasterEO user) {
        super();
        this.regDetails = regDetails;
        this.image = image;
        this.offenceStatus = offenceStatus;
        this.offence = offence;
        this.time = time;
        this.place = place;
        this.user = user;
    }

    public OffenceDetailsEO(int offenceDetailId, String offenceStatus) {
        
        this.offenceDetailId = offenceDetailId;
        this.offenceStatus = offenceStatus;
    }


    public void setRegDetails(RegDetailsEO regDetails) {
        this.regDetails = regDetails;
    }

    public RegDetailsEO getRegDetails() {
        return regDetails;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }
  

    public void setOffenceDetailId(int offenceDetailId) {
        this.offenceDetailId = offenceDetailId;
    }

    public int getOffenceDetailId() {
        return offenceDetailId;
    }

    public void setOffenceStatus(String offenceStatus) {
        this.offenceStatus = offenceStatus;
    }

    public String getOffenceStatus() {
        return offenceStatus;
    }

    public void setOffence(OffenceEO offence) {
        this.offence = offence;
    }

    public OffenceEO getOffence() {
        return offence;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setUser(UserMasterEO user) {
        this.user = user;
    }

    public UserMasterEO getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Offence Details [offenceDetailId=" + offenceDetailId + 
               ", offenceStatus=" + offenceStatus + 
               ", time=" + time + 
               ", place=" + place + 
               ", regDetails=" + regDetails.getVehNo() + 
               ", offence=" +offence.getOffenceId() + 
               ", user=" + user.getUsername() + "]";
    }

   
}
