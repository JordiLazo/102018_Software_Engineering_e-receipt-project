package medicalconsultation;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PosologyTest {
    Posology pos1;
    @BeforeEach
    void setUp(){
            pos1 = new Posology((float) 1.1,(float) 1.1,FqUnit.DAY);
    }

    @Test
    void getDose() {
        assertEquals((float) 1.1, pos1.getDose());
    }

    @Test
    void getFreq() {
        assertEquals((float) 1.1, pos1.getFreq());
    }

    @Test
    void getFreqUnit() {
        assertEquals(FqUnit.DAY, pos1.getFreqUnit());
    }

    @Test
    void setDose() {
        float before = pos1.getDose();
        pos1.setDose((float) 2.2);
        assertNotEquals(before,pos1.getDose());
    }

    @Test
    void setFreq() {
        float before = pos1.getFreq();
        pos1.setFreq((float) 2.2);
        assertNotEquals(before,pos1.getFreq());
    }

    @Test
    void setFreqUnit() {
        FqUnit before = pos1.getFreqUnit();
        pos1.setFreqUnit((FqUnit.WEEK));
        assertNotEquals(before,pos1.getFreqUnit());
    }
}