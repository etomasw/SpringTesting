package com.etomas.depth.service.impl;

import com.etomas.depth.entity.Department;
import com.etomas.depth.error.DepartmentNotFoundException;
import com.etomas.depth.repository.DepartmentRepository;
import com.etomas.depth.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @Override
    public Department findDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> departmentOptional = repository.findById(id);
        if(departmentOptional.isPresent()) return departmentOptional.get();
        throw new DepartmentNotFoundException("Department with ID: " + id + " not found.");
    }

    @Override
    public void deleteDepartmentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) throws DepartmentNotFoundException {
        Department departmentDb = findDepartmentById(id);
        if(department.getDepartmentName() != null) {
            departmentDb.setDepartmentName(department.getDepartmentName());
        }
        if(department.getDepartmentCode() != null) {
            departmentDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(department.getDepartmentAddress() != null) {
            departmentDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return repository.save(departmentDb);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return repository.findByDepartmentName(name);
    }
}
