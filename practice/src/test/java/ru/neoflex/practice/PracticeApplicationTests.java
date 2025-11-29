package ru.neoflex.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/add")
                        .param("a", "10")
                        .param("b", "5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("15.0"));
    }

    @Test
    void testSubtractEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/subtract")
                        .param("a", "10")
                        .param("b", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("7.0"));
    }

    @Test
    void testHistoryEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/add").param("a", "1").param("b", "2"));

        mockMvc.perform(get("/api/calculator/history")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].operation").value("SUM"));
    }
}