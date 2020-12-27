package data;

final public class HealthCardID {
    private final String personalID;

    public HealthCardID(String code) {
        this.personalID = code;
    }
    public String getPersonalID(){
        return personalID;
    }
    @Override
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
    @Override
    public int hashCode(){
        return personalID.hashCode();
    }

    @Override
    public String toString(){
        return "HealthCardID{" + "personal code='" + personalID + '\'' + '}';
    }
}
