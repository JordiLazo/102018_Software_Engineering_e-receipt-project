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
    @DisplayName("Check if ")
    void geteSignature(){
        byte[] test= "Dr.Ferran".getBytes();
        byte[] test2= "Dr.Ferr".getBytes();
        //assertEquals(Arrays.toString(d1.geteSignature()), Arrays.toString(d2.geteSignature()));
        //assertFalse(Arrays.equals(d1.geteSignature(), d4.geteSignature()));
    }
}
