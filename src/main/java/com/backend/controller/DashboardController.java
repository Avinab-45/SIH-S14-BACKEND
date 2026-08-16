package com.backend.controller;
import com.backend.repository.InMemoryRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final InMemoryRepository repo;
    public DashboardController(InMemoryRepository repo){this.repo=repo;}
    @GetMapping
    public Map<String,Object> dashboard(){
        long pending=repo.orders().stream().filter(o->"PENDING".equalsIgnoreCase(o.getStatus())).count();
        long available=repo.vehicles().stream().filter(v->v.isAvailable()).count();
        Map<String,Object> x=new LinkedHashMap<>();
        x.put("totalOrders",repo.orders().size());
        x.put("pendingOrders",pending);
        x.put("totalVehicles",repo.vehicles().size());
        x.put("availableVehicles",available);
        x.put("totalVillages",repo.villages().size());
        x.put("totalDeliveries",repo.deliveries().size());
        return x;
    }
}
