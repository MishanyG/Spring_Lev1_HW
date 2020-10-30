import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        EntityManager em = factory.createEntityManager();
        LocalDate date = LocalDate.now();

        Client client1 = new Client();
        client1.setName("Petr");
        Client client2 = new Client();
        client2.setName("Ivan");
        Client client3 = new Client();
        client3.setName("Egor");
        Client client4 = new Client();
        client4.setName("Oleg");
        Product product1 = new Product();
        product1.setTitle("Milk");
        Product product2 = new Product();
        product2.setTitle("Beer");
        Product product3 = new Product();
        product3.setTitle("Oil");
        Product product4 = new Product();
        product4.setTitle("Bread");
        Sell sell1 = new Sell(date, client1, product2, 45.3, 15.1);
        Sell sell2 = new Sell(date, client2, product4, 18.6, 18.6);
        Sell sell3 = new Sell(date, client3, product1, 127.0, 25.4);
        Sell sell4 = new Sell(date, client4, product3, 254.4, 31.8);
        em.getTransaction().begin();
        em.persist(client1);
        em.persist(client2);
        em.persist(client3);
        em.persist(client4);
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product4);
        em.persist(sell1);
        em.persist(sell2);
        em.persist(sell3);
        em.persist(sell4);
        em.getTransaction().commit();
        allSellsClient(em, 1L);
        allClientsSell(em, 3L);
        deleteProduct(em, 1L);
        deleteClient(em, 2L);
    }

    public static void allSellsClient(EntityManager entityManager, Long id) {
        entityManager.getTransaction().begin();
        List <Sell> sells = entityManager
                .createQuery("SELECT s FROM Sell s WHERE s.clients.id_client = :id_client", Sell.class)
                .setParameter("id_client", id)
                .getResultList();
        entityManager.getTransaction().commit();
        System.out.println(sells);
    }

    public static void allClientsSell(EntityManager entityManager, Long id) {
        entityManager.getTransaction().begin();
        List <Client> clients = entityManager
                .createQuery("SELECT c FROM Client c, Sell s WHERE s.id_sell = :id_sell AND c.id_client = s.clients.id_client", Client.class)
                .setParameter("id_sell", id)
                .getResultList();
        entityManager.getTransaction().commit();
        System.out.println(clients);
    }

    public static void deleteProduct(EntityManager entityManager, Long id) {
        entityManager.getTransaction().begin();
        entityManager
                .createQuery("DELETE FROM Product p WHERE p.id_product = :id_product", Product.class)
                .setParameter("id_product", id)
                .getResultList();
        entityManager.getTransaction().commit();
        System.out.println("Product id: " + id + " deleted!");
    }

    public static void deleteClient(EntityManager entityManager, Long id) {
        entityManager.getTransaction().begin();
        entityManager
                .createQuery("DELETE FROM Client c WHERE c.id_client = :id_client", Client.class)
                .setParameter("id_client", id)
                .getResultList();
        entityManager.getTransaction().commit();
        System.out.println("Client id: " + id + " deleted!");
    }
}
