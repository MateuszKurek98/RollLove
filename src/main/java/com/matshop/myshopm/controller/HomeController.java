package com.matshop.myshopm.controller;

import com.matshop.myshopm.Cart;
import com.matshop.myshopm.ItemOperation;
import com.matshop.myshopm.model.Item;
import com.matshop.myshopm.repository.ItemRepository;
import com.matshop.myshopm.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller


public class HomeController {
    private final CartService cartService;

    @Autowired
    public HomeController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping ("/")
    public String home(Model model){
        model.addAttribute("items", cartService.getAllItems());
        return "home";
    }
    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId")Long itemId, Model model){
        cartService.itemOperation(itemId, ItemOperation.INCREASE);
        model.addAttribute("items",  cartService.getAllItems());
        return "home";
    }
}
