package com.backend.controller;
import com.backend.model.Village;
import com.backend.service.VillageService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/villages")
public class VillageController {
    private final VillageService service;
    public VillageController(VillageService service){this.service=service;}
    @GetMapping public List<Village> all(){return service.all();}
    @GetMapping("/{id}") public Village one(@PathVariable Long id){return service.one(id);}
}
