package services;

import data.ProductID;

import java.math.BigDecimal;

public class ProductSpecification {
    private String description;
    private ProductID pd;
    private BigDecimal price;

    public ProductSpecification(ProductID pd, String description, BigDecimal price) {
        //UPC *description y price
        this.pd = pd;
        this.description = description;
        this.price = price;
    }


    public ProductID getProduct() {
        return pd;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getPrice() {
        return price;
    }



    public void setProduct(ProductID pd) {
        this.pd = pd;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
