package com.belatrixsf.customers.services.repositories;

import com.belatrixsf.customers.model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  @Override
  Optional<Customer> findById(Integer id);

  List<Customer> findByFirstNameOrLastName(String firstName, String lastName);

  @Override
  Customer save(Customer newCustomer);

  @Override
  void deleteById(Integer id);
}
