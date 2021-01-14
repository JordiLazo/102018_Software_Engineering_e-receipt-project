package medicalconsultation;

import data.*;
import exceptions.*;

import java.util.*;

public class MedicalPrescriptionLine {
    public final HashMap<ProductID, String[]> map;

    public MedicalPrescriptionLine() {
        this.map = new HashMap<>();
    }

    public void addLine(ProductID prodID,String[] instruc)throws IncorrectTakingGuidelinesException {
        if(!map.containsKey(prodID)){
            if (prodID != null && instruc != null && instruc.length!=0 ) {
                map.put(prodID,instruc);
            }else {
                throw new IncorrectTakingGuidelinesException("Error in MedicalPrescriptionLine class: Can not add line");
            }
        }
    }
    public void modifyLine(ProductID prodID,String[] instruc) throws ProductNotInPrescription, IncorrectTakingGuidelinesException{
        if(map.containsKey(prodID)){
            if (prodID != null && instruc != null && instruc.length!=0) {
                map.put(prodID,instruc);
            }else {
                throw new IncorrectTakingGuidelinesException("Error in MedicalPrescriptionLine class: Can not modify line (invalid format)");
            }
        }
        throw new ProductNotInPrescription("Error in MedicalPrescriptionLine class: Can not modify line (invalid product)");
    }
    public void removeLine(ProductID prodID) throws ProductNotInPrescription{
        if(prodID != null && map.containsKey(prodID)){
            map.remove(prodID);

        }else{
            throw new ProductNotInPrescription("Error in MedicalPrescriptionLine class: Can not remove line (invalid product)");
        }
    }
    public Set<HashMap<String, String>> items() {

        Set<HashMap<String, String>> items = new HashSet<>();
        for (ProductID key: this.map.keySet()) {
            HashMap<String, String> a = new HashMap<>();
            a.put(key.getUPCcode(), Arrays.toString(this.map.get(key)));
            items.add(a);
        }
        return items;
    }

    @Override
    public String toString() {
        return items().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalPrescriptionLine)) return false;
        MedicalPrescriptionLine line = (MedicalPrescriptionLine) o;
        return this.items().equals(line.items());
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }
}