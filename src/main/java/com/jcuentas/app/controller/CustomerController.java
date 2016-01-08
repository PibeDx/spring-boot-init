package com.jcuentas.app.controller;

import com.jcuentas.app.model.Customer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public List<Customer> getAllCustomerss(){
        return list;
    }
}
