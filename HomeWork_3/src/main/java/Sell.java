import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sells")
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sell")
    private Long id_sell;

    @Column(name = "date_sell")
    private LocalDate date_sell;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client clients;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product products;

    public Sell() {
    }

    public Sell(LocalDate date, Client client, Product product, Double amount, Double price) {
        date_sell = date;
        clients = client;
        products = product;
        this.amount = amount;
        this.price = price;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Long getId_sell() {
        return id_sell;
    }

    public void setId_sell(Long id_sell) {
        this.id_sell = id_sell;
    }

    public LocalDate getDate_sell() {
        return date_sell;
    }

    public void setDate_sell(LocalDate date_sell) {
        this.date_sell = date_sell;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
