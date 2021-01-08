package medicalconsultation;

import data.*;
import exceptions.*;
import java.util.HashMap;

public class MedicalPrescriptionLine {
    public final HashMap<ProductID, String[]> map;

    public MedicalPrescriptionLine() {
        this.map = new HashMap<>();
    }

    public void addLine(ProductID prodID,String[] instruc)throws IncorrectTakingGuidelinesException {
        if(!map.containsKey(prodID)){
            if (prodID != null && instruc.length!=0 ) {
                map.put(prodID,instruc);
            }else {
                throw new IncorrectTakingGuidelinesException("Error in MedicalPrescriptionLine class: Can not add line");
            }
        }
    }
    public void modifyLine(ProductID prodID,String[] instruc) throws ProductNotInPrescription, IncorrectTakingGuidelinesException{
        if(map.containsKey(prodID)){
            if (prodID != null && instruc.length!=0) {
                map.put(prodID,instruc);
            }else {
                throw new IncorrectTakingGuidelinesException("Error in MedicalPrescriptionLine class: Can not modify line (invalid format)");
            }
        }
        throw new ProductNotInPrescription("Error in MedicalPrescriptionLine class: Can not modify line (invalid product)");
    }
    public void removeLine(ProductID prodID) throws ProductNotInPrescription{
        if(map.containsKey(prodID)){
            map.remove(prodID);
        }else{
            throw new ProductNotInPrescription("Error in MedicalPrescriptionLine class: Can not remove line (invalid product)");
        }
    }

}