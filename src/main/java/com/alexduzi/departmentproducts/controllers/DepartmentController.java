package com.alexduzi.departmentproducts.controllers;

import com.alexduzi.departmentproducts.model.dto.DepartmentDTO;
import com.alexduzi.departmentproducts.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> result = departmentService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable UUID id) {
        DepartmentDTO result = departmentService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> insert(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO result = departmentService.insert(departmentDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).body(result);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> update(@PathVariable UUID id, @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO result = departmentService.update(id, departmentDTO);
        return ResponseEntity.ok().body(result);
    }
}
