package com.ice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ice.controllertest.TestController;
import com.ice.controllertest.bean.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

/**
 * 9.Controller 测试
 */
@SpringBootTest
public class ControllerTest {
    @Autowired
    TestController testController;

    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;

    @BeforeEach
    public void BeforeAll() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getHelloTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/getHello")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "SpringBoot"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void addBookTest() {
        Book book = new Book();
        book.setId(1);
        book.setName("Java JVM");
        book.setAuthor("明");
        String string = "";
        MvcResult mvcResult = null;
        try {
            string = new ObjectMapper().writeValueAsString(book);
            System.out.println("string: " + string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/addBook")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(string))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(mvcResult.getResponse().getContentAsString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
