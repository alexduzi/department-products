package com.alexduzi.departmentproducts.services;

import com.alexduzi.departmentproducts.model.dto.DepartmentDTO;
import com.alexduzi.departmentproducts.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository repository) {
        this.departmentRepository = repository;
    }

    public List<DepartmentDTO> findAll() {
        return departmentRepository.findAll().stream().map(DepartmentDTO::new).collect(Collectors.toList());
    }
}
