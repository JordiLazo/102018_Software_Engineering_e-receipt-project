package exceptions;

public class ProductNotInPrescription extends Exception {
    public ProductNotInPrescription(String message) {
        super(message);
    }
}
