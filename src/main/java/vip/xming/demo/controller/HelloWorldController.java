package vip.xming.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/helloWorld")
    public String helloWorld(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "helloWorld";
    }
}
