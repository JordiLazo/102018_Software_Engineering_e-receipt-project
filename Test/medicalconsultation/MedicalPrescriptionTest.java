package medicalconsultation;

import data.ProductID;
import exceptions.IncorrectTakingGuidelinesException;
import exceptions.ProductNotInPrescription;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class MedicalPrescriptionTest {
    MedicalPrescription map1,map2;
    ProductID p1,p2,p3;

    @BeforeEach
    void setUp() throws ProductNotInPrescription, IncorrectTakingGuidelinesException {
        map1 = new MedicalPrescription();
        map2 = new MedicalPrescription();
        p1 = new ProductID("123");
        p2 = new ProductID("123");
        p3 = new ProductID("111");
        map2.addLine(p1,new String[]{"Today"});
    }
    @Test
    @DisplayName("Check if the method addline is null, empty")
    void checkAddline(){
        assertThrows(IncorrectTakingGuidelinesException.class,()-> map1.addLine(p1,new String[]{}));
        //assertThrows(IncorrectTakingGuidelinesException.class,()-> map1.addLine(p1,new String[]{null}));
        //assertThrows(IncorrectTakingGuidelinesException.class,()-> map1.addLine(p1,new String[]{" "}));
        //assertThrows(IncorrectTakingGuidelinesException.class,()-> map1.addLine(p1,new String[]{""}));

    }

    @Test
    @DisplayName("Check if the method modifyline is possible to do")
    void checkModifyline(){
        assertThrows(IncorrectTakingGuidelinesException.class,()->map2.modifyLine(p2,new String[]{}));
        //assertThrows(IncorrectTakingGuidelinesException.class,()->map2.modifyLine(p2,new String[]{" "}));
        //assertThrows(IncorrectTakingGuidelinesException.class,()->map2.modifyLine(p2,new String[]{""}));
        //assertThrows(IncorrectTakingGuidelinesException.class,()->map2.modifyLine(p2,new String[]{null}));
    }

    @Test
    @DisplayName("Check if the removeline method is possible to do")
    void checkRemoveline(){
        assertThrows(ProductNotInPrescription.class,()->map2.removeLine(p3));
    }

}