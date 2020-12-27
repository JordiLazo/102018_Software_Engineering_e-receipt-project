package services;

import data.ProductID;

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
        return product.getUPC_code();
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getPrice() {
        return price;
    }



    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
