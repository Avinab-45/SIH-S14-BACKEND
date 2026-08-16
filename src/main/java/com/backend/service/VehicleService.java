package com.backend.service;
import com.backend.dto.VehicleRequest;
import com.backend.exception.ResourceNotFoundException;
import com.backend.model.Vehicle;
import com.backend.repository.InMemoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {
    private final InMemoryRepository repo;
    public VehicleService(InMemoryRepository repo){this.repo=repo;}
    public Vehicle create(VehicleRequest r){
        return repo.save(new Vehicle(null,r.vehicleId(),r.capacity(),r.type(),r.currentLocation(),r.available()));
    }
    public List<Vehicle> all(){return repo.vehicles();}
    public List<Vehicle> available(){return repo.vehicles().stream().filter(Vehicle::isAvailable).toList();}
    public Vehicle one(Long id){return repo.vehicle(id).orElseThrow(()->new ResourceNotFoundException("Vehicle not found: "+id));}
}
