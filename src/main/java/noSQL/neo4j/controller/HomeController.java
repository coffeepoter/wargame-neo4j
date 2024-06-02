package noSQL.neo4j.controller;

import noSQL.neo4j.dto.KeyDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping()
    public String home() {
        return "home";
    }

    @PostMapping()
    public String submitKey(@ModelAttribute KeyDto keyDto) {
        String key = keyDto.getKey();
        if (key.equals("key{WelcomeToCypher}")){
            return "cypher";
        } else {
            return "error";
        }
    }
}
