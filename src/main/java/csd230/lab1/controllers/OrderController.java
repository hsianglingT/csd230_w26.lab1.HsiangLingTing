package csd230.lab1.controllers;


import csd230.lab1.entities.BookEntity;
import csd230.lab1.entities.CartEntity;
import csd230.lab1.entities.OrderEntity;
import csd230.lab1.entities.ProductEntity;
import csd230.lab1.repositories.BookRepository;
import csd230.lab1.repositories.CartEntityRepository;
import csd230.lab1.repositories.OrderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private CartEntityRepository cartRepository;
    @Autowired
    private OrderEntityRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String viewOrder(Model model) {
        // find the newest order
        List<Long> ids = orderRepository.findAll().stream().map(OrderEntity::getId).toList();
        long latestOrder = ids.size() ;

        OrderEntity order = orderRepository.findById(latestOrder)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        model.addAttribute("order", order);
        return "orderDetails";
    }


}
