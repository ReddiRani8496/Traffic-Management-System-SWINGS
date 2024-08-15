package tms.entities;
import java.sql.Date;
public class VehicleDetailsEO {
    private int vehId;
    private String vehType;
    private String engineNo;
    private String modelNo;
    private String vehName;
    private String vehColor;
    private String manufacturerName;
    private Date dateOfManufacture;
    private int noOfCylinders;
    private int cubicCapacity;
    private String fuelUsed;
    private String chassisNo;
    
    public VehicleDetailsEO(){}

    public VehicleDetailsEO( String vehType, String engineNo,
                            String modelNo, String vehName, String vehColor,
                            String manufacturerName, Date dateOfManufacture,
                            int noOfCylinders, int cubicCapacity,
                            String fuelUsed, String chassisNo) {
        this.vehType = vehType;
        this.engineNo = engineNo;
        this.modelNo = modelNo;
        this.vehName = vehName;
        this.vehColor = vehColor;
        this.manufacturerName = manufacturerName;
        this.dateOfManufacture = dateOfManufacture;
        this.noOfCylinders = noOfCylinders;
        this.cubicCapacity = cubicCapacity;
        this.fuelUsed = fuelUsed;
        this.chassisNo = chassisNo;
    }
    
    
    
    public VehicleDetailsEO(int vehId, String vehColor) {
        this.vehId = vehId;
        this.vehColor = vehColor;
    }


    public void setVehId(int vehId) {
        this.vehId = vehId;
    }

    public int getVehId() {
        return vehId;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public String getVehType() {
        return vehType;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setVehName(String vehName) {
        this.vehName = vehName;
    }

    public String getVehName() {
        return vehName;
    }

    public void setVehColor(String vehColor) {
        this.vehColor = vehColor;
    }

    public String getVehColor() {
        return vehColor;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setNoOfCylinders(int noOfCylinders) {
        this.noOfCylinders = noOfCylinders;
    }

    public int getNoOfCylinders() {
        return noOfCylinders;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public void setFuelUsed(String fuelUsed) {
        this.fuelUsed = fuelUsed;
    }

    public String getFuelUsed() {
        return fuelUsed;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }


    @Override
    public String toString() {
        return "Vehicle Details [ " + "vehId=" + vehId + ", vehType='" + vehType + ", engineNo='" + engineNo +
        ", modelNo='" + modelNo + ", vehName='" + vehName + ", vehColor='" + vehColor +
        ", manufacturerName='" + manufacturerName +", dateOfManufacture=" + dateOfManufacture +
        ", noOfCylinders=" + noOfCylinders +", cubicCapacity=" + cubicCapacity +  ", fuelUsed='" + fuelUsed +
        ", chassisNo='" + chassisNo + " ]";
    }
}
