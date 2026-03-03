package com.jenkins.example.jenkins_example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.jenkins.example.jenkins_example.controller.PrintController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PrintController.class)
class PrintControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void print_returnsOk_andPrintsMessage() throws Exception {
        mockMvc.perform(post("/api/print"))
                .andExpect(status().isOk());
    }
}