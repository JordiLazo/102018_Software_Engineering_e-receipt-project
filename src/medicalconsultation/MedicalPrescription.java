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

    private final HashMap<ProductID, String[]> map;



    // ???// Its components, that is, the set of medical prescription lines
    public MedicalPrescription() {
        this.map = new HashMap<>();
    }
    public void addLine(ProductID prodID, String[] instruc) throws IncorrectTakingGuidelinesException {

        if(!map.containsKey(prodID)){
            if (prodID != null && instruc.length!=0) {
                map.put(prodID,instruc);
            }else {
                throw new IncorrectTakingGuidelinesException("Cannot add: Incorrect Format");
            }

        }
        throw new IncorrectTakingGuidelinesException("Cannot add: This already in");
    }
    public void modifyLine(ProductID prodID,String[] instruc)throws ProductNotInPrescription, IncorrectTakingGuidelinesException{
        if(map.containsKey(prodID)){
            if (prodID != null && instruc.length!=0) {
                map.put(prodID,instruc);
            }else {
                throw new IncorrectTakingGuidelinesException("Cannot modify: Incorrect Format");
            }
        }
        throw new ProductNotInPrescription("Cannot modify: Not found product ");

    }
    public void removeLine(ProductID prodID) throws ProductNotInPrescription{
        if(map.containsKey(prodID)){
            map.remove(prodID);
        }else{
            throw new ProductNotInPrescription("Cannot remove: Not found product ");
        }

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

}
