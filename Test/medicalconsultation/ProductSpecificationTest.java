package medicalconsultation;

import data.ProductID;
import exceptions.IncorrectTakingGuidelinesException;
import exceptions.ProductNotInPrescription;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductSpecificationTest {
    ProductSpecification ps1;
    ProductID p1;
    BigDecimal price;
    @BeforeEach
    void setUp() throws ProductNotInPrescription{
        p1 = new ProductID("123");
        price = new BigDecimal(10.50);
        ps1 = new ProductSpecification(p1,"medicine",price);
    }

    @Test
    void checkProductSpecification(){
        assertThrows(ProductNotInPrescription.class,()-> new ProductSpecification(p1,null,price));
    }


}