package noSQL.neo4j.controller;

import noSQL.neo4j.dto.CypherDto;
import noSQL.neo4j.entity.User;
import noSQL.neo4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/cypher")
public class FlagController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getCypher() {
        return "cypher";
    }

    @PostMapping()
    public String getFlag(@ModelAttribute CypherDto cypherDto, Model model){
        String cypher = cypherDto.getCypher();
        Flux<User> result2 = userService.findByValue(cypher);
        model.addAttribute("users", result2.collectList().block());
        return "result2";
    }
}

