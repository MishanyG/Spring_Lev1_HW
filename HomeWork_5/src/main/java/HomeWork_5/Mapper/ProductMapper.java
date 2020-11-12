package HomeWork_5.Mapper;

import HomeWork_5.DTO.ProductDTO;
import HomeWork_5.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    Product toProduct(ProductDTO dto);

    @InheritInverseConfiguration
    ProductDTO fromProduct(Product product);

    List<Product> toProductList(List <ProductDTO> productDTOS);

    List<ProductDTO> fromProductList(List<Product> products);

    Page<ProductDTO> fromProductsPage(Page<Product> productPage);
}
