package com.etomas.depth.service;

import com.etomas.depth.entity.Department;
import com.etomas.depth.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department findDepartmentById(Long id) throws DepartmentNotFoundException;
    void deleteDepartmentById(Long id);
    Department updateDepartment(Long id, Department department) throws DepartmentNotFoundException;
    Department findDepartmentByName(String name);
}
