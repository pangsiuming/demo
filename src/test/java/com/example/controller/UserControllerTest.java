package com.example.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception{
        //MockMvcBuilders.webAppContextSetup(WebApplicationContext context)：指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    @Test
    public void createUser() throws Exception{

            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{uid}",1)
//                    .param("name", "lvgang")
                    .accept(MediaType.TEXT_HTML_VALUE))
//                     .andExpect(MockMvcResultMatchers.status().isOk())             //等同于Assert.assertEquals(200,status);
//                     .andExpect(MockMvcResultMatchers.content().string("hello lvgang"))    //等同于 Assert.assertEquals("hello lvgang",content);
                    .andDo(MockMvcResultHandlers.print()) .andReturn();
            int status = mvcResult.getResponse().getStatus();                 //得到返回代码
            String content = mvcResult.getResponse().getContentAsString();    //得到返回结果

//        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
//        Assert.assertEquals("hello lvgang",content);            //断言，判断返回的值是否正确
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void removeUserById() {
    }

    @Test
    public void findUserInfoByUsernameAndCname() {
    }

    @Test
    public void findUserInfoById() {
    }

    @Test
    public void findUserById() {
    }

    @Test
    public void findAllUsers() {
    }

    @Test
    public void findAllUserInfo() {
    }
}