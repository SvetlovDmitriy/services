package svetlov.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/")
    public String getIndex() {
        return "home";
    }
}
