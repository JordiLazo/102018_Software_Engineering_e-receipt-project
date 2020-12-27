package data;

import exceptions.NullNotDefinedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

final public class HealthCardID{
    private final String personalID;

    public HealthCardID(String code) throws NullNotDefinedException {
        this.personalID = this.checkPersonalID(code);
    }

    private String checkPersonalID(String code) throws NullNotDefinedException {
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

    public static void main(String[] args) throws NullNotDefinedException, ParseException {
        Date n= new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20" );
        System.out.println(n);

    }
}
