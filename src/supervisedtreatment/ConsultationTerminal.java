package supervisedtreatment;

import data.DigitalSignature;
import data.HealthCardID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import services.HealthNationalService;
import services.ScheduledVisitAgenda;
import java.util.*;

public class ConsultationTerminal {
    MedicalPrescription medicalPrescription = null;
    HealthCardID hc;
    ScheduledVisitAgenda sva;
    HealthNationalService hns;

    boolean isFinishedPrescription;//by default it is initiated to false
    List<ProductSpecification> list_of_products;
    public ProductSpecification choosenProduct;
    public Date treatmentEndingDate =null;


    public ConsultationTerminal() {

    }
    public void setHns(HealthNationalService hns) {
        this.hns = hns;
    }

    public void setSva(ScheduledVisitAgenda sva) {
        this.sva = sva;
    }

    public void initRevision()throws HealthCardException,  NotValidePrescriptionException, ConnectException {
        this.isFinishedPrescription = false;

        hc = sva.getHealthCardID();

        if (hc == null) {
            throw new HealthCardException("Invalid card");
        }
        medicalPrescription = hns.getePrescription(hc);

    }

    public void initPrescriptionEdition()throws AnyCurrentPrescriptionException, NotFinishedTreatmentException{
        if (isFinishedPrescription){
            throw new AnyCurrentPrescriptionException("Error");
        }
    }

    public void searchForProducts(String keyWord)throws AnyKeyWordMedicineException, ConnectException{
        if (!keyWord.equals("")) {
            this.list_of_products = hns.getProductsByKW(keyWord);

        }else{throw new AnyKeyWordMedicineException("No keyword");}
    }

    public void selectProduct(int option)throws  AnyMedicineSearchException, ConnectException{
        if (list_of_products != null) {
            if (0<=option && option <this.list_of_products.size()){
                this.choosenProduct= hns.getProcuductSpecific(option);
            }else {
                throw new AnyMedicineSearchException("Out of list");
            }
        }else {throw new AnyMedicineSearchException("you have no list");}
    }

    public void enterMedicineGuidelines(String[] instruc)throws
            AnySelectedMedicineException, IncorrectTakingGuidelinesException{
        if (choosenProduct != null) {
            if (instruc.length !=0) {
                medicalPrescription.addLine(this.choosenProduct.getProduct(),instruc);
            }else { throw new AnySelectedMedicineException(" enter medicine guidelines");}
        }else{ throw new AnySelectedMedicineException(" cannot guideline for empty");}
    }

    public void enterTreatmentEndingDate(Date date)throws IncorrectEndingDateException{
        this.isFinishedPrescription = true;
        Date today = Calendar.getInstance().getTime();
        if (date!=null && date.after(today)){
            this.treatmentEndingDate = date;
        }else {
            throw  new IncorrectEndingDateException("Incorrect ending date");
        }
    }

    public void sendePrescription()throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription{
        if (this.isFinishedPrescription){
            DigitalSignature esign= new DigitalSignature("si");
            medicalPrescription.seteSign(esign);
            Random rand = new Random();
            medicalPrescription.setPrescCode(rand.nextInt(1000000));
            medicalPrescription = hns.sendePrescription(medicalPrescription);
        }else {
            throw  new NotCompletedMedicalPrescription("Not completed");
        }

    }

    public void printePresc()throws printingException{
        if (medicalPrescription == null) {
            throw new printingException("Cannot print");
        }
    }
}
