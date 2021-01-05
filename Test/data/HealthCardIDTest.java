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

    @Test
    @DisplayName("Create a card with the correct format")
    void getPersonalIDTest(){
        assertEquals("BBBBBBBBQR784518965123478958",hc1.getPersonalID());
    }

    @Test
    @DisplayName("Create a card with the wrong format")
    void checkPersonalID(){
        assertThrows(HealthCardException.class,()->new HealthCardID("ABBBBBBBQR784518965123478958"));
        assertThrows(HealthCardException.class,()->new HealthCardID("BBBBBBBBQ2784518965123478958"));
        assertThrows(HealthCardException.class,()->new HealthCardID("BBBBBBBBQRTT4518965123478958"));
        assertThrows(HealthCardException.class,()->new HealthCardID("BBBBBBBBQR28451896512347895P"));
        assertThrows(HealthCardException.class,()->new HealthCardID("BBBBBBBBQR2845189651234789599"));
        assertThrows(HealthCardException.class,()->new HealthCardID("BBBBBBBBQRZZZZZZ9651234789599"));
    }

    @Test
    @DisplayName("Create a card with null format")
    void checkNullPersonalID(){
        assertThrows(HealthCardException.class,()->new HealthCardID(null));
    }
}
