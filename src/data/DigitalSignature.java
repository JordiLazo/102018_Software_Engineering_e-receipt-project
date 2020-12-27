package data;

import java.util.Arrays;

public class DigitalSignature {

    private byte [] eSignature ;

    public DigitalSignature (String medicalSignature){
        // jlazo1223
        // [\0x23,\0x34,\0xFF,....\0x00]
        this.eSignature = medicalSignature.getBytes();
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
