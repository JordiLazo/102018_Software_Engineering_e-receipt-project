package medicalconsultation;

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import exceptions.IncorrectTakingGuidelinesException;
import exceptions.ProductNotInPrescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;


/**
 * Package for the classes involved in the use case Suply next dispensing
 * */
public class MedicalPrescription {// A class that represents medical prescription
    private int prescCode;
    private Date prescDate;
    private Date endDate;
    private HealthCardID hcID; // the healthcard ID of the patient
    private DigitalSignature eSign; // the eSignature of the doctor

    private final MedicalPrescriptionLine map;



    // ???// Its components, that is, the set of medical prescription lines
    public MedicalPrescription() {
        this.map = new MedicalPrescriptionLine();
    }
    public void addLine(ProductID prodID, String[] instruc) throws IncorrectTakingGuidelinesException {
        map.addLine(prodID,instruc);

    }
    public void modifyLine(ProductID prodID,String[] instruc)throws ProductNotInPrescription, IncorrectTakingGuidelinesException{
        map.modifyLine(prodID,instruc);

    }
    public void removeLine(ProductID prodID) throws ProductNotInPrescription{
        map.removeLine(prodID);
    }


    public int getPrescCode() {
        return prescCode;
    }

    public void setPrescCode(int prescCode) {
        this.prescCode = prescCode;
    }

    public Date getPrescDate() {
        return prescDate;
    }

    public void setPrescDate(Date prescDate) {
        this.prescDate = prescDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public HealthCardID getHcID() {
        return hcID;
    }

    public void setHcID(HealthCardID hcID) {
        this.hcID = hcID;
    }

    public DigitalSignature geteSign() {
        return eSign;
    }

    public void seteSign(DigitalSignature eSign) {
        this.eSign = eSign;
    }

    @Override
    public String toString() {
        return "MedicalPrescription{" +"\n"+
                ", prescCode=" + prescCode +"\n"+
                ", prescStartDate=" + prescDate +"\n"+
                ", endDate=" + endDate +"\n"+
                ", hcID=" + hcID +"\n"+
                ", eSign=" + Arrays.toString(eSign.getDigitalSignature()) +"\n"+
                ", MedicalPrescriptionLines=" + map.toString() +
                '}';
    }
}
