package medicalconsultation;

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import exceptions.IncorrectTakingGuidelinesException;
import exceptions.ProductNotInPrescription;

import java.util.ArrayList;
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

    public static void main(String[] args) throws ProductNotInPrescription, IncorrectTakingGuidelinesException {
        MedicalPrescription t1 = new MedicalPrescription();
        ProductID d1 = new ProductID("123");
        t1.addLine(d1, new String[]{"hola"});
        System.out.println(t1);
    }
}
