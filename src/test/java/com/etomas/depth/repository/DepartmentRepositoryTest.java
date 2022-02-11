package com.etomas.depth.repository;

import com.etomas.depth.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Mechanical")
                        .departmentAddress("Barcelona")
                        .departmentCode("IT-06")
                        .build();
        testEntityManager.persist(department);
    }

    @Test
    void findById_thenReturnDepartment() {
        Department department = repository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Mechanical");
    }
}