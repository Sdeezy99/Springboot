package com.example.backend.repository;

import com.example.backend.entity.Backend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Annotation used in springboot to show that this is a repository
public interface BackendRepo extends JpaRepository<Backend,Long> {
    
}
