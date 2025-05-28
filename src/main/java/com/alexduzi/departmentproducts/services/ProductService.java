package com.alexduzi.departmentproducts.services;

import com.alexduzi.departmentproducts.model.dto.ProductDTO;
import com.alexduzi.departmentproducts.repositories.ProductRepository;
import com.alexduzi.departmentproducts.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public ProductDTO findById(UUID id) {
        return productRepository.findById(id).map(ProductDTO::new).orElseThrow(() -> new ResourceNotFoundException("Department not found!"));
    }

    public List<ProductDTO> findByDepartment(String department) {
        return Optional.ofNullable(department)
                .filter(dept -> !dept.isBlank())
                .map(productRepository::findByDepartment)
                .orElse(productRepository.findAll())
                .stream()
                .map(ProductDTO::new)
                .toList();
    }
}
