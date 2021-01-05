package data;
import exceptions.eSignatureException;

import java.util.Arrays;

public class DigitalSignature {

    private final byte [] eSignature ;

    public DigitalSignature (String medicalSignature) throws eSignatureException {
        this.eSignature = this.checkDigitalSignature(medicalSignature); // prevents getting bytes from null
    }

    public byte[] getDigitalSignature() {
        return this.eSignature;
    }

    public byte[] checkDigitalSignature(String medicalSignature) throws eSignatureException {
        if (medicalSignature == null){
            throw new eSignatureException("Invalid signature");
        }
        //we sure medicalSignature not null
        return medicalSignature.getBytes();
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

    public static void main(String[] args) throws eSignatureException {
        DigitalSignature d1 = new DigitalSignature("Dr.Ferran");
        System.out.println(d1.getDigitalSignature());
    }

}
