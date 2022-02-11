package com.etomas.depth.controller;

import com.etomas.depth.entity.Department;
import com.etomas.depth.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentId(1L)
                .departmentName("IT")
                .departmentAddress("Barcelona")
                .departmentCode("IT-03")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department input = Department.builder()
                .departmentName("IT")
                .departmentAddress("Barcelona")
                .departmentCode("IT-03")
                .build();
        Mockito.when(departmentService
                .saveDepartment(input))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"IT\",\n" +
                        "\t\"departmentAddress\":\"Ahmedabad\",\n" +
                        "\t\"departmentCode\":\"IT-06\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getDepartmentById() {
    }
}