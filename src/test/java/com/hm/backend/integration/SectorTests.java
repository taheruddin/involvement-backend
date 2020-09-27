package com.hm.backend.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.hm.backend.Utils.getJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SectorTests {

    @Value("classpath:data/rootSector.json")
    private Resource rootSector;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenRequestForTheSectorWithIdOne_shouldReturnRootSector() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/sectors/1");
        this.mockMvc
            .perform(request)
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(getJsonString(rootSector)));
    }
}
