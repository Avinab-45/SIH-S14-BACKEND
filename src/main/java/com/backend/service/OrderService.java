package com.backend.service;
import com.backend.dto.OrderRequest;
import com.backend.exception.ResourceNotFoundException;
import com.backend.model.Order;
import com.backend.repository.InMemoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final InMemoryRepository repo;
    public OrderService(InMemoryRepository repo){this.repo=repo;}
    public Order create(OrderRequest r){
        return repo.save(new Order(null,r.village(),r.product(),r.quantity(),r.urgency(),r.perishability(),r.deadline(),"PENDING"));
    }
    public List<Order> all(){return repo.orders();}
    public Order one(Long id){return repo.order(id).orElseThrow(()->new ResourceNotFoundException("Order not found: "+id));}
}
