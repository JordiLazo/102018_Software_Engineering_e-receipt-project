package supervisedtreatment;


import data.HealthCardID;
import exceptions.*;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import org.junit.jupiter.api.*;
import services.HealthNationalService;

import java.util.List;

class ConsultationTerminalTest {
    ConsultationTerminal ct1;
    HealthNationalService hns1;
    @BeforeEach
    void setUp() throws NotValidePrescriptionException, HealthCardException, ConnectException {
        hns1 = new ConsultationTerminalDouble();
        ct1 = new ConsultationTerminal();
    }

    @Test
    @DisplayName("Check if initRevision is correct")
    void checkinitRevision(){

    }
    private class ConsultationTerminalDouble implements HealthNationalService{

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
}