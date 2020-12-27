package supervisedtreatment;

import data.HealthCardID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;
import services.HealthNationalService;
import services.ProductSpecification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultationTerminal implements HealthNationalService {

    public ConsultationTerminal() {
    }

    public void initRevision()throws HealthCardException,  NotValidePrescriptionException, ConnectException{

    }
    public void initPrescriptionEdition()throws AnyCurrentPrescriptionException, NotFinishedTreatmentException{}

    public void searchForProducts(String keyWord)throws AnyKeyWordMedicineException, ConnectException{}

    public void selectProduct(int option)throws  AnyMedicineSearchException, ConnectException{}

    public void enterMedicineGuidelines(String[] instruc)throws
            AnySelectedMedicineException, IncorrectTakingGuidelinesException{}

    public void enterTreatmentEndingDate(Date date)throws IncorrectEndingDateException{}

    public void sendePrescription()throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription{}

    public void printePresc()throws printingException{}

    // ????  Other methods, apart from the input events






    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
        /*
        *
        * */
        if (hcID ==  null) {
            throw new HealthCardException("Not a HealtCard");
        }
        //Descarregar
        return new MedicalPrescription();
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
        return null;
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription {
        return null;
    }
}
