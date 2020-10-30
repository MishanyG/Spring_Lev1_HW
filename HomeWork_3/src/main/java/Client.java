import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id_client;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "clients_products",
            joinColumns = @JoinColumn(name = "id_client"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private List <Product> products;

    @OneToMany(mappedBy = "clients")
    private List<Sell> sells;

    public Client() {
    }

    public List <Sell> getSells() {
        return sells;
    }

    public void setSells(List <Sell> sells) {
        this.sells = sells;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List <Product> getProducts() {
        return products;
    }

    public void setProducts(List <Product> products) {
        this.products = products;
    }
}
