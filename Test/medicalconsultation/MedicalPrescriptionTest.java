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
        p2 = new ProductID("1234");
        p3 = new ProductID("111");
        mp2.addLine(p1,new String[]{"Today"});
    }

    @DisplayName("Check if the method addline is possible to do")
    @Test
    void checkAddline(){
        assertThrows(IncorrectTakingGuidelinesException.class,()-> mp1.addLine(p1,new String[]{}));
        assertThrows(IncorrectTakingGuidelinesException.class,()-> mp1.addLine(p1,null));
        assertDoesNotThrow(()-> mp1.addLine(p1,new String[]{" "}));
        assertDoesNotThrow(()-> mp1.addLine(p1,new String[]{""}));
        assertThrows(IncorrectTakingGuidelinesException.class,()-> mp1.addLine(null,new String[]{""}));

    }

    @DisplayName("Check if the method modifyline is possible to do")
    @Test
    void checkModifyLine(){
        assertThrows(ProductNotInPrescription.class,()-> mp2.modifyLine(p2,new String[]{}));
        assertThrows(ProductNotInPrescription.class,()->mp2.modifyLine(p2,new String[]{" "}));
        assertThrows(ProductNotInPrescription.class,()->mp2.modifyLine(p2,new String[]{""}));
        assertThrows(ProductNotInPrescription.class,()->mp2.modifyLine(p2,null));
    }

    @DisplayName("Check if the removeline method is possible to do")
    @Test
    void checkRemoveLine(){
        assertThrows(ProductNotInPrescription.class,()-> mp2.removeLine(p3));
    }

    @DisplayName("Check if the previewMedicalPrescriptionLines is equal to the number of addLine added")
    @Test
    void checkPreviewMedicalPrescriptionLines() throws IncorrectTakingGuidelinesException {
        assertDoesNotThrow(()->mp2.addLine(p2,new String[]{"Today"}));
        assertDoesNotThrow(()->mp2.addLine(p3,new String[]{"Today"}));
        MedicalPrescriptionLine line = new MedicalPrescriptionLine();
        line.addLine(p1,new String[]{"Today"});
        line.addLine(p2,new String[]{"Today"});
        line.addLine(p3,new String[]{"Today"});
        assertEquals(line,mp2.getMedicalPrescriptionLine());
    }

}