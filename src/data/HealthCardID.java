package data;

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

    public static void main(String[] args) throws NullNotDefinedException {
        HealthCardID test = new HealthCardID("123");
        HealthCardID test2 = new HealthCardID("1243");
        System.out.println(test.toString());
        System.out.println(test.equals(test2));

    }
}
