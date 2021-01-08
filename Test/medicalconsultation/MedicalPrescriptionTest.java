package medicalconsultation;

import data.ProductID;
import exceptions.IncorrectTakingGuidelinesException;
import exceptions.ProductNotInPrescription;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class MedicalPrescriptionTest {
    MedicalPrescription mp1, mp2;
    ProductID p1,p2,p3;

    @BeforeEach
    void setUp() throws ProductNotInPrescription, IncorrectTakingGuidelinesException {
        mp1 = new MedicalPrescription();
        mp2 = new MedicalPrescription();
        p1 = new ProductID("123");
        p2 = new ProductID("123");
        p3 = new ProductID("111");
        mp2.addLine(p1,new String[]{"Today"});
    }
    @Test
    @DisplayName("Check if the method addline is possible to do")
    void checkAddline(){
        assertThrows(IncorrectTakingGuidelinesException.class,()-> mp1.addLine(p1,new String[]{}));
        assertThrows(IncorrectTakingGuidelinesException.class,()-> mp1.addLine(p1,null));
        assertDoesNotThrow(()-> mp1.addLine(p1,new String[]{" "}));
        assertDoesNotThrow(()-> mp1.addLine(p1,new String[]{""}));
        assertThrows(IncorrectTakingGuidelinesException.class,()-> mp1.addLine(null,new String[]{""}));

    }

    @Test
    @DisplayName("Check if the method modifyline is possible to do")
    void checkModifyline(){
        assertThrows(IncorrectTakingGuidelinesException.class,()-> mp2.modifyLine(p2,new String[]{}));
        assertThrows(ProductNotInPrescription.class,()->mp2.modifyLine(p2,new String[]{" "}));
        assertThrows(ProductNotInPrescription.class,()->mp2.modifyLine(p2,new String[]{""}));
        assertThrows(IncorrectTakingGuidelinesException.class,()->mp2.modifyLine(p2,null));
    }

    @Test
    @DisplayName("Check if the removeline method is possible to do")
    void checkRemoveline(){
        assertThrows(ProductNotInPrescription.class,()-> mp2.removeLine(p3));
    }

}