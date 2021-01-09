package medicalconsultation;

import data.ProductID;
import exceptions.ProductNotInPrescription;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class TakingGuidelineTest {
    TakingGuideline tg1;

    @BeforeEach
    void setUP (){
    tg1 = new TakingGuideline(dayMoment.AFTERBREAKFAST,(float) 1.1,"line",(float) 1.1,(float) 1.1,FqUnit.DAY);
    }

    @Test
    void getdMoment() {
        assertEquals(dayMoment.AFTERBREAKFAST, tg1.getdMoment());
    }

    @Test
    void getDuration() {
        assertEquals((float) 1.1, tg1.getDuration());
    }

    @Test
    void getInstructions() {
        assertEquals("line", tg1.getInstructions());
    }

    @Test
    void getPosology() {
        assertEquals(new Posology((float) 1.1,(float) 1.1,FqUnit.DAY), tg1.getPosology());
    }

    @Test
    void setdMoment() {
        dayMoment before = tg1.getdMoment();
        tg1.setdMoment(dayMoment.AFTERDINNER);
        assertNotEquals(before, tg1.getdMoment());
    }

    @Test
    void setDuration() {
        float before =  tg1.getDuration();
        tg1.setDuration((float) 2.2);
        assertNotEquals(before, tg1.getDuration());
    }



    @Test
    void setInstructions() {
        String before = tg1.getInstructions();
        tg1.setInstructions("different line");
        assertNotEquals(before, tg1.getInstructions());
    }


    @Test
    void setPosology() {
        Posology before = tg1.getPosology();
        tg1.setPosology(new Posology((float) 1.1,(float) 1.1,FqUnit.HOUR));
        assertNotEquals(new Posology((float) 1.1,(float) 1.1,FqUnit.DAY), tg1.getPosology());
    }
}