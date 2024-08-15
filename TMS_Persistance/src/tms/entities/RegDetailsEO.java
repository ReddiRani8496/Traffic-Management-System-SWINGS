package tms.entities;

import java.sql.Date;

public class RegDetailsEO {
    private int appNo;
    private String vehNo;
    private VehicleDetailsEO vehicleDetails;
    private OwnerDetailsEO ownerDetails;
    private Date dateOfPurchase;
    private String distributerName;
    
    public RegDetailsEO(){}

    public RegDetailsEO(int appNo, String vehNo, VehicleDetailsEO vehicleDetails, OwnerDetailsEO ownerDetails,
                        Date dateOfPurchase, String distributerName) {
        super();
        this.appNo = appNo;
        this.vehNo = vehNo;
        this.vehicleDetails = vehicleDetails;
        this.ownerDetails = ownerDetails;
        this.dateOfPurchase = dateOfPurchase;
        this.distributerName = distributerName;
    }

    public RegDetailsEO(String vehNo, OwnerDetailsEO ownerDetails) {
        super();
        this.vehNo = vehNo;
        this.ownerDetails = ownerDetails;
    }


    public int getAppNo() {
        return appNo;
    }

    public void setAppNo(int appNo) {
        this.appNo = appNo;
    }

    public String getVehNo() {
        return vehNo;
    }

    public void setVehNo(String vehNo) {
        this.vehNo = vehNo;
    }

    public VehicleDetailsEO getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDetailsEO vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public OwnerDetailsEO getOwnerDetails() {
        return ownerDetails;
    }

    public void setOwnerDetails(OwnerDetailsEO ownerDetails) {
        this.ownerDetails = ownerDetails;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getDistributerName() {
        return distributerName;
    }

    public void setDistributerName(String distributerName) {
        this.distributerName = distributerName;
    }

    @Override
public String toString() {
    return "RegDetails [ " +
            "Application Number=" + appNo +
            ", Vehicle Number=" + vehNo +
            ", Vehicle Details=" + (vehicleDetails != null ? vehicleDetails.toString() : "") +
            ", Owner Details=" + (ownerDetails != null ? ownerDetails.toString() : "") +
            ", Date of Purchase=" + dateOfPurchase +
            ", Distributor Name=" + distributerName +
            " ]";
}

	
}
