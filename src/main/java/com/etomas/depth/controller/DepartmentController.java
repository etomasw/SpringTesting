package com.etomas.depth.controller;

import com.etomas.depth.entity.Department;
import com.etomas.depth.error.DepartmentNotFoundException;
import com.etomas.depth.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping()
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Saving department : " + department.getDepartmentName());
        return departmentService.saveDepartment(department);
    }

    @GetMapping()
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.findDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(Long id) {
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) throws DepartmentNotFoundException {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        return departmentService.findDepartmentByName(name);
    }
}
