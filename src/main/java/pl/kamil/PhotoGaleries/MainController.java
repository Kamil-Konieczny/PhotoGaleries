package pl.kamil.PhotoGaleries;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

@GetMapping("/client")
    public String clientPanel()
    {
    return "client";
    }
    @GetMapping("/admin")
    public String adminPanel()
    {
        return "admin";
    }
}
