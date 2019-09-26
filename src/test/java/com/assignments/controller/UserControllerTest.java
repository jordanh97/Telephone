package com.assignments.controller;

import com.assignments.domain.User;
import com.assignments.factory.UserFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/user";

    @Test
    public void a_create() {

        User user = UserFactory.getUser("1234", "12321", "cell");
        user.setUserId("12132465");
        ResponseEntity<User> postResponse = restTemplate.postForEntity(baseURL + "/new/", user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        User user = restTemplate.getForObject(baseURL + "/find/" + "12132465", User.class);
        assertNotNull(user);
        System.out.println(user.getUserId());

    }

    @Test
    public void c_update() {

        User user = restTemplate.getForObject(baseURL + "/find/" + "12132465", User.class);
        user.setUserSname("Bradley");
        restTemplate.put(baseURL + "/update/" + "12132465", user);
        User updatedUser = restTemplate.getForObject(baseURL + "/update/" + "12132465", User.class);
        assertNotNull(user);
        System.out.println(user);

    }

    @Test
    public void e_delete() {

        User user = restTemplate.getForObject(baseURL + "/find/" + "12132465", User.class);
        assertNotNull(user);
        restTemplate.delete(baseURL + "/delete/" + "12132465");

        try {
            user = restTemplate.getForObject(baseURL + "/find/" + "12132465", User.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admin").exchange(baseURL + "/getall", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());

    }


}