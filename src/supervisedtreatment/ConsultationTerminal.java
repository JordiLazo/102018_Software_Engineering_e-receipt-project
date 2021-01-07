package supervisedtreatment;

import data.HealthCardID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import services.HealthNationalService;
import services.ScheduledVisitAgenda;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultationTerminal {
    MedicalPrescription medicalPrescription = null;
    HealthCardID hc;
    ScheduledVisitAgenda sva;
    HealthNationalService hns;

    boolean isFinishedPrescription;//by default it is initiated to false
    List<ProductSpecification> list_of_products;
    private ProductSpecification choosenProduct;


    public ConsultationTerminal() {

    }

    public void initRevision()throws HealthCardException,  NotValidePrescriptionException, ConnectException {
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
        //this.isFinishedPrescription = false;

    }

    public void searchForProducts(String keyWord)throws AnyKeyWordMedicineException, ConnectException{
        if (!keyWord.equals("")) {
            this.list_of_products = hns.getProductsByKW(keyWord);
        }
    }

    public void selectProduct(int option)throws  AnyMedicineSearchException, ConnectException{
        if (0<=option && option <this.list_of_products.size()){
            this.choosenProduct= hns.getProcuductSpecific(option);
        }

    }

    public void enterMedicineGuidelines(String[] instruc)throws
            AnySelectedMedicineException, IncorrectTakingGuidelinesException{}

    public void enterTreatmentEndingDate(Date date)throws IncorrectEndingDateException{}

    public void sendePrescription()throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription{
        isFinishedPrescription = true;
    }

    public void printePresc()throws printingException{}

    // ????  Other methods, apart from the input events

/*
    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {

        if (hcID ==  null) {
            throw new HealthCardException("Not a HealtCard");
        }
        /*
         *moguda per conectarse al SNS
         */
        //Descarregar
/*        return new MedicalPrescription();
    }

    @Override
    public List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException {

        if (keyWord.equals("")) {
            throw new AnyKeyWordMedicineException("No keyword input");
        }

        /*
         *  conectarse al SNS
         *  <--- Llista de productes(especificacions)
         *
         */


/*
        return new ArrayList<ProductSpecification>();
    }

    @Override
    public ProductSpecification getProcuductSpecific(int opt) throws AnyMedicineSearchException, ConnectException {
        /*
         *  buscar medicina
         *  No trobar ---> AnyMedicineSearchException
         *  Trobat ------> return List<ProductSpecification> [opt][especificacions]
         *
         * */
/*        return null;
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription {
        return null;
    }
*/
}
