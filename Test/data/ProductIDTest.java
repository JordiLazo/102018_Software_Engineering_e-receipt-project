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

    @DisplayName("Check if the Product ID is null, empty or is an space")
    @Test
    void checkUPCcode(){
        assertThrows(ProductNotInPrescription.class,()-> new ProductID(null));
        assertThrows(ProductNotInPrescription.class,()-> new ProductID(""));
        assertThrows(ProductNotInPrescription.class,()-> new ProductID(" "));
    }

    @DisplayName("Check if two Product ID are equals")
    @Test
    void compareUPCcode(){
        assertEquals(p1,p2);
    }

    @DisplayName("Check if two Product ID are diferents")
    @Test
    void checkDiferentsUPCcode(){
        assertNotEquals(p1,p3);
    }
}