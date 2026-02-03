package ro.rentthelook.server.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "productsizes")
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SizeId")
    private Integer sizeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", nullable = false)
    @JsonBackReference
    private Product product;

    @Column(name = "Size", nullable = false)
    private String size;

    @Column(name = "Stock", nullable = false)
    private Integer stock;

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
