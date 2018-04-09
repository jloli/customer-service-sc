package com.belatrixsf.customers.services;

import com.belatrixsf.customers.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

  List<Customer> searchCustomersByNames(String firstName, String lastName);

  Customer getCustomer(Integer id);

  Customer saveCustomer(Customer newCustomer);

  void deleteCustomer(Integer id);

}
