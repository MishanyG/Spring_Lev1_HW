package HomeWork_4.Service;

import HomeWork_4.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page <Product> getAll(Pageable pageable);
    List<Product> getMin(Double priceHiMin);
    List<Product> getMax(Double priceLoMax);
    List<Product> getMinOrMax(Double priceMin, Double priceMax);
}
