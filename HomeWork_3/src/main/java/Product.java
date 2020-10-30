import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id_product;

    @Column(name = "title")
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "clients_products",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_client")
    )
    private List <Client> clients;

    @OneToMany(mappedBy = "products")
    private List<Sell> sells;

    public Product() {
    }

    public List <Sell> getSells() {
        return sells;
    }

    public void setSells(List <Sell> sells) {
        this.sells = sells;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List <Client> getClients() {
        return clients;
    }

    public void setClients(List <Client> clients) {
        this.clients = clients;
    }
}
