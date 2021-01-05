package data;

import exceptions.eSignatureException;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


class DigitalSignatureTest {
    DigitalSignature d1, d2, d3, d4;

    @BeforeEach
    void setup() throws eSignatureException {
        d1 = new DigitalSignature("Dr.Ferran");
        d2 = new DigitalSignature("Dr.Ferran");
        d3 = new DigitalSignature(null);
        d4 = new DigitalSignature("HOLA");
    }

    @Test
    @DisplayName("Check if two Digital Signatures have the same bytes")
    void checkBytesDigitalSignature(){
        assertArrayEquals(d1.geteSignature(),d2.geteSignature());
    }

    @Test
    @DisplayName("Check if Digital Signature is null")
    void checkDigitalSignature() {
        assertThrows(eSignatureException.class,()-> new DigitalSignature(null));
        assertNull(d3);
    }

    @Test
    @DisplayName("Check if 2 arrays are equals")
    void geteSignature(){
        byte[] test= "Dr.Ferran".getBytes();
        byte[] test2= "Dr.Ferran".getBytes();

        byte[] s = "1".getBytes();
        byte[] t = "1".getBytes();
        byte[] w = "1".getBytes();
        assertArrayEquals(s,t);
        assertArrayEquals(test, test2);
        //assertFalse(Arrays.equals(test, test2));
    }
}
