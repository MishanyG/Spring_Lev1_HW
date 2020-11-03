package HomeWork_4.Controllers;

import HomeWork_4.Service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/{num}", method = RequestMethod.GET)
    public String list(Model model, @PathVariable("num") int num) {
        model.addAttribute("products", productService
                .getAll(PageRequest.of(num, 5, Sort.by("price")
                        .ascending())));
        return "allProducts";
    }

    @RequestMapping(value = "/>{min}", method = RequestMethod.GET)
    public String getHiMin(Model model, @PathVariable("min") Double min) {
        model.addAttribute("products", productService.getMin(min));
        return "allProducts";
    }

    @RequestMapping(value = "/<{max}", method = RequestMethod.GET)
    public String getLoMax(Model model, @PathVariable("max") Double max) {
        model.addAttribute("products", productService.getMax(max));
        return "allProducts";
    }

    @RequestMapping(value = "/>{min}/<{max}", method = RequestMethod.GET)
    public String getMinOrMax(Model model, @PathVariable("min") Double min, @PathVariable("max") Double max) {
        model.addAttribute("products", productService.getMinOrMax(min, max));
        return "allProducts";
    }
}
