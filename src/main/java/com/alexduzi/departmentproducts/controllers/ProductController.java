package com.alexduzi.departmentproducts.controllers;

import com.alexduzi.departmentproducts.model.dto.ProductDTO;
import com.alexduzi.departmentproducts.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> result = productService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
        ProductDTO result = productService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/department")
    public ResponseEntity<List<ProductDTO>> findByDepartment(@RequestParam(value = "department") String department) {
        List<ProductDTO> result = productService.findByDepartment(department);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/description")
    public ResponseEntity<List<ProductDTO>> findByDescription(@RequestParam(value = "text") String text) {
        List<ProductDTO> result = productService.findByDescription(text);
        return ResponseEntity.ok(result);
    }
}
