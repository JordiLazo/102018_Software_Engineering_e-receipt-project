package data;
import exceptions.eSignatureException;

import java.util.Arrays;

public class DigitalSignature {

    private byte [] eSignature ;

    public DigitalSignature (String medicalSignature){
        this.eSignature = medicalSignature.getBytes();
    }

    public byte[] geteSignature() {
        return eSignature;
    }
    public String checkDigitalSignature(byte [] medicalSignature) throws eSignatureException {
        if (medicalSignature != null){
        }
        throw new eSignatureException("Invalid signature");
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
        return "DigitalSignature{" +
                "DigitalSignature='" + Arrays.toString(eSignature) + '\'' +
                '}';
    }

    public static void main(String[] args) {
        DigitalSignature x = new DigitalSignature("iola");
        System.out.println(x.toString());
    }


}
