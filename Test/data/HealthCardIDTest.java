package data;

import exceptions.HealthCardException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class HealthCardIDTest {
    HealthCardID hc1;
    @BeforeEach
    void setup() throws HealthCardException{
        hc1 = new HealthCardID("BBBBBBBBQR784518965123478958");
    }
    @DisplayName("Creating card with correct format")
    @Test
    void getPersonalIDTest(){
        assertEquals("BBBBBBBBQR784518965123478958",hc1.getPersonalID());
    }



    @DisplayName("Creating card with wrong format")
    @Test
    void creating_hc_error_format(){
        assertThrows(HealthCardException.class,()->new HealthCardID("ABBBBBBBQR784518965123478958"));
        assertThrows(HealthCardException.class,()->new HealthCardID("ABBBBBBB1278451896512347895P"));
    }
}
