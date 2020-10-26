package HomeWork_2.Service;

import HomeWork_2.Product;
import HomeWork_2.Repository.ProductRep;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {
    private ProductRep productRep;

    public ProductService(ProductRep productRepo) {
        this.productRep = productRepo;
    }

    public Product getById(Long id) {
        return productRep.getById(id);
    }

    public List <Product> getAll() {
        List <Product> products = productRep.getAll();
        products.sort(Comparator.comparingLong(Product :: getId));
        return products;
    }

    public Product addProduct(Product product) {
        return productRep.addProduct(product);
    }
}
