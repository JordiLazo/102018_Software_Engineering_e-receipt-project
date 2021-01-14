package supervisedtreatment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import exceptions.*;
import medicalconsultation.*;
import org.junit.jupiter.api.*;
import services.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ConsultationTerminalTest {
    ConsultationTerminal ct1;
    static ScheduledVisitAgenda sva1;
    static HealthNationalService hns1;

    @BeforeAll
    static void general_setup() throws HealthCardException, eSignatureException, ProductNotInPrescription, IncorrectTakingGuidelinesException, ParseException {
        hns1 = new HNS();
        sva1 = new ScheduledVisitAgendaImpl();
    }

    @BeforeEach
    void setUp() {
        ct1 = new ConsultationTerminal();
        ct1.setHns(hns1);
        ct1.setSva(sva1);
    }

    @DisplayName("Check if initRevision is correct")
    @Test
    void checkinitRevision(){
        assertDoesNotThrow(()->ct1.initRevision());
        assertFalse(ct1.isFinishedPrescription);
        assertNotNull(ct1.medicalPrescription);

    }

    @DisplayName("Check if the method searchForProducts has no keyword")
    @Test
    void checksearchForProducts1() {
        assertThrows(AnyKeyWordMedicineException.class,()->ct1.searchForProducts(""));
    }

    @DisplayName("Check if the method searchForProducts has a keyword")
    @Test
    void checksearchForProducts2() {
        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
    }

    @DisplayName("Check if selected product option 0")
    @Test
    void selectProduct1() {
        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
        assertDoesNotThrow(()->ct1.selectProduct(0));
        assertNotNull(ct1.choosenProduct);
    }

    @DisplayName("select product option out index")
    @Test
    void selectProduct2() {
        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
        assertThrows(AnyMedicineSearchException.class,()->ct1.selectProduct(31));
        assertNull(ct1.choosenProduct);

    }
    @DisplayName("select product option but list is null")
    @Test
    void selectProduct_in_no_list() {
        assertThrows(AnyMedicineSearchException.class,()->ct1.selectProduct(31));
        assertNull(ct1.choosenProduct);

    }
    @DisplayName("Enter medicine Guidelines but chosen product is null")

    @Test
    void enterMedicineGuidelines() {
        assertThrows(AnySelectedMedicineException.class,()->ct1.enterMedicineGuidelines(new String[]{"Sampe Guidelines"}));
    }
    @DisplayName("Enter medicine Guidelines but Guidelines list are empty")
    @Test
    void enterMedicineGuidelines_2() {
        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
        assertDoesNotThrow(()->ct1.selectProduct(0));
        assertNotNull(ct1.choosenProduct);
        assertThrows(AnySelectedMedicineException.class,()->ct1.enterMedicineGuidelines(new String[]{}));
    }
    @DisplayName("Enter medicine Guidelines in correct form")
    @Test
    void enterMedicineGuidelines_3() {
        assertDoesNotThrow(()->ct1.initRevision());
        assertFalse(ct1.isFinishedPrescription);
        assertNotNull(ct1.medicalPrescription);

        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
        assertDoesNotThrow(()->ct1.selectProduct(0));
        assertNotNull(ct1.choosenProduct);
        assertDoesNotThrow(()->ct1.enterMedicineGuidelines(new String[]{"Guideline1","guideline2"}));
    }



    @DisplayName("enterTreatmentEndingDate but is before start treatment")
    @Test
    void enterTreatmentEndingDate() {
        assertDoesNotThrow(()->ct1.initRevision());
        assertFalse(ct1.isFinishedPrescription);
        assertNotNull(ct1.medicalPrescription);

        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
        assertDoesNotThrow(()->ct1.selectProduct(0));
        assertNotNull(ct1.choosenProduct);
        assertDoesNotThrow(()->ct1.enterMedicineGuidelines(new String[]{"Guideline1","guideline2"}));

        assertThrows(IncorrectEndingDateException.class,()->ct1.enterTreatmentEndingDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/1999")));


    }

    @DisplayName("enterTreatmentEndingDate but its equal at  start treatment")
    @Test
    void enterTreatmentEndingDate_1() {
        assertDoesNotThrow(()->ct1.initRevision());
        assertFalse(ct1.isFinishedPrescription);
        assertNotNull(ct1.medicalPrescription);

        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
        assertDoesNotThrow(()->ct1.selectProduct(0));
        assertNotNull(ct1.choosenProduct);
        assertDoesNotThrow(()->ct1.enterMedicineGuidelines(new String[]{"Guideline1","guideline2"}));
        assertThrows(IncorrectEndingDateException.class,()->ct1.enterTreatmentEndingDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2000")));
    }

    @DisplayName("enterTreatmentEndingDate but its incorrect format")
    @Test
    void enterTreatmentEndingDate_2() {
        assertDoesNotThrow(()->ct1.initRevision());
        assertFalse(ct1.isFinishedPrescription);
        assertNotNull(ct1.medicalPrescription);

        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
        assertDoesNotThrow(()->ct1.selectProduct(0));
        assertNotNull(ct1.choosenProduct);
        assertDoesNotThrow(()->ct1.enterMedicineGuidelines(new String[]{"Guideline1","guideline2"}));
        assertThrows(IncorrectEndingDateException.class,()->ct1.enterTreatmentEndingDate(null));
    }

    @DisplayName("enterTreatmentEndingDate in correct format")
    @Test
    void enterTreatmentEndingDate_3() {
        assertDoesNotThrow(()->ct1.initRevision());
        assertFalse(ct1.isFinishedPrescription);
        assertNotNull(ct1.medicalPrescription);

        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
        assertDoesNotThrow(()->ct1.selectProduct(0));
        assertNotNull(ct1.choosenProduct);
        assertDoesNotThrow(()->ct1.enterMedicineGuidelines(new String[]{"Guideline1","guideline2"}));
        assertThrows(IncorrectEndingDateException.class,()->ct1.enterTreatmentEndingDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2021")));
    }
    @DisplayName("Sending e-prescription but it's not completed")



    @Test
    void sendePrescription() {
        assertThrows(NotCompletedMedicalPrescription.class,()->ct1.sendePrescription());
        assertNull(ct1.medicalPrescription);
    }
    @DisplayName("Sending e-prescription ")
    @Test
    void sendePrescription_1() {
        assertDoesNotThrow(()->ct1.initRevision());
        assertFalse(ct1.isFinishedPrescription);
        assertNotNull(ct1.medicalPrescription);

        assertDoesNotThrow(()->ct1.searchForProducts("muscular"));
        assertNotNull(ct1.list_of_products);
        assertDoesNotThrow(()->ct1.selectProduct(0));
        assertNotNull(ct1.choosenProduct);
        assertDoesNotThrow(()->ct1.enterMedicineGuidelines(new String[]{"Guideline1","guideline2"}));
        assertThrows(IncorrectEndingDateException.class,()->ct1.enterTreatmentEndingDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2021")));

        assertDoesNotThrow(()->ct1.sendePrescription());
        assertNotNull(ct1.medicalPrescription);
    }


    private  static class ScheduledVisitAgendaImpl implements ScheduledVisitAgenda {
        public HealthCardID visit1 = new HealthCardID("BBBBBBBBQR784518965123478958");


        private ScheduledVisitAgendaImpl() throws HealthCardException {
        }


        @Override
        public HealthCardID getHealthCardID() throws HealthCardException {
            return visit1;
        }
    }

    private static class HNS implements HealthNationalService{
        private static String STARTING_FAKE_TREATMENT_DATE="23/3/2019";
        private static String ENDING_FAKE_TREATMENT_DATE="23/3/2020";
        private MedicalPrescription medicalPrescription = generate_Fake_medical_presc();
        private final HashMap<String, ArrayList<ProductSpecification>> productsByKw = generate_Fake_products_indexed_by_KW();
        private ArrayList<ProductSpecification> session_selected;

        // genearar fakes
        private HashMap<String, ArrayList<ProductSpecification>> generate_Fake_products_indexed_by_KW() throws ProductNotInPrescription {
            ProductID pd1 = new ProductID("0001");//frenadol
            ProductID pd2 = new ProductID("0002");;//migrastick
            ProductID pd3 = new ProductID("0003");;//Efergalan
            ProductID pd4 = new ProductID("0004");;//Efergalan Forte
            ProductID pd5 = new ProductID("0005");;//Ibuprofeno
            ProductID pd6 = new ProductID("0006");;//Gelocatil
            ProductID pd7 = new ProductID("0007");;//Paracetamol
            ProductSpecification ps1 = new ProductSpecification(pd1,"descripció Frensdol",new BigDecimal("10.1"));//frenadol  ps1
            ProductSpecification ps2 = new ProductSpecification(pd2,"descripció migrastick",new BigDecimal("20.1"));//migrastick ps2
            ProductSpecification ps3 = new ProductSpecification(pd3,"descripció Efergalan",new BigDecimal("30.1"));//Efergalan  ps3
            ProductSpecification ps4 = new ProductSpecification(pd4,"descripció Efergalan Forte",new BigDecimal("40.1"));//Efergalan Forte ps4
            ProductSpecification ps5 = new ProductSpecification(pd5,"descripció Ibuprofeno",new BigDecimal("50.1"));//Ibuprofeno ps5
            ProductSpecification ps6 = new ProductSpecification(pd6,"descripció Gelocatil",new BigDecimal("60.1"));//Gelocatil ps6
            ProductSpecification ps7 = new ProductSpecification(pd7,"descripció Paracetamol",new BigDecimal("70.1"));//Paracetamol ps7

            HashMap<String, ArrayList<ProductSpecification>> products_byKw =  new HashMap<>();

            products_byKw.put("maldecap",new ArrayList<>(List.of(ps1,ps2)));
            products_byKw.put("refredat",new ArrayList<>(List.of(ps3,ps4,ps5)));
            products_byKw.put("muscular",new ArrayList<>(List.of(ps5,ps6,ps7)));

            return products_byKw;
        }
        private MedicalPrescription generate_Fake_medical_presc() throws ProductNotInPrescription, IncorrectTakingGuidelinesException, eSignatureException, HealthCardException, ParseException {
            MedicalPrescription mp = new MedicalPrescription();

            mp.addLine(new ProductID("1234"),new String[]{"Instruccions Acisteilina"});
            mp.addLine(new ProductID("12345"),new String[]{"Instruccions frenadol"});

            mp.setPrescDate(new SimpleDateFormat("dd/MM/yyyy").parse(STARTING_FAKE_TREATMENT_DATE));
            mp.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(ENDING_FAKE_TREATMENT_DATE));

            mp.seteSign(new DigitalSignature("Dr. Ferran"));
            mp.setHcID(new HealthCardID("BBBBBBBBQR111111111111111111"));
            mp.setPrescCode(11223344);
            //System.out.println(mp.toString());

            return mp;
        }



        public HNS() throws ProductNotInPrescription, IncorrectTakingGuidelinesException, eSignatureException, HealthCardException, ParseException {

        }

        @Override
        public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
            return this.medicalPrescription;
        }

        @Override
        public List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException {

            if (this.productsByKw.containsKey(keyWord)){

                this.session_selected = this.productsByKw.get(keyWord);
                return this.productsByKw.get(keyWord);
            }
            throw new AnyKeyWordMedicineException("NOT FOUND");

        }

        @Override
        public ProductSpecification getProcuductSpecific(int opt) throws AnyMedicineSearchException, ConnectException {
            if (0<=opt && opt <this.session_selected.size()){
                return this.session_selected.get(opt);
            }
            throw new AnyMedicineSearchException("No selection");
        }

        @Override
        public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescription, eSignatureException, NotCompletedMedicalPrescription {
            return ePresc;
        }
    }
}