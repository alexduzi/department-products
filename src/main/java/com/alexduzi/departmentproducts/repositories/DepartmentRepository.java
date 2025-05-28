package com.alexduzi.departmentproducts.repositories;

import com.alexduzi.departmentproducts.model.entities.Department;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends CassandraRepository<Department, UUID> {
}
