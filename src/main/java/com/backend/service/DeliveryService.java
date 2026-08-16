package com.backend.service;
import com.backend.dto.DeliveryStatusRequest;
import com.backend.exception.ResourceNotFoundException;
import com.backend.model.Delivery;
import com.backend.repository.InMemoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryService {
    private final InMemoryRepository repo;
    public DeliveryService(InMemoryRepository repo){this.repo=repo;}
    public List<Delivery> all(){return repo.deliveries();}
    public Delivery one(Long id){return repo.delivery(id).orElseThrow(()->new ResourceNotFoundException("Delivery not found: "+id));}
    public Delivery update(Long id,DeliveryStatusRequest r){Delivery d=one(id);d.setStatus(r.status());return repo.save(d);}
}
