package HomeWork_5.Controllers;

import HomeWork_5.Product;
import HomeWork_5.Service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{num}")
    public Page <Product> getAll(@PathVariable("num") int num) {
        return productService.getAll(PageRequest.of(num, 5, Sort.by("price").ascending()));
    }

    @GetMapping(value = "/next")
    public Page <Product> next() {
        return productService.getAll(PageRequest.of(0, 5, Sort.by("price").ascending()).next());
    }

    @GetMapping(value = "/back")
    public Page <Product> back() {
        return productService.getAll(PageRequest.of(0, 5, Sort.by("price").ascending()).previous());
    }

    @GetMapping(value = "/>{min}")
    public List <Product> getHiMin(@PathVariable("min") Double min) {
        return productService.getMin(min);
    }

    @GetMapping(value = "/<{max}")
    public List <Product> getLoMax(@PathVariable("max") Double max) {
        return productService.getMax(max);
    }

    @GetMapping(value = "/products")
    public List <Product> getMinOrMax(@RequestParam("min") Double min, @RequestParam("max") Double max) {
        return productService.getMinOrMax(min, max);
    }

    @GetMapping(value = "/editProduct")
    public List <Product> editProduct(@RequestParam("id") Long id) {
        return productService.findById(id);
    }

    @PutMapping(value = "/productsUpd")
    public Product updateProduct(@RequestParam("id") Long id, @RequestParam("prod") String name, @RequestParam("price") Double price) {
        productService.update(id, name, price);
        return productService.update(id, name, price);
    }

    @GetMapping(value = "/home")
    public String home() {
        return "index";
    }
}
