package data;

final public class HealthCardID {
    private final String personalID;

    public HealthCardID(String code) {
        this.personalID = code;
    }
    public String getPersonalID(){
        return personalID;
    }

    public boolean equals(Object o ){
        if (this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        HealthCardID hcardID = (HealthCardID) o;
        return personalID.equals(hcardID.personalID);
    }
    public int hashCode(){
        return personalID.hashCode();
    }

    public String toString(){
        return "HealthCardID{" + "personal code='" + personalID + '\'' + '}';
    }
}
