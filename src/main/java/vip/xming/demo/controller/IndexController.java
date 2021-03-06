package vip.xming.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vip.xming.demo.dto.PaginationDTO;
import vip.xming.demo.service.QuestionService;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String helloWorld(Model model, @RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "size", defaultValue = "5") Integer size) {
        PaginationDTO pagination = questionService.List(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
