package data;

import java.util.Objects;

public class ProductID {

    private String productID;

    public ProductID (String UPC){
        this.productID= UPC;
    }

    public String getProductID() {
        return productID;
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
        return productID.equals(productID_1.productID);
    }

    @Override
    public int hashCode() {
        return productID.hashCode();
    }

    @Override
    public String toString() {
        return "ProductID{" +
                "productID='" + productID + '\'' +
                '}';
    }
}
