package com.example.backend.service;

import com.example.backend.entity.Backend;

import java.util.List;
//Interface used to initialise the methods that we can reuse in other classes
public interface BackendService{
    List<Backend> getAllBackend();
    void saveBackend(Backend backend);

    void updateBackend(Long id, Backend backend);
    Backend getTodayById(Long id);
    void deleteBackend(Long id);
}
