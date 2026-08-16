package com.backend.service;

import com.backend.dto.OptimizationRequest;
import com.backend.dto.RouteResult;
import com.backend.model.Order;
import com.backend.model.Vehicle;
import com.backend.dto.*;
import com.backend.exception.ResourceNotFoundException;
import com.backend.model.*;
import com.backend.repository.InMemoryRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OptimizationService {
    private final InMemoryRepository repo;
    public OptimizationService(InMemoryRepository repo){this.repo=repo;}

    // Temporary demo logic. Later this method can call the Python + OR-Tools service.
    public List<RouteResult> optimize(OptimizationRequest r){
        List<Order> orders=r.orderIds().stream()
            .map(id->repo.order(id).orElseThrow(()->new ResourceNotFoundException("Order not found: "+id)))
            .toList();
        List<Vehicle> vehicles=r.vehicleIds().stream()
            .map(id->repo.vehicle(id).orElseThrow(()->new ResourceNotFoundException("Vehicle not found: "+id)))
            .toList();

        List<RouteResult> result=new ArrayList<>();
        for(int i=0;i<Math.min(orders.size(),vehicles.size());i++){
            Vehicle v=vehicles.get(i); Order o=orders.get(i);
            result.add(new RouteResult(v.getVehicleId(),
                List.of(v.getCurrentLocation(),o.getVillage(),"Destination"),
                25.0+(i*10),45+(i*15)));
        }
        return result;
    }
}
