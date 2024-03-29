package com.ecommerce.pharmacy.DAO;

import com.ecommerce.pharmacy.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByEmail(String theEmail);
}
