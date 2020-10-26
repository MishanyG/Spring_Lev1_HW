package HomeWork_2.Controllers;

import HomeWork_2.Product;
import HomeWork_2.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List <Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "allProducts";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(Model model, @PathVariable("id") Long id) {
        Product byId = productService.getById(id);
        model.addAttribute("product", byId == null ? new Product() : byId);
        return "products";
    }

    @GetMapping("/new")
    public String getFormNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(Product product) {
        Product addProduct = productService.addProduct(product);
        return "redirect:/products/" + addProduct.getId();
    }
}
