package com.prueba.melitest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.melitest.entities.request.DnaRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class EsmutanteControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void vefirifacarMutante() throws Exception {

        List<String> dnals = new ArrayList<>();
        dnals.add("AACC");
        dnals.add("AACC");
        dnals.add("AACC");
        dnals.add("AACC");

        DnaRequest dnaRequest  = DnaRequest.builder().dna(dnals).build();


       mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
              .content(asJsonString(dnaRequest))
              .contentType(MediaType.APPLICATION_JSON)
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isForbidden())
              .andDo(MockMvcResultHandlers.print())
              .andReturn();
    }

    @Test
    void obtenerEstadisticas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/stats")
                ).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}