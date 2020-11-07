package HomeWork_5.Service;

import HomeWork_5.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page <Product> getAll(Pageable pageable);

    List <Product> findById(Long id);

    List <Product> getMin(Double priceHiMin);

    List <Product> getMax(Double priceLoMax);

    List <Product> getMinOrMax(Double priceMin, Double priceMax);

    void update(ProductDAO productDAO);
}
