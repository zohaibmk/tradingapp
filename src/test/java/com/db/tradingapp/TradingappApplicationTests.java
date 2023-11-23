package com.db.tradingapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TradingappApplicationTests {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    void receiveSignalWhenPositiveIntegerThenStatus2xxTest() throws Exception {
        mockMvc.perform(get("/signal/1")).andExpect(status().is2xxSuccessful());
        mockMvc.perform(get("/signal/2")).andExpect(status().is2xxSuccessful());
        mockMvc.perform(get("/signal/3")).andExpect(status().is2xxSuccessful());
        mockMvc.perform(get("/signal/4")).andExpect(status().is2xxSuccessful());
        mockMvc.perform(get("/signal/5")).andExpect(status().is2xxSuccessful());
    }

    @Test
    void receiveSignalWhenNonIntegerSignalThenStatus4xxTest() throws Exception {
        mockMvc.perform(get("/signal/asd")).andExpect(status().is4xxClientError());
    }

    @Test
    void receiveSignalWhenNotPositiveOrZeroIntegerThenStatus5xxTest() throws Exception {
        mockMvc.perform(get("/signal/0")).andExpect(status().is5xxServerError());
        mockMvc.perform(get("/signal/-123")).andExpect(status().is5xxServerError());
    }

}
