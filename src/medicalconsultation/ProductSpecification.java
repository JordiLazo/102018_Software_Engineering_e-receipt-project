package medicalconsultation;

import data.ProductID;
import exceptions.ProductNotInPrescription;

import java.math.BigDecimal;

public class ProductSpecification {
    private String description;
    private ProductID product;
    private BigDecimal price;

    public ProductSpecification(ProductID product, String description, BigDecimal price) {
        //UPC *description y price
        this.product = product;
        this.description = description;
        this.price = price;
    }


    public String getProductID() {
        return product.getUPCcode();
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductID getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ProductSpecification{" +
                "description='" + description + '\''+
                ", product UPC=" + product.getUPCcode() +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) throws ProductNotInPrescription {
        ProductID y = new ProductID("ibuprofeno");
        BigDecimal z = new BigDecimal("10.29");
        ProductSpecification x = new ProductSpecification(y,"pastillas",z);
        System.out.println(x.toString());
    }
}
