package com.belatrixsf.customers.services.impl;

import com.belatrixsf.customers.model.Customer;
import com.belatrixsf.customers.services.repositories.CustomerRepository;
import com.belatrixsf.customers.services.CustomerService;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository repository;


  @Autowired
  public CustomerServiceImpl(CustomerRepository repository) {
    Validate.notNull(repository);
    this.repository = repository;
  }

  @Override
  public Customer getCustomer(Integer id) {
    return repository.findById(id).get();
  }

  @Override
  public List<Customer> searchCustomersByNames(String firstName, String lastName) {
    return repository.findByFirstNameOrLastName(firstName, lastName);
  }

  @Override
  public Customer saveCustomer(Customer newCustomer) {
    return repository.save(newCustomer);
  }

  @Override
  public void deleteCustomer(Integer id) {
    repository.deleteById(id);
  }
}
