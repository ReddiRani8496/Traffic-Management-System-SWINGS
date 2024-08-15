package tms.entities;

public class OffenceEO {
    private int offenceId;
    private String offenceType;
    private int penalty;
    private String vehType;
    
    public OffenceEO() {}

    public OffenceEO(int offenceId, String offenceType, int penalty,
                     String vehType) {
        super();
        this.offenceId = offenceId;
        this.offenceType = offenceType;
        this.penalty = penalty;
        this.vehType = vehType;
    }
    
    public OffenceEO( String offenceType, int penalty,
                     String vehType) {
   
        this.offenceType = offenceType;
        this.penalty = penalty;
        this.vehType = vehType;
    }

    public void setOffenceId(int offenceId) {
        this.offenceId = offenceId;
    }

    public int getOffenceId() {
        return offenceId;
    }

    public void setOffenceType(String offenceType) {
        this.offenceType = offenceType;
    }

    public String getOffenceType() {
        return offenceType;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public String getVehType() {
        return vehType;
    }


    @Override
    public String toString() {
        return "Offence [ " + "offenceId=" + offenceId +", offenceType=" + offenceType +", penalty=" + penalty +", vehType='" + vehType +" ]";
    }
}
