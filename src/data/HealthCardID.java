package data;

import exceptions.HealthCardException;
import exceptions.NullNotDefinedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

final public class HealthCardID{
    private final String personalID;

    public HealthCardID(String code) throws NullNotDefinedException, HealthCardException {
        this.personalID = this.checkPersonalID(code);
    }

    private String checkPersonalID(String code) throws NullNotDefinedException, HealthCardException {
        code = code.toUpperCase();
        String newcode1 = code.substring(8,10);
        String newcode2 = code.substring(10,28);
        System.out.println(code);
        System.out.println(newcode1);
        System.out.println(newcode2);
        if(code.length() != 28){
            throw new HealthCardException("Invalid HealthCardID. Enter 28 digits.");
        }
        if (!code.startsWith("BBBBBBBB")){
            throw new HealthCardException("Invalid HealthCardID. Wrong 8 digits");
        }
        if (!newcode1.matches("[A-Z]*")){
            throw new HealthCardException("Invalid 2 letters");
        }
        if (!newcode2.matches("[0-9]+")){
            throw new HealthCardException("Invalid 18 digits");
        }
        if (code != null){
            return code;
        }
        throw new NullNotDefinedException("missatge");
    }

    public String getPersonalID() {
        return personalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HealthCardID hcardID = (HealthCardID) o;
        return personalID.equals(hcardID.personalID);
    }

    @Override
    public int hashCode() {
        return personalID.hashCode();
    }

    @Override
    public String toString() {
        if(this.personalID != null){
            return "HealthCardID {" + "personal code='" + personalID + '\'' + '}';
        }
        return "";
    }

    public static void main(String[] args) throws NullNotDefinedException, ParseException, HealthCardException {
        Date n= new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20" );
        System.out.println(n);
        HealthCardID z = new HealthCardID("BBBBBBBBPR148597807024001012");
        System.out.println(z);
    }
}
