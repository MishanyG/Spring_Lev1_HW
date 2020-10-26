package HomeWork_2.Repository;

import HomeWork_2.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRep {
    private Map <Long, Product> productMap = new HashMap <>();
    private Long id = 0L;

    {
        productMap.put(++ id, new Product(id, "Tomatoes", 50.8));
        productMap.put(++ id, new Product(id, "Potato", 80.5));
        productMap.put(++ id, new Product(id, "Cucumbers", 130.9));
        productMap.put(++ id, new Product(id, "Pepper", 55.2));
        productMap.put(++ id, new Product(id, "Apples", 250.0));
        productMap.put(++ id, new Product(id, "Pears", 120.4));
        productMap.put(++ id, new Product(id, "Bananas", 340.7));
    }

    public Product getById(Long id) {
        return productMap.get(id);
    }

    public List <Product> getAll() {
        return new ArrayList <>(productMap.values());
    }

    public Product addProduct(Product product) {
        if(product.getId() == null) {
            product.setId(++ id);
        }
        productMap.put(product.getId(), product);
        return product;
    }
}
