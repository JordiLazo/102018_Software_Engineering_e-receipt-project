package data;

import exceptions.eSignatureException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class DigitalSignatureTest {
    DigitalSignature d1, d2, d4;

    @BeforeEach
    void setUp() throws eSignatureException {
        d1 = new DigitalSignature("Dr.Ferran");
        d2 = new DigitalSignature("Dr.Ferran");
        d4 = new DigitalSignature("HOLA");
    }

    @DisplayName("Check if two Digital Signatures instances are the same")
    @Test
    void checkBytesDigitalSignature(){
        assertArrayEquals(d1.getDigitalSignature(),d2.getDigitalSignature());
    }

    @DisplayName("Check if a Digital Signature is null or empty")
    @Test
    void checkDigitalSignature() {
        assertThrows(eSignatureException.class,()-> new DigitalSignature(null));
        assertThrows(eSignatureException.class,()-> new DigitalSignature(""));
    }

    @DisplayName("Check if an array byte equals to a Digital Signature")
    @Test
    void geteSignature(){
        byte[] expected1= "Dr.Ferran".getBytes();
        byte[] expected2= "Dr.Ferran".getBytes();
        byte[] expected4= "HOLA".getBytes();

        assertArrayEquals(expected1,d1.getDigitalSignature());
        assertArrayEquals(expected2,d2.getDigitalSignature());
        assertArrayEquals(expected4,d4.getDigitalSignature());
    }
}
