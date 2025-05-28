package com.alexduzi.departmentproducts.services;

import com.alexduzi.departmentproducts.model.dto.DepartmentDTO;
import com.alexduzi.departmentproducts.repositories.DepartmentRepository;
import com.alexduzi.departmentproducts.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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

    public DepartmentDTO findById(UUID id) {
        return departmentRepository.findById(id).map(DepartmentDTO::new).orElseThrow(() -> new ResourceNotFoundException("Department not found!"));
    }
}
