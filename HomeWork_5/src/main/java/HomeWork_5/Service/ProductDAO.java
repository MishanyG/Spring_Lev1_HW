package HomeWork_5.Service;

public class ProductDAO {
    private Long id_product;
    private String name;
    private Double price;

    public ProductDAO() {
    }

    public ProductDAO(Long id_product, String name, Double price) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
