package HomeWork_2.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello World! Test!");
        return "index";
    }
}