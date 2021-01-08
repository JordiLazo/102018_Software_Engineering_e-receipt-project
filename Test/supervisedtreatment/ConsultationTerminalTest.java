package supervisedtreatment;


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
    ScheduledVisitAgenda sva1;
    HealthNationalService hns1;
    @BeforeEach
    void setUp() throws NotValidePrescriptionException, HealthCardException, ConnectException, IncorrectTakingGuidelinesException, ProductNotInPrescription, eSignatureException, ParseException {
        hns1 = new HNS();
        sva1 = new ScheduledVisitAgendaImpl();

        ct1 = new ConsultationTerminal();
        ct1.setHns(hns1);
        ct1.setSva(sva1);

    }

    @Test
    @DisplayName("Check if initRevision is correct")
    void checkinitRevision(){
        assertDoesNotThrow(()->ct1.initRevision());
        assertFalse(ct1.isFinishedPrescription);
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
        private MedicalPrescription medicalPrescription = generate_Fake_medical_presc();
        private final HashMap<String, ArrayList<ProductSpecification>> productsByKw = generate_Fake_products();
        private ArrayList<ProductSpecification> session_selected;

        // genearar fakes
        private HashMap<String, ArrayList<ProductSpecification>> generate_Fake_products() throws ProductNotInPrescription {
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

            /*
             * Productes del sns
             * [ maldecap ][ frenadol, migrastick]
             * [ refredat ][ Efergalan, Efergalan Forte, Ibuprofeno]
             * [ muscular ][Ibuprofeno,Gelocatil,Paracetamol]
             *
             *
             * getProductsByKW(Refredat) --> [ Efergalan, Frenadol, Ibuprofeno]
             *
             * */

            return products_byKw;
        }
        private MedicalPrescription generate_Fake_medical_presc() throws ProductNotInPrescription, IncorrectTakingGuidelinesException, eSignatureException, HealthCardException, ParseException {
            MedicalPrescription mp = new MedicalPrescription();

            mp.addLine(new ProductID("1234"),new String[]{"Instruccions Acisteilina"});
            mp.addLine(new ProductID("12345"),new String[]{"Instruccions frenadol"});

            mp.setPrescDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2019"));
            mp.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2021"));

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

            /*
            * Productes del sns
            * [ maldecap ][ frenadol, migrastick]
            * [ refredat ][ Efergalan, Frenadol, Ibuprofeno]
            * [ muscular ][Ibuprofeno,Gelocatil,Paracetamol]
            *
            *
            * getProductsByKW(Refredat) --> [ Efergalan, Frenadol, Ibuprofeno]
             *
            * */
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