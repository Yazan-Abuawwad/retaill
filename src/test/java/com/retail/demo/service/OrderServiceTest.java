package com.retail.demo.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.demo.entity.OrderEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Profile("test")
@Configuration
public class OrderServiceTest {



    @Bean
    @Primary
    public OrderServiceTest orderService() {
        return Mockito.mock(OrderServiceTest.class);
    }




    @Autowired
    private OrderService orderService;






//    @Test
//    public void whenUserIsCreatedOrder_thenRetrievedBillDataIsCorrect() {
//
//        OrderEntity orderEntity=new OrderEntity();
//
//        Mockito.when(orderService.create(orderEntity).getTotalAmountBill().toString()).thenReturn("Mock OrderService Name");
//        String testName = orderService.getAllOrders().get(0).getAmountBill().toString();
//        Assert.assertEquals("Mock OrderService Name", testName);
//    }

    @Test
    public void createOrder() throws Exception {
        String uri = "/order";

        OrderEntity orderEntity =getOrderJson();


        Mockito.when(orderService.create(orderEntity).getTotalAmountBill()).thenReturn(945.0);


    }



    public OrderEntity getOrderJson()throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();

        //   objectMapper.writeValue(new File("target/car.json"), ObjectMapper);


        String json = "\n" +
                "{\n" +
                "  \"amountBill\": 0,\n" +
                "  \"discountBill\": 0,\n" +
                " \n" +
                "  \"productEntitySet\": [\n" +
                "     {\n" +
                "    \"productId\": 1,\n" +
                "    \"name\": \"milk\",\n" +
                "    \"price\": 1,\n" +
                "    \"quantity\": 3,\n" +
                "    \"orderset\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"productId\": 2,\n" +
                "    \"name\": \"milk2\",\n" +
                "    \"price\": 2.2,\n" +
                "    \"quantity\": 32,\n" +
                "    \"orderset\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"productId\": 3,\n" +
                "    \"name\": \"milk3\",\n" +
                "    \"price\": 2.233,\n" +
                "    \"quantity\": 32,\n" +
                "    \"orderset\": []\n" +
                "  }\n" +
                "  ],\n" +
                "  \"time\": \"2021-12-26T02:11:57.490Z\",\n" +
                "  \"totalAmountBill\": 0,\n" +
                "\n" +
                "\n" +
                "  \"userEntity\":  {\n" +
                "    \"userId\": 4,\n" +
                "    \"name\": \"mohammed\",\n" +
                "    \"user_type\": \"EMPLOYEE\",\n" +
                "    \"orderset\": []\n" +
                "  }\n" +
                "}";


        return objectMapper.readValue(json, OrderEntity.class);
    }
}
