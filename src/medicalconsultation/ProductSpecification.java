package medicalconsultation;

import data.ProductID;
import exceptions.ProductNotInPrescription;

import java.math.BigDecimal;

public class ProductSpecification {
    private String description;
    private ProductID product;
    private BigDecimal price;

    public ProductSpecification(ProductID product, String description, BigDecimal price) throws ProductNotInPrescription {
        //UPC *description y price
        if(checkProductSpecification(product,description,price)){
            this.product = product;
            this.description = description;
            this.price = price;
        }else{
            throw new ProductNotInPrescription("Error");
        }

    }
    public boolean checkProductSpecification(ProductID product, String description, BigDecimal price){
        return product != null && description != null && price != null;
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
