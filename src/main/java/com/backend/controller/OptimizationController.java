package com.backend.controller;
import com.backend.dto.OptimizationRequest;
import com.backend.dto.RouteResult;
import com.backend.dto.*;
import com.backend.service.OptimizationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OptimizationController {
    private final OptimizationService service;
    public OptimizationController(OptimizationService service){this.service=service;}
    @PostMapping("/optimize")
    public List<RouteResult> optimize(@Valid @RequestBody OptimizationRequest r){return service.optimize(r);}
}
