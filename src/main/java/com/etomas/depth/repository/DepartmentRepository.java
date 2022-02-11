package com.etomas.depth.repository;

import com.etomas.depth.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departmentName); // Full match, if we dont want fully sensitive, add findByDepartmentNameIgnoreCase
}
