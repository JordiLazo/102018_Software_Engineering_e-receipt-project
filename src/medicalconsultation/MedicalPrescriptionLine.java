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
            if (prodID != null && instruc.length!=0) {
                map.put(prodID,instruc);
            }else {
                throw new IncorrectTakingGuidelinesException("Cannot add: Incorrect Format");
            }

        }
    }
    public void modifyLine(ProductID prodID,String[] instruc) throws ProductNotInPrescription, IncorrectTakingGuidelinesException{
        if(map.containsKey(prodID)){
            if (prodID != null && instruc.length!=0) {
                map.put(prodID,instruc);
            }else {
                throw new IncorrectTakingGuidelinesException("Cannot modify: Incorrect Format");
            }
        }
        throw new ProductNotInPrescription("Cannot modify: Not found product ");
    }
    public void removeLine(ProductID prodID) throws ProductNotInPrescription{
        if(map.containsKey(prodID)){
            map.remove(prodID);
        }else{
            throw new ProductNotInPrescription("Cannot remove non existent product ");
        }
    }

}
/*
Prescipció
{
codi1:<>
codi2:<>

}

 */