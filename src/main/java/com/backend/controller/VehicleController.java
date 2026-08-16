package com.backend.controller;
import com.backend.dto.VehicleRequest;
import com.backend.model.Vehicle;
import com.backend.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService service;
    public VehicleController(VehicleService service){this.service=service;}
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Vehicle create(@Valid @RequestBody VehicleRequest r){return service.create(r);}
    @GetMapping public List<Vehicle> all(){return service.all();}
    @GetMapping("/available") public List<Vehicle> available(){return service.available();}
    @GetMapping("/{id}") public Vehicle one(@PathVariable Long id){return service.one(id);}
}
