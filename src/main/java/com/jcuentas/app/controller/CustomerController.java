package com.jcuentas.app.controller;

import com.jcuentas.app.exception.CustomerNotFoundException;
import com.jcuentas.app.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcuentas on 08/01/2016.
 */

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static List<Customer> list = new ArrayList<Customer>();

    static {
        list.add(new Customer(new Long(1), "José Cuentas"));
        list.add(new Customer(new Long(2), "Juan"));
        list.add(new Customer(new Long(3), "Pedro"));
        list.add(new Customer(new Long(4), "Ana"));
        list.add(new Customer(new Long(5), "Lucas"));
    }
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> getAllCustomers(){
        return list;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        list.add(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        for(Customer c: list){
            if (c.getId().equals(id)){
                System.out.println("+: "+id );
                c.setName(customer.getName());
                return new ResponseEntity<Customer>(customer, HttpStatus.OK);
            }
        }
//        list.stream().filter(cu->cu.getId()==id).collect(Collectors.<Customer>toList());
        return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCustomer(@PathVariable("id") Long id){
        Customer rCust=null;
        for(Customer c:list){
            if (c.getId().equals(id)){
                rCust =c;
            }
        }
        if (rCust==null) {
            throw new CustomerNotFoundException();
        }else{
            list.remove(rCust);
        }

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomer(@PathVariable("id") Long id){
        Customer customer=null;
        for (Customer c: list){
            if (c.getId().equals(id)){
                System.out.println("asdasd");
                return c;
            }
        }
        throw new CustomerNotFoundException();
    }
}
