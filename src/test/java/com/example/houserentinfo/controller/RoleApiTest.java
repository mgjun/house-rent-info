package com.example.houserentinfo.controller;

import com.example.houserentinfo.exception.EntityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoleApiTest {

    @Test
    public void shouldPageAndSortThrowExceptionWhenIsNull() {
        given().post("/role/pageAndSort")
               .then()
               .log().body();

    }
}