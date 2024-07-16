package by.digitalchief.ordermanagement.ordermanagement.repository;

import by.digitalchief.ordermanagement.ordermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
