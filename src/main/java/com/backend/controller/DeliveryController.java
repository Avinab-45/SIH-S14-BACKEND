package com.backend.controller;
import com.backend.dto.DeliveryStatusRequest;
import com.backend.model.Delivery;
import com.backend.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    private final DeliveryService service;
    public DeliveryController(DeliveryService service){this.service=service;}
    @GetMapping public List<Delivery> all(){return service.all();}
    @GetMapping("/{id}") public Delivery one(@PathVariable Long id){return service.one(id);}
    @PatchMapping("/{id}") public Delivery update(@PathVariable Long id,@Valid @RequestBody DeliveryStatusRequest r){return service.update(id,r);}
}
