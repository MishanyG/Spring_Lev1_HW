package HomeWork_5.Controllers;

import HomeWork_5.Service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/{num}", method = RequestMethod.GET)
    public String list(Model model, @PathVariable("num") int num) {
        model.addAttribute("products", productService.getAll(PageRequest.of(num, 5, Sort.by("price").ascending())));
        return "allProducts";
    }

    @RequestMapping(value = "/next", method = RequestMethod.GET)
    public String next(Model model) {
        model.addAttribute("products", productService.getAll(PageRequest.of(0, 5, Sort.by("price").ascending()).next()));
        return "allProducts";
    }

    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String back(Model model) {
        model.addAttribute("products", productService.getAll(PageRequest.of(0, 5, Sort.by("price").ascending()).previous()));
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

    @RequestMapping(value = "/products")
    public String getMinOrMax(Model model, @RequestParam("min") Double min, @RequestParam("max") Double max) {
        model.addAttribute("products", productService.getMinOrMax(min, max));
        return "allProducts";
    }

    @RequestMapping(value = "/editProduct")
    public String editProduct(Model model, @RequestParam("id") Long id) {
        model.addAttribute("products", productService.findById(id));
        return "updProducts";
    }

    @RequestMapping(value = "/productsUpd")
    public String updateProduct(@RequestParam("id") Long id, @RequestParam("prod") String name, @RequestParam("price") Double price) {
        productService.update(id, name, price);
        return "redirect:/0";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "index";
    }
}
