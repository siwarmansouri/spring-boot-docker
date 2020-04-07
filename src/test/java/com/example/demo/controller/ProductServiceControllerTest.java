package com.example.demo.controller;

import com.example.demo.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceControllerTest {

    /**
     *
     * $GET  localhost:8080/products
     *
     * $POST {"id":"3","name":"Sugar"} localhost:8080/products
     *
     * $PUT {"id":"3","name":"SugarExtra"} localhost:8080/products/3
     *
     * $DELETE localhost:8080/products/3
     *
     */

    @Autowired
    private MockMvc mvc;


    private ObjectMapper mapper = new ObjectMapper();
    private Product product;

    @Before
    public void setUp() throws Exception {
        product=new Product();
        product.setId("3");
        product.setName("Sugar");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteProduct() throws Exception {
        this.mvc.perform(delete("/products/3")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("Product is deleted successsfully"));
    }

    @Test
    public void updateProduct() throws Exception {
        product.setName("Sugar Extra");
        this.mvc.perform(put("/products/3").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(product))).andDo(print()).andExpect(status().isOk()).andExpect(content().string("Product is updated successsfully"));
    }

    @Test
    public void createProduct() throws Exception {
        this.mvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(product))).andDo(print()).andExpect(status().isCreated()).andExpect(content().string("Product is created successfully"));
    }

    @Test
    public void getProduct() throws Exception {
        this.mvc.perform(get("/products")).andDo(print()).andExpect(status().isOk());
    }
}