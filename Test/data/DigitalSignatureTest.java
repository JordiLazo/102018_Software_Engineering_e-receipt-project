package data;

import exceptions.eSignatureException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class DigitalSignatureTest implements TestInterface {
    DigitalSignature d1, d2,d3;

    @BeforeEach
    void setup() throws eSignatureException {
        d1 = new DigitalSignature("iola");
        d2 = new DigitalSignature("iola");
        d3 = new DigitalSignature(null);
    }
    @Test
    @DisplayName("Check if two Digital Signatures are the same")
    @Override
    public void checkDigitalSignature() {
        assertArrayEquals(d1.geteSignature(),d2.geteSignature());
    }

    @Test
    @Override
    public void checkDiferentDigitalSignature() {
        assertThrows(eSignatureException.class,()-> new DigitalSignature(null));

    }

    @Override
    public HealthCardID getPersonalIDTest() {
        return null;
    }
}
