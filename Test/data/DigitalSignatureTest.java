package data;

import exceptions.eSignatureException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class DigitalSignatureTest {
    DigitalSignature d1,d2;

    @BeforeEach
    void setup() throws eSignatureException {
        d1 = new DigitalSignature("iola");
        d2 = new DigitalSignature("iola");
    }
    @DisplayName("Creating a digital signature with correct format")
    @Test
    void getDigitalSignatureBytes(){
        assertArrayEquals(d1,d2);
    }


}