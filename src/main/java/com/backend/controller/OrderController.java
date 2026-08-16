package com.backend.controller;
import com.backend.dto.OrderRequest;
import com.backend.model.Order;
import com.backend.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service){this.service=service;}
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Order create(@Valid @RequestBody OrderRequest r){return service.create(r);}
    @GetMapping public List<Order> all(){return service.all();}
    @GetMapping("/{id}") public Order one(@PathVariable Long id){return service.one(id);}
}
