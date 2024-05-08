package com.example.backend.service;

import com.example.backend.entity.Backend;
import com.example.backend.repository.BackendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Annotations used to specify a service
public class BackendServiceImpl implements BackendService { //implements the methods we have in our service

    @Autowired // This is used when we want to use the methods from the Db we need to connect the repo with the project
    private BackendRepo backendRepo;

    @Override //Overriding the methods we have in the service and reusing them in our implementation instead of having to start from scratch
    public List<Backend> getAllBackend() {
        return backendRepo.findAll();
    }

    @Override
    public void saveBackend(Backend backend) {
        this.backendRepo.save(backend); //save() is a method provided by JpaRepository
    }

    @Override
    public void updateBackend(Long id, Backend backend) {
        Backend backendFrmDb = backendRepo.findById(id).get();
        backendFrmDb.setTaskName(backend.getTaskName());
        backendFrmDb.setDesc(backend.getDesc());
        backendRepo.save(backendFrmDb);

    }
    @Override
    public Backend getTodayById(Long id) {
        Optional<Backend> optional = backendRepo.findById(id);
        Backend backend;

        if (optional.isPresent())
        {
            backend = optional.get();

        }
        else{
            throw new RuntimeException("Backend for the id:" + id + " not found");
        }
        return backend;
    }

    @Override
    public void deleteBackend(Long id) {

    }

}
