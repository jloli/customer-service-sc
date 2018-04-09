package com.belatrixsf.customers.rest;

import com.belatrixsf.customers.model.Customer;
import com.belatrixsf.customers.services.CustomerService;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private CustomerService service;


  @Autowired
  public CustomerController(CustomerService service) {
    Validate.notNull(service);
    this.service = service;
  }


  @GetMapping(path = "/search")
  public List<Customer> searchCustomers(@RequestParam(required = false) String firstName,
      @RequestParam String lastName) {

    return service.searchCustomersByNames(firstName, lastName);
  }

  @GetMapping("/{id}")
  public Customer getCustomer(@PathVariable Integer id) {
    return service.getCustomer(id);
  }

  @PostMapping
  public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer newCustomer) {
    return new ResponseEntity<>(service.saveCustomer(newCustomer), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Integer id) {
    service.deleteCustomer(id);
  }

}
