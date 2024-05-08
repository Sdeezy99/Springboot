package com.example.backend.controller;

import com.example.backend.entity.Backend;
import com.example.backend.service.BackendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BackendController {

    @Autowired
    private BackendServiceImpl backendService; // In the controller we do not use the information

    @GetMapping
    public List<Backend> findAll()
    {
        return backendService.getAllBackend();
    }

    @PostMapping
    public  void save (@RequestBody Backend backend) // Request body is the information we want to save
    {
        backendService.saveBackend(backend);
    }

    @GetMapping("{/id}")
    public Backend findOne(@PathVariable Long id)
    {
        return backendService.getTodayById(id);
    }
    @PutMapping("{/id}")
    public void update(@PathVariable Long id, @RequestBody Backend backend)
    {
        this.backendService.updateBackend(id,backend);
    }

    public void delete(@PathVariable Long id) // Path Variable annotation is used to specify id for the need information
    {
        this.backendService.deleteBackend(id);
    }
}
