package data;

import java.util.Arrays;

public class DigitalSignature {

    private byte [] eSignature = "string".getBytes();

    public DigitalSignature (byte [] medicalSignature){
        this.eSignature = medicalSignature;
    }

    public byte[] geteSignature() {
        return eSignature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DigitalSignature medicalSignature = (DigitalSignature) o;
        return Arrays.equals(eSignature, medicalSignature.eSignature);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(eSignature);
    }

    @Override
    public String toString() {
        return "ProductID{" +
                "productID='" + Arrays.toString(eSignature) + '\'' +
                '}';
    }


}
