package com.puce.veterinaria.repository;

import com.puce.veterinaria.model.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuenoRepository extends JpaRepository<Dueno, Integer> {
}
