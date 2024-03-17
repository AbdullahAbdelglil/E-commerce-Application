package com.ecommerce.pharmacy.DAO;

import com.ecommerce.pharmacy.Entity.Address;
import com.ecommerce.pharmacy.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findByOrder(Order order);
}
