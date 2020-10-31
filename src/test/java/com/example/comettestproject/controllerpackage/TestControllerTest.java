//package com.example.comettestproject.controllerpackage;
//
//import com.example.comettestproject.service.TestService;
//import com.example.comettestproject.service.TestStringService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.junit.Assert.assertNull;
//import static org.mockito.Matchers.anyInt;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringJUnit4ClassRunner.class) //extend with springextension
//@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
//@WebAppConfiguration
//class TestControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    ObjectMapper om = new ObjectMapper();
//    @Mock
//    TestService testService;
//    @Mock
//    TestStringService stringService;
//    @InjectMocks
//    TestController testController;
//
////    @MockBean
////    TestService service;
//
//
//    @BeforeEach
//    void setUp() {
//        testController = new TestController();
//        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
//        initMocks(this);
//    }
//
////    @Test
////    void unitTesting() throws Exception {
////        String str = "unit testing";
////        String jsonString = om.writeValueAsString(str);
////        testService = Mockito.mock(TestService.class);
////        stringService = Mockito.mock(TestStringService.class);
//////        when(testService.testMethod(anyString())).thenReturn(ResponseEntity.status(HttpStatus.OK).body("test passed"));
//////        when(stringService.testMethod(anyString())).thenReturn("test passed");
//////        Mockito.doReturn(ResponseEntity.status(HttpStatus.OK).body("test passed")).when(testService.testMethod(anyString()));
////        Mockito.doReturn(ResponseEntity.status(HttpStatus.OK).body("test passed")).when(testService).testMethod(Mockito.anyString());
////        ResultActions resultActions = mockMvc.perform(post("/openapi/dummy/unittesting")
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(jsonString)
////        ).andExpect(status().isOk())
////        .andExpect(content().string("test passed"));
//////        MvcResult result = resultActions.andReturn();
//////        String content = result.getResponse().getContentAsString();
//////        assertNull(content);
////
////    }
//
//    @Test
//    void getUnitTesting(){
//
//    }
//
//    @Test
//    void getTestMethod() throws Exception {
//        mockMvc.perform(get("/openapi/dummy/newtest")
//        .param("salesChannel","salesChannel")
//        ).andExpect(status().isOk())
//        .andExpect(content().string("test passed"));
//    }
//
//    @Test
//    void createPartyInteraction() {
//
//    }
//
//    @Test
//    void updatePartyInteraction() {
//    }
//
//    @Test
//    void suspendSubscriber() {
//    }
//
//    @Test
//    void resumeSubscriber() {
//    }
//
//    @Test
//    void addAOPP() {
//    }
//
//    @Test
//    void getAOPP() {
//    }
//
//
//    @Test
//    void addition() {
//        Mockito.doReturn(10).when(testService).add(anyInt(),anyInt());
//        int value = testController.addition(3,5);
//        System.out.println("shjsks");
//        assertNull(value);
//
//
//    }
//}