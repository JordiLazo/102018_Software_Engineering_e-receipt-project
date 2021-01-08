package data;

import exceptions.ProductNotInPrescription;

public class ProductID {

    private final String UPCcode;

    public ProductID (String UPC) throws ProductNotInPrescription {
        this.UPCcode = this.checkUPCcode(UPC);
    }

    public String checkUPCcode(String productcode) throws ProductNotInPrescription {
        if (productcode != null && !productcode.equals("") && !productcode.equals(" ")){
            return productcode;
        }
        throw new ProductNotInPrescription("Error in ProductID class: Invalid product");
    }

    public String getUPCcode() {
        return UPCcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductID productID_1 = (ProductID) o;
        return UPCcode.equals(productID_1.UPCcode);
    }

    @Override
    public int hashCode() {
        return UPCcode.hashCode();
    }

    @Override
    public String toString() {
        return "ProductID{" +
                "productID='" + UPCcode + '\'' +
                '}';
    }
}
