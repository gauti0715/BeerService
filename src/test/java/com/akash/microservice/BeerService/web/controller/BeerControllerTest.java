package com.akash.microservice.BeerService.web.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.akash.microservice.BeerService.web.model.BeerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void getBeerById() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(
            MediaType.APPLICATION_JSON)).andExpect(status().isOk());
  }

  @Test
  void saveNewBeer() throws Exception {

    BeerDto beerDto = BeerDto.builder().build();
    String beerToJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerToJson))
        .andExpect(status().isCreated());
  }

  @Test
  void updateBeerById() throws Exception {
    BeerDto beerDto = BeerDto.builder().build();
    String beerToJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString())
    .contentType(MediaType.APPLICATION_JSON)
    .content(beerToJson))
        .andExpect(status().isNoContent());
  }
}