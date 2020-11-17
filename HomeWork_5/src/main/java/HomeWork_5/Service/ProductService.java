package HomeWork_5.Service;

import HomeWork_5.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

//    Page <ProductDTO> getAll(Pageable pageable);
//
//    List <ProductDTO> findById(Long id);
//
//    List <ProductDTO> getMin(Double priceHiMin);
//
//    List <ProductDTO> getMax(Double priceLoMax);
//
//    List <ProductDTO> getMinOrMax(Double priceMin, Double priceMax);
//
//    ProductDTO update(Long Id, String Name, Double Price);

    Page <Product> getAll(Pageable pageable);

    List <Product> findById(Long id);

    List <Product> getMin(Double priceHiMin);

    List <Product> getMax(Double priceLoMax);

    List <Product> getMinOrMax(Double priceMin, Double priceMax);

    void update(Long Id, String Name, Double Price);
}
