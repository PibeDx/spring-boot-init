package com.jcuentas.app;

import com.jcuentas.app.model.Customer;
import org.hibernate.validator.internal.util.Contracts;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by jcuentas on 11/01/2016.
 */
public class RestClientIntegrationTest extends Assert{

    RestTemplate template = new RestTemplate();

    private static final String BASE_URI = "http://localhost:8080/customers";

    @Test
    public void test_get_all_customers_getForObject(){
//        RestTemplate template = new RestTemplate();
        List<Customer> list = template.getForObject(BASE_URI, List.class);
        assertNotNull(list);
    }

    @Test
    public void test_get_all_customers_getForEntity(){
        ResponseEntity<List> response = template.getForEntity("http://localhost:8080/customers", List.class);
        assertEquals(response.getStatusCode().value(), 200);
    }

    @Test(expected = HttpClientErrorException.class)
    public void test_delete_operation_failed_exception(){
        ResponseEntity<String> response = template.exchange("http://localhost:8080/customers/100", HttpMethod.DELETE, null,String.class);
//        System.out.println(""+response.getStatusCode().is4xxClientError());
//        System.out.println(""+response.getStatusCode());
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test(expected = HttpClientErrorException.class)
    public void test_delete_operation_success(){
        template.delete("http://localhost:8080/customers/1");
        ResponseEntity<Customer> response = template.getForEntity("http://localhost:8080/customers/1", Customer.class);
    }



}
