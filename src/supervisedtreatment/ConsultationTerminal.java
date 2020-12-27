package supervisedtreatment;

import data.HealthCardID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;
import services.HealthNationalService;
import services.ProductSpecification;

import java.util.List;

public class ConsultationTerminal implements HealthNationalService {

    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
        return null;
    }

    @Override
    public List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException {
        return null;
    }

    @Override
    public ProductSpecification getProcuductSpecific(int opt) throws AnyMedicineSearchException, ConnectException {
        return null;
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription {
        return null;
    }
}
