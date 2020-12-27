package services;

import data.HealthCardID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;

import java.util.List;

/**
 * External service for managingand storing ePrescriptions from population
 * */
public interface HealthNationalService {

    MedicalPrescription getePrescription(HealthCardID hcID)  throws HealthCardException, NotValidePrescriptionException, ConnectException;
    List<ProductSpecification> getProductsByKW(String keyWord)
        throws AnyKeyWordMedicineException,ConnectException;

    ProductSpecification getProcuductSpecific(int opt)
        throws AnyMedicineSearchException, ConnectException;

    MedicalPrescription sendePrescription(MedicalPrescription ePresc)
        throws ConnectException, NotValidePrescription,eSignatureException,
            NotCompletedMedicalPrescription;

}
