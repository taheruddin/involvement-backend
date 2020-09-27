package com.hm.backend.integration;

import com.hm.backend.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InvolvementTests {

    @Value("classpath:data/involvement/create.json")
    private Resource createRequest;

    @Value("classpath:data/involvement/edit.json")
    private Resource editRequest;

    @Value("classpath:data/involvement/createWithNonLeafSector.json")
    private Resource faultyCreateRequest;

    @Value("classpath:data/involvement/editWithNonLeafSector.json")
    private Resource faultyEditRequest;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createInvolvement() throws Exception {
        String requestJson = Utils.getJsonString(createRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/involvements")
            .content(requestJson)
            .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc
            .perform(request)
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Bob")))
            .andExpect(content().string(containsString("Other (Wood)")))
            .andExpect(content().string(containsString("Wooden building materials")));
    }

    @Test
    public void editInvolvement() throws Exception {
        String requestJson = Utils.getJsonString(editRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/involvements/1")
            .content(requestJson)
            .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc
            .perform(request)
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Bob")))
            .andExpect(content().string(containsString("Road")))
            .andExpect(content().string(containsString("Water")));
    }

    @Test
    public void getInvolvement() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/involvements/1")
            .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc
            .perform(request)
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Bob")))
            .andExpect(content().string(containsString("Road")))
            .andExpect(content().string(containsString("Water")));
    }

    @Test
    public void whenRequestToCreateInvolvementWithNonLeafSectorId_thenReturnStatusCode422() throws Exception {
        String requestJson = Utils.getJsonString(faultyCreateRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/involvements")
            .content(requestJson)
            .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc
            .perform(request)
            .andDo(print())
            .andExpect(status().isUnprocessableEntity());
    }



    @Test
    public void whenRequestToUpdateInvolvementWithNonLeafSectorId_thenReturnStatusCode422() throws Exception {
        String requestJson = Utils.getJsonString(faultyEditRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/involvements/1")
            .content(requestJson)
            .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc
            .perform(request)
            .andDo(print())
            .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void whenRequestToUpdateInvolvementWithNonExistentInvolvementId_thenReturnStatusCode422() throws Exception {
        String requestJson = Utils.getJsonString(editRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/involvements/999")
            .content(requestJson)
            .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc
            .perform(request)
            .andDo(print())
            .andExpect(status().isUnprocessableEntity())
            .andExpect(content().string(containsString("No involvement with id=999 exists!")));
    }
}
