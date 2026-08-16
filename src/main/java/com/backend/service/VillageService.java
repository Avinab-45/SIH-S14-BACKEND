package com.backend.service;
import com.backend.exception.ResourceNotFoundException;
import com.backend.model.Village;
import com.backend.repository.InMemoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VillageService {
    private final InMemoryRepository repo;
    public VillageService(InMemoryRepository repo){this.repo=repo;}
    public List<Village> all(){return repo.villages();}
    public Village one(Long id){return repo.village(id).orElseThrow(()->new ResourceNotFoundException("Village not found: "+id));}
}
