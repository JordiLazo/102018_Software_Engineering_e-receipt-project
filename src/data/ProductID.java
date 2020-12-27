package data;

public class ProductID {

    private String UPC_code;

    public ProductID (String UPC){

        this.UPC_code = UPC;
    }

    public String getUPC_code() {
        return UPC_code;
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
        return UPC_code.equals(productID_1.UPC_code);
    }

    @Override
    public int hashCode() {
        return UPC_code.hashCode();
    }

    @Override
    public String toString() {
        return "ProductID{" +
                "productID='" + UPC_code + '\'' +
                '}';
    }
}
