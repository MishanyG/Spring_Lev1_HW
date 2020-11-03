package HomeWork_4.Service;

import HomeWork_4.Product;
import HomeWork_4.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    @PersistenceContext
    private EntityManager em;

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page <Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List <Product> getMin(Double priceHiMin) {
        return em
                .createQuery("SELECT p FROM Product p WHERE p.price > :min ORDER BY p.price", Product.class)
                .setParameter("min", priceHiMin)
                .getResultList();
    }

    @Override
    public List <Product> getMax(Double priceLoMax) {
        return em
                .createQuery("SELECT p FROM Product p WHERE p.price < :max ORDER BY p.price", Product.class)
                .setParameter("max", priceLoMax)
                .getResultList();
    }

    @Override
    public List <Product> getMinOrMax(Double priceMin, Double priceMax) {
        return em
                .createQuery("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max", Product.class)
                .setParameter("min", priceMin)
                .setParameter("max", priceMax)
                .getResultList();
    }
}
