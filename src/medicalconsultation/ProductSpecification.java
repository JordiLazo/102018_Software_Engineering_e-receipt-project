package medicalconsultation;

import data.ProductID;
import exceptions.ProductNotInPrescription;
import java.math.BigDecimal;

public class ProductSpecification {
    private String description;
    private ProductID product;
    private BigDecimal price;

    public ProductSpecification(ProductID product, String description, BigDecimal price) throws ProductNotInPrescription{
        this.product =  (ProductID) checkProductSpecification(product);
        this.description =  (String) checkProductSpecification(description);
        this.price = (BigDecimal) checkProductSpecification(price);
    }

    private Object checkProductSpecification(Object obj) throws ProductNotInPrescription{
        if(obj != null){
            if (obj instanceof ProductID || obj instanceof String || obj instanceof BigDecimal){
                if (obj instanceof String){
                     String s = (String) obj;
                     if (!s.equals("")){
                         return obj;
                     }else {
                         throw new ProductNotInPrescription("ERROR SI");
                     }
                }
                return obj;
            }
        }
        throw new ProductNotInPrescription("ERROR SI");
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
}
