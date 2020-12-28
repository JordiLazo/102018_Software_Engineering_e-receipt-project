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
    private final int HEALTHCARD_SIZE_ID=28;
    private final String PREFIX="BBBBBBBB";

    public HealthCardID(String code) throws HealthCardException {
        this.personalID = this.checkPersonalID(code);
    }

    public String checkPersonalID(String code) throws HealthCardException {
        if (code != null){
            code = code.toUpperCase();
            if( (code.length() == HEALTHCARD_SIZE_ID && code.startsWith(PREFIX) && code.substring(PREFIX.length()-1,PREFIX.length()+1).matches("[A-Z]*") && code.substring(PREFIX.length()+2,HEALTHCARD_SIZE_ID-1).matches("[0-9]+"))  ){
               return code;
            }else {
                throw new HealthCardException("Invalid HealtCard Id format");
            }
        }
        throw new HealthCardException("Error null code");


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
