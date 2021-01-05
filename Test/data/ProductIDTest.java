package data;

import exceptions.ProductNotInPrescription;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductIDTest {
    ProductID p1,p2,p3;
    @BeforeEach
    void setUp()throws ProductNotInPrescription {
        p1 = new ProductID("123456");
        p2 = new ProductID("123456");
        p3 = new ProductID("123");
    }

    @Test
    @DisplayName("Check if the Product ID is null or empty")
    void checkUPCcode(){
        assertThrows(ProductNotInPrescription.class,()-> new ProductID(null));
        assertThrows(ProductNotInPrescription.class,()-> new ProductID(""));
    }

    @Test
    @DisplayName("Check if two Product ID are equals")
    void compareUPCcode(){
        assertEquals(p1,p2);
    }
    @Test
    @DisplayName("Check if two Product ID are diferents")
    void checkDiferentUPCcode(){
        assertNotEquals(p1,p3);
    }
}