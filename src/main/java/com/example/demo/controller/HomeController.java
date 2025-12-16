package com.example.demo.controller;

import com.example.demo.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final ItemsService itemsService;

    public HomeController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/")
    public String home(
            @RequestParam(value = "name", required = false) String name,
            Model model) {
        var items = (name == null || name.isBlank())
                ? itemsService.findAll()
                : itemsService.findByName(name);
        model.addAttribute("items", items);
        model.addAttribute("query", name);
        model.addAttribute("count", items.size());
        return "index";
    }
}
