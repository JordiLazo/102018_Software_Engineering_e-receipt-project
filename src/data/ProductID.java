package data;

import exceptions.ProductNotInPrescription;

public class ProductID {

    private String UPCcode;

    public ProductID (String UPC){
        this.UPCcode = UPC;
    }

    public String checkUPCcode(String productcode) throws ProductNotInPrescription {
        if (productcode != null){
            return productcode;
        }
        throw new ProductNotInPrescription("Invalid product");
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
