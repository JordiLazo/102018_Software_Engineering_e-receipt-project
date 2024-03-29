package medicalconsultation;

import data.ProductID;
import exceptions.ProductNotInPrescription;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductSpecificationTest {
    ProductID p1;
    BigDecimal price;
    @BeforeEach
    void setUp() throws ProductNotInPrescription{
        p1 = new ProductID("123");
        price = new BigDecimal("10.20");
    }

    @DisplayName("Check if the Product Specification is correct")
    @Test
    void checkProductSpecification(){
        assertThrows(ProductNotInPrescription.class,()-> new ProductSpecification(p1,null,price));
        assertThrows(ProductNotInPrescription.class,()-> new ProductSpecification(null,"medicine",price));
        assertThrows(ProductNotInPrescription.class,()-> new ProductSpecification(p1,"medicine",null));
    }

    @DisplayName("Check if the description is empty and price null")
    @Test
    void checkProductSpecification_empty(){
        assertThrows(ProductNotInPrescription.class,()-> new ProductSpecification(p1,"",null));
    }

}