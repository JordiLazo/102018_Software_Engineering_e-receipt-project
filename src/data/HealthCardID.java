package data;

import exceptions.HealthCardException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            if(isValidFormat(code)){
               return code;
            }else {
                throw new HealthCardException("Error in HealthCardID class: Invalid HealtCardID format");
            }
        }
        throw new HealthCardException("Error in HealthCardID class: Invalid HealtCardID format (null)");
    }

    private boolean isValidFormat(String code) {
        return code.length() == HEALTHCARD_SIZE_ID && code.startsWith(PREFIX) &&
               code.substring(PREFIX.length() + 1, PREFIX.length() + 2).matches("[A-Z]*") &&
               code.substring(PREFIX.length() + 2, HEALTHCARD_SIZE_ID).matches("[0-9]+");
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
}
