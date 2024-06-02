package noSQL.neo4j.controller;

import noSQL.neo4j.dto.RequestDto;
import noSQL.neo4j.entity.User;
import noSQL.neo4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/prob")
public class ProbController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getProb1(){
        return "prob";
    }

    @PostMapping()
    public String getKey(@ModelAttribute RequestDto requestDto, Model model){
        String name = requestDto.getName();
        Flux<User> result1 = userService.findOneByName(name);
        model.addAttribute("users", result1.collectList().block());
        return "result1";
    }
}
