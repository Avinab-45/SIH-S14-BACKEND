package com.backend.repository;

import com.backend.model.Delivery;
import com.backend.model.Order;
import com.backend.model.Vehicle;
import com.backend.model.Village;
import com.backend.model.*;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryRepository {
    private final Map<Long, Order> orders = new LinkedHashMap<>();
    private final Map<Long, Vehicle> vehicles = new LinkedHashMap<>();
    private final Map<Long, Village> villages = new LinkedHashMap<>();
    private final Map<Long, Delivery> deliveries = new LinkedHashMap<>();
    private final AtomicLong orderId = new AtomicLong(100);
    private final AtomicLong vehicleId = new AtomicLong(1);
    private final AtomicLong deliveryId = new AtomicLong(1);

    public InMemoryRepository() {
        villages.put(1L,new Village(1L,"Village A","20.2961,85.8245",1200,80));
        villages.put(2L,new Village(2L,"Village B","20.3100,85.8300",900,60));
        villages.put(3L,new Village(3L,"Village C","20.3300,85.8500",1500,90));
    }

    public List<Order> orders(){ return new ArrayList<>(orders.values()); }
    public Optional<Order> order(Long id){ return Optional.ofNullable(orders.get(id)); }
    public Order save(Order x){ if(x.getId()==null)x.setId(orderId.incrementAndGet()); orders.put(x.getId(),x); return x; }

    public List<Vehicle> vehicles(){ return new ArrayList<>(vehicles.values()); }
    public Optional<Vehicle> vehicle(Long id){ return Optional.ofNullable(vehicles.get(id)); }
    public Vehicle save(Vehicle x){ if(x.getId()==null)x.setId(vehicleId.getAndIncrement()); vehicles.put(x.getId(),x); return x; }

    public List<Village> villages(){ return new ArrayList<>(villages.values()); }
    public Optional<Village> village(Long id){ return Optional.ofNullable(villages.get(id)); }

    public List<Delivery> deliveries(){ return new ArrayList<>(deliveries.values()); }
    public Optional<Delivery> delivery(Long id){ return Optional.ofNullable(deliveries.get(id)); }
    public Delivery save(Delivery x){ if(x.getId()==null)x.setId(deliveryId.getAndIncrement()); deliveries.put(x.getId(),x); return x; }
}
