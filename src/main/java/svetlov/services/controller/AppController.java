package svetlov.services.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/")
    public String getIndex() {
        return "home";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "security/login";
    }

    @GetMapping("/helloUser")
    public String getHelloPage(Authentication authentication) {
        return "helloUser";
    }
}
