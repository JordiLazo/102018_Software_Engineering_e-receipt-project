package medicalconsultation;

import java.util.Objects;

public class Posology { // A class that represents the posology of amedicine
    private float dose;
    private float freq;
    private FqUnit freqUnit;

    public Posology (float dose, float freq, FqUnit freqUnit){
        this.dose = dose;
        this.freq = freq;
        this.freqUnit = freqUnit;
    }

    public float getDose() {
        return dose;
    }

    public void setDose(float dose) {
        this.dose = dose;
    }

    public float getFreq() {
        return freq;
    }

    public void setFreq(float freq) {
        this.freq = freq;
    }

    public FqUnit getFreqUnit() {
        return freqUnit;
    }

    public void setFreqUnit(FqUnit freqUnit) {
        this.freqUnit = freqUnit;
    }
    @Override
    public String toString() {
        return "Posology{" +
                "dose=" + dose +
                ", freq=" + freq +
                ", freqUnit=" + freqUnit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posology)) return false;
        Posology posology = (Posology) o;
        return Float.compare(posology.getDose(), getDose()) == 0 && Float.compare(posology.getFreq(), getFreq()) == 0 && getFreqUnit() == posology.getFreqUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDose(), getFreq(), getFreqUnit());
    }
}
