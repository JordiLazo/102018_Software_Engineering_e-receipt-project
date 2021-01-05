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
        //d3 = new DigitalSignature(null); fails and raise exception, then it doesn't creates a digital signature just it stops execution
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
        //assertNull(d3); due to D3 has stopped execution, this assertion is never performed
    }

    @Test
    @DisplayName("Check if 2 arrays are equals")
    void geteSignature(){
        byte[] expected1= "Dr.Ferran".getBytes();
        byte[] expected2= "Dr.Ferran".getBytes();
        byte[] expected4= "HOLA".getBytes();

        assertArrayEquals(expected1,d1.geteSignature());
        assertArrayEquals(expected2,d2.geteSignature());
        assertArrayEquals(expected4,d4.geteSignature());

        //byte[] s = "1".getBytes();
        //byte[] t = "1".getBytes();
        //byte[] w = "1".getBytes();
        //assertArrayEquals(s,t);
        //assertArrayEquals(test, test2);
        //assertFalse(Arrays.equals(test, test2));
    }
}
